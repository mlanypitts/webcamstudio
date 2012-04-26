/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webcamstudio.media.renderer;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;
import webcamstudio.mixers.AudioBuffer;
import webcamstudio.mixers.Frame;
import webcamstudio.mixers.ImageBuffer;
import webcamstudio.mixers.MasterMixer;

/**
 *
 * @author patrick
 */
public class Exporter implements MasterMixer.SinkListener {

    private boolean cancel = false;
    final static int FRAME_LIMIT = 5;
    ServerSocket videoServer = null;
    ServerSocket audioServer = null;
    OutputStream videoOutput = null;
    OutputStream audioOutput = null;
    int aport = 0;
    int vport = 0;
    ImageBuffer imageBuffer = null;
    AudioBuffer audioBuffer = null;
    long vCounter = 0;
    long aCounter = 0;

    public Exporter() {
        imageBuffer = new ImageBuffer(MasterMixer.getInstance().getWidth(),MasterMixer.getInstance().getHeight());
        audioBuffer = new AudioBuffer(MasterMixer.getInstance().getRate());

        try {
            videoServer = new ServerSocket(0);
            vport = videoServer.getLocalPort();
        } catch (IOException ex) {
            Logger.getLogger(Exporter.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            audioServer = new ServerSocket(0);
            aport = audioServer.getLocalPort();
        } catch (IOException ex) {
            Logger.getLogger(Exporter.class.getName()).log(Level.SEVERE, null, ex);
        }
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    Socket connection = videoServer.accept();
                    System.out.println("Video output accepted");
                    videoOutput = connection.getOutputStream();
                    imageBuffer.clear();
                    byte[] data = new byte[MasterMixer.getInstance().getWidth() * MasterMixer.getInstance().getHeight() * 4];
                    while (!cancel) {
                        BufferedImage image = imageBuffer.pop();
                        if (image != null) {
                            ByteBuffer buffer = ByteBuffer.wrap(data);
                            IntBuffer iBuffer = buffer.asIntBuffer();
                            int[] imgData = new int[data.length / 4];
                            image.getRGB(0, 0, image.getWidth(), image.getHeight(), imgData, 0, image.getWidth());
                            iBuffer.put(imgData);
                            vCounter++;
                            if (videoOutput != null) {
                                videoOutput.write(data);
                            } else {
                                cancel = true;
                            }
                        }
                    }
                } catch (IOException ex) {
                    cancel = true;
                    imageBuffer.abort();
                    //Logger.getLogger(Exporter.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("Video output stopped");
            }
        }).start();
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {

                    Socket connection = audioServer.accept();
                    System.out.println("Audio output accepted");
                    audioOutput = connection.getOutputStream();
                    audioBuffer.clear();
                    while (!cancel) {
                        byte[] audioData = audioBuffer.pop();
                        if (audioData != null) {
                            audioOutput.write(audioData);
                            aCounter++;
                            audioData = null;
                        }
                    }

                } catch (IOException ex) {
                    cancel = true;
                    audioBuffer.abort();
                    //Logger.getLogger(Exporter.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("Audio output stopped");
            }
        }).start();
        cancel = false;
        MasterMixer.getInstance().register(this);

    }

    public void abort() {
        cancel = true;
        System.out.println("Output aborted...");
        MasterMixer.getInstance().unregister(this);
        imageBuffer.abort();
        audioBuffer.abort();
        System.out.println("V: " +vCounter);
        System.out.println("A: " +aCounter);
        if (videoServer != null) {
            try {
                videoServer.close();
                videoOutput.close();
                videoOutput = null;
            } catch (IOException ex) {
                Logger.getLogger(Exporter.class.getName()).log(Level.SEVERE, null, ex);
            }
            videoServer = null;
        }
        if (audioServer != null) {
            try {
                audioServer.close();
                audioOutput.close();
                audioOutput = null;
            } catch (IOException ex) {
                Logger.getLogger(Exporter.class.getName()).log(Level.SEVERE, null, ex);
            }
            audioServer = null;
        }
    }

    public int getAudioPort() {
        return aport;
    }

    public int getVideoPort() {
        return vport;
    }

    @Override
    public void newFrame(Frame frame) {
        imageBuffer.push(frame.getImage());
        audioBuffer.push(frame.getAudioData());
    }
}