/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webcamstudio.sources.effects;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author pballeux
 */
public abstract class Effect {
    protected boolean needApply=true;

    public boolean needApply(){
        return needApply;
    }
    public abstract void applyEffect(BufferedImage img);
    public abstract void applyStudioConfig(java.util.prefs.Preferences prefs);
    public abstract void loadFromStudioConfig(java.util.prefs.Preferences prefs);
    public abstract javax.swing.JPanel getControl();
    public static java.util.TreeMap<String, Effect> getEffects() {
        java.util.TreeMap<String, Effect> retValue = new java.util.TreeMap<>();
        retValue.put(FlipHorizontal.class.getSimpleName(), new FlipHorizontal());
        retValue.put(FlipVertical.class.getSimpleName(), new FlipVertical());
        retValue.put(Mirror1.class.getSimpleName(), new Mirror1());
        retValue.put(Mirror2.class.getSimpleName(), new Mirror2());
        retValue.put(Mirror3.class.getSimpleName(), new Mirror3());
        retValue.put(Mirror4.class.getSimpleName(), new Mirror4());
        retValue.put(Mosaic.class.getSimpleName(), new Mosaic());
        retValue.put(Cartoon.class.getSimpleName(), new Cartoon());
        retValue.put(Gray.class.getSimpleName(), new Gray());
        retValue.put(Block.class.getSimpleName(), new Block());
        retValue.put(Emboss.class.getSimpleName(), new Emboss());
        retValue.put(Watercolor.class.getSimpleName(), new Watercolor());
        retValue.put(FilterTest2.class.getSimpleName(), new FilterTest2());
        retValue.put(ChromaKey.class.getSimpleName(), new ChromaKey());
        retValue.put(Contrast.class.getSimpleName(), new Contrast());
        retValue.put(SwapRedBlue.class.getSimpleName(), new SwapRedBlue());
        retValue.put(Perspective.class.getSimpleName(), new Perspective());
        retValue.put(Rotation.class.getSimpleName(), new Rotation());
        retValue.put(Opacity.class.getSimpleName(), new Opacity());
        retValue.put(NoBackground.class.getSimpleName(), new NoBackground());
        retValue.put(RGB.class.getSimpleName(), new RGB());
        retValue.put(ZoomZoom.class.getSimpleName(), new ZoomZoom());
        retValue.put(MegaMind.class.getSimpleName(), new MegaMind());
        retValue.put(Edge.class.getSimpleName(), new Edge());
        retValue.put(Radar.class.getSimpleName(), new Radar());
        retValue.put(Blink.class.getSimpleName(), new Blink());
        retValue.put(Gain.class.getSimpleName(), new Gain());
        retValue.put(Blur.class.getSimpleName(), new Blur());
        retValue.put(Weave.class.getSimpleName(), new Weave());
        retValue.put(Laplace.class.getSimpleName(), new Laplace());
        retValue.put(FaceDetectorAlpha.class.getSimpleName(), new FaceDetectorAlpha());
        retValue.put(Green.class.getSimpleName(), new Green());
        retValue.put(Erode.class.getSimpleName(), new Erode());
        retValue.put(Sharpen.class.getSimpleName(), new Sharpen());
        
        return retValue;
    }
    public BufferedImage cloneImage(BufferedImage src){
        BufferedImage tempimage = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration().createCompatibleImage(src.getWidth(), src.getHeight(), java.awt.image.BufferedImage.TRANSLUCENT);
        Graphics2D tempbuffer = tempimage.createGraphics();
        tempbuffer.setRenderingHint(java.awt.RenderingHints.KEY_RENDERING,
                           java.awt.RenderingHints.VALUE_RENDER_SPEED);
        tempbuffer.setRenderingHint(java.awt.RenderingHints.KEY_ANTIALIASING,
                           java.awt.RenderingHints.VALUE_ANTIALIAS_OFF);
        tempbuffer.setRenderingHint(java.awt.RenderingHints.KEY_TEXT_ANTIALIASING,
                           java.awt.RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
        tempbuffer.setRenderingHint(java.awt.RenderingHints.KEY_FRACTIONALMETRICS,
                           java.awt.RenderingHints.VALUE_FRACTIONALMETRICS_OFF);
        tempbuffer.setRenderingHint(java.awt.RenderingHints.KEY_COLOR_RENDERING,
                           java.awt.RenderingHints.VALUE_COLOR_RENDER_SPEED);
        tempbuffer.setRenderingHint(java.awt.RenderingHints.KEY_DITHERING,
                           java.awt.RenderingHints.VALUE_DITHER_DISABLE);
//        tempbuffer.clearRect(0, 0, src.getWidth(), src.getHeight());
        tempbuffer.drawImage(src, 0, 0, null);
        tempbuffer.dispose();
        return tempimage;
    }
    public String getName(){
        return getClass().getSimpleName();
    }
    @Override
    public String toString(){
        return getClass().getSimpleName();
    }
}
