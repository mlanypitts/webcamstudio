/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * WebcamStudio.java
 *
 * Created on 4-Apr-2012, 3:48:07 PM
 */
package webcamstudio;

import java.awt.BorderLayout;
import java.awt.datatransfer.DataFlavor;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDropEvent;
import java.io.File;
import java.net.URL;
import javax.swing.ImageIcon;
import webcamstudio.components.MasterPanel;
import webcamstudio.components.StreamPanel;
import webcamstudio.exporter.vloopback.VideoDevice;
import webcamstudio.mixers.MasterMixer;
import webcamstudio.streams.SinkBroadcast;
import webcamstudio.streams.SinkFile;
import webcamstudio.streams.SourceWebcam;
import webcamstudio.streams.Stream;

/**
 *
 * @author patrick
 */
public class WebcamStudio extends javax.swing.JFrame {

    /** Creates new form WebcamStudio */
    public WebcamStudio() {
        initComponents();
        MasterMixer.start();
        ImageIcon icon = new ImageIcon(this.getClass().getResource("/webcamstudio/resources/icon.png"));
        this.setIconImage(icon.getImage());

        panSources.add(new MasterPanel(), BorderLayout.WEST);
        for (VideoDevice d : VideoDevice.getOutputDevices()) {
            Stream webcam = new SourceWebcam(d.getFile());
            StreamPanel p = new StreamPanel(webcam);
            panScrollingSources.add(p, 0);

        }
        scrollSources.revalidate();
        panScrollingSources.revalidate();
        panScrollingSources.setDropTarget(new DropTarget() {

            public synchronized void drop(DropTargetDropEvent evt) {
                try {
                    evt.acceptDrop(DnDConstants.ACTION_REFERENCE);
                    String files = evt.getTransferable().getTransferData(DataFlavor.stringFlavor).toString();
                    String[] lines = files.split("\n");
                    for (String line : lines) {
                        File file = new File(new URL(line.trim()).toURI());
                        if (file.exists()) {
                            Stream stream = Stream.getInstance(file);
                            if (stream != null) {
                                StreamPanel panel = new StreamPanel(stream);
                                panel.setVisible(true);
                                panScrollingSources.add(panel, 0);
                                scrollSources.revalidate();
                                panScrollingSources.revalidate();
                            }
                        }
                    }


                    evt.dropComplete(true);

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        pack();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panSources = new javax.swing.JPanel();
        scrollSources = new javax.swing.JScrollPane();
        panScrollingSources = new javax.swing.JPanel();
        panChannels = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("WebcamStudio");

        panSources.setMinimumSize(new java.awt.Dimension(400, 400));
        panSources.setName("panSources"); // NOI18N
        panSources.setLayout(new java.awt.BorderLayout());

        scrollSources.setName("scrollSources"); // NOI18N

        panScrollingSources.setName("panScrollingSources"); // NOI18N
        panScrollingSources.setLayout(new javax.swing.BoxLayout(panScrollingSources, javax.swing.BoxLayout.X_AXIS));
        scrollSources.setViewportView(panScrollingSources);

        panSources.add(scrollSources, java.awt.BorderLayout.CENTER);

        getContentPane().add(panSources, java.awt.BorderLayout.CENTER);

        panChannels.setName("panChannels"); // NOI18N

        jButton1.setText("Record");
        jButton1.setName("jButton1"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panChannelsLayout = new javax.swing.GroupLayout(panChannels);
        panChannels.setLayout(panChannelsLayout);
        panChannelsLayout.setHorizontalGroup(
            panChannelsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 61, Short.MAX_VALUE)
            .addGroup(panChannelsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panChannelsLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jButton1)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        panChannelsLayout.setVerticalGroup(
            panChannelsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 415, Short.MAX_VALUE)
            .addGroup(panChannelsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panChannelsLayout.createSequentialGroup()
                    .addGap(0, 192, Short.MAX_VALUE)
                    .addComponent(jButton1)
                    .addGap(0, 193, Short.MAX_VALUE)))
        );

        getContentPane().add(panChannels, java.awt.BorderLayout.WEST);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        SinkFile sink = new SinkFile(new File("/home/patrick/Desktop/test.ogv"));
        sink.setWidth(MasterMixer.getWidth());
        sink.setHeight(MasterMixer.getHeight());
        sink.setRate(MasterMixer.getRate());
        sink.read();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(WebcamStudio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WebcamStudio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WebcamStudio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WebcamStudio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new WebcamStudio().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel panChannels;
    private javax.swing.JPanel panScrollingSources;
    private javax.swing.JPanel panSources;
    private javax.swing.JScrollPane scrollSources;
    // End of variables declaration//GEN-END:variables
}
