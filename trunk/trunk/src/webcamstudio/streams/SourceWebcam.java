/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webcamstudio.streams;

import java.awt.image.BufferedImage;
import java.io.File;
import webcamstudio.ffmpeg.FFMPEGRenderer;

/**
 *
 * @author patrick
 */
public class SourceWebcam extends Stream{

    FFMPEGRenderer capture = null;
    String name = "webcam";
    public SourceWebcam(File device){
       capture = new FFMPEGRenderer("webcam");
       capture.setFile(device);
       name = device.getName();
       
    }
        @Override
    public void setWidth(int w ){
        width=w;
        capture.updateFormat(x, y, width, height, opacity, volume);
    }
    @Override
    public void setHeight(int h){
        height=h;
        capture.updateFormat(x, y, width, height, opacity, volume);
    }
    @Override
    public void setZOrder(int z){
        zorder=z;
        capture.setZOrder(z);
    }

    @Override
    public String getName(){
        return name;
    }
    @Override
    public void setOpacity(int opacity){
        this.opacity=opacity;
        capture.setOpacity(opacity);
    }
    @Override
    public void read() {
        capture.setCaptureHeight(captureHeight);
        capture.setCaptureWidth(captureWidth);
        capture.setHeight(height);
        capture.setVolume(volume);
        capture.setWidth(width);
        capture.setRate(rate);
        capture.setSeek(seek);
        capture.setOpacity(opacity);
        capture.read();
    }

    @Override
    public void stop() {
        capture.stop();
    }
    @Override
    public boolean isPlaying() {
        return !capture.isStopped();
    }

    @Override
    public BufferedImage getPreview() {
        return capture.getPreview();
    }
    @Override
    public void setVolume(float v){
        volume=v;
        capture.setVolume(v);
    }
}