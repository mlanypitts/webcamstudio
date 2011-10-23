/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webcamstudio.ffmpeg;

import java.io.File;
import java.net.URL;

/**
 *
 * @author patrick
 */
public class FFMPEGMusic extends FFMPEGAbstract{
    
    public FFMPEGMusic(){
        sourceFormat="";
        sinkFormat = "";
        sinkOutput = "";
        sinkAudio = "-f alsa pulse";
    }
    
    @Override
    public void setInput(String input){
        sourceInput = input;
    }
    public void setInput(File input){
        sourceInput = input.getAbsolutePath();
    }
    public void setInput(URL input){
        sourceInput = input.toString();
    }
}
