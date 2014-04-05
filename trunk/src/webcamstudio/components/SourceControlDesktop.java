/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SourceControlDesktop.java
 *
 * Created on 23-Apr-2012, 10:16:29 AM
 */
package webcamstudio.components;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SpinnerNumberModel;
import webcamstudio.streams.SourceDesktop;
import webcamstudio.util.Tools;

/**
 *
 * @author patrick (modified by karl)
 */
public class SourceControlDesktop extends javax.swing.JPanel {

    SourceDesktop source = null;
    ArrayList<String> xidList = new ArrayList<>();
    ArrayList<String> deskList = new ArrayList<>();
    /** Creates new form SourceControlDesktop
     * @param source */
    public SourceControlDesktop(SourceDesktop source) {
        initComponents();
        this.source=source;
        setName("Desktop");
        SpinnerNumberModel model = new SpinnerNumberModel(0, 0, 3000, 1);
        spinX.setModel(model);
        model = new SpinnerNumberModel(0, 0, 3000, 1);
        spinY.setModel(model);
        model = new SpinnerNumberModel(0, 0, 3000, 1);
        spinH.setModel(model);
        model = new SpinnerNumberModel(0, 0, 3000, 1);
        spinW.setModel(model);
        spinX.setValue(source.getDesktopX());
        spinY.setValue(source.getDesktopY());
        spinW.setValue(source.getDesktopW());
        spinH.setValue(source.getDesktopH());
        initCapWindows();
        if ("GS".equals(source.getComm())){
            jchEnableWindowsCap.setSelected(source.getSingleWindow());
            if (source.getSingleWindow()){
                lblDesktopX.setEnabled(false);
                spinX.setEnabled(false);
                lblDesktopY.setEnabled(false);
                spinY.setEnabled(false);
                lblDesktopW.setEnabled(false);
                spinW.setEnabled(false);
                lblDesktopH.setEnabled(false);
                spinH.setEnabled(false);
                jcbWindowsCapList.setEnabled(true);
                lblWindowsCap.setEnabled(true);
                btnRefreshWindowsList.setEnabled(true);
            } else {
                lblDesktopX.setEnabled(true);
                spinX.setEnabled(true);
                lblDesktopY.setEnabled(true);
                spinY.setEnabled(true);
                lblDesktopW.setEnabled(true);
                spinW.setEnabled(true);
                lblDesktopH.setEnabled(true);
                spinH.setEnabled(true);
                jcbWindowsCapList.setEnabled(false);
                lblWindowsCap.setEnabled(false);
                btnRefreshWindowsList.setEnabled(false);
            }
        } else {
            lblDesktopX.setEnabled(true);
            spinX.setEnabled(true);
            lblDesktopY.setEnabled(true);
            spinY.setEnabled(true);
            lblDesktopW.setEnabled(true);
            spinW.setEnabled(true);
            lblDesktopH.setEnabled(true);
            spinH.setEnabled(true);
            jcbWindowsCapList.setEnabled(false);
            lblWindowsCap.setEnabled(false);
            btnRefreshWindowsList.setEnabled(false);
            jchEnableWindowsCap.setSelected(false);
            source.setSingleWindow(false);
            source.setDesktopXid("");
            source.setElementXid("");
            source.setDesktopN("0");
        }
        if (source.getElementXid() != ""){
            jcbWindowsCapList.setSelectedItem(source.getElementXid());
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        lblDesktopX = new javax.swing.JLabel();
        lblDesktopY = new javax.swing.JLabel();
        lblDesktopW = new javax.swing.JLabel();
        lblDesktopH = new javax.swing.JLabel();
        spinX = new javax.swing.JSpinner();
        spinY = new javax.swing.JSpinner();
        spinW = new javax.swing.JSpinner();
        spinH = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        spinN = new javax.swing.JSpinner();
        lblWindowsCap = new javax.swing.JLabel();
        jcbWindowsCapList = new javax.swing.JComboBox();
        jchEnableWindowsCap = new javax.swing.JCheckBox();
        btnRefreshWindowsList = new javax.swing.JButton();

        jButton2.setText("jButton2");
        jButton2.setName("jButton2"); // NOI18N

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("webcamstudio/Languages"); // NOI18N
        lblDesktopX.setText(bundle.getString("DESKTOP_CAPTURE_X")); // NOI18N
        lblDesktopX.setName("lblDesktopX"); // NOI18N

        lblDesktopY.setText(bundle.getString("DESKTOP_CAPTURE_Y")); // NOI18N
        lblDesktopY.setName("lblDesktopY"); // NOI18N

        lblDesktopW.setText(bundle.getString("DESKTOP_CAPTURE_WIDTH")); // NOI18N
        lblDesktopW.setName("lblDesktopW"); // NOI18N

        lblDesktopH.setText(bundle.getString("DESKTOP_CAPTURE_HEIGHT")); // NOI18N
        lblDesktopH.setName("lblDesktopH"); // NOI18N

        spinX.setName("spinX"); // NOI18N
        spinX.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinXStateChanged(evt);
            }
        });

        spinY.setName("spinY"); // NOI18N
        spinY.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinYStateChanged(evt);
            }
        });

        spinW.setName("spinW"); // NOI18N
        spinW.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinWStateChanged(evt);
            }
        });

        spinH.setName("spinH"); // NOI18N
        spinH.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinHStateChanged(evt);
            }
        });

        jLabel5.setText(bundle.getString("DESKTOP_CAPTURE_NUMBER")); // NOI18N
        jLabel5.setEnabled(false);
        jLabel5.setName("jLabel5"); // NOI18N

        spinN.setEnabled(false);
        spinN.setName("spinN"); // NOI18N
        spinN.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinNStateChanged(evt);
            }
        });

        lblWindowsCap.setText(bundle.getString("DESKTOP_CAPTURE_WINDOW")); // NOI18N
        lblWindowsCap.setEnabled(false);
        lblWindowsCap.setName("lblWindowsCap"); // NOI18N

        jcbWindowsCapList.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbWindowsCapList.setEnabled(false);
        jcbWindowsCapList.setName("jcbWindowsCapList"); // NOI18N
        jcbWindowsCapList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbWindowsCapListActionPerformed(evt);
            }
        });

        jchEnableWindowsCap.setText("Enable Single Window Capture");
        jchEnableWindowsCap.setToolTipText("Only with GStreamer BackEnd");
        jchEnableWindowsCap.setName("jchEnableWindowsCap"); // NOI18N
        jchEnableWindowsCap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jchEnableWindowsCapActionPerformed(evt);
            }
        });

        btnRefreshWindowsList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/webcamstudio/resources/tango/view-refresh.png"))); // NOI18N
        btnRefreshWindowsList.setToolTipText("Refresh Windows List");
        btnRefreshWindowsList.setEnabled(false);
        btnRefreshWindowsList.setPreferredSize(new java.awt.Dimension(28, 28));
        btnRefreshWindowsList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshWindowsListActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDesktopX)
                            .addComponent(lblDesktopY)
                            .addComponent(lblDesktopW)
                            .addComponent(lblDesktopH)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(spinN)
                            .addComponent(spinH, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                            .addComponent(spinY, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                            .addComponent(spinX, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                            .addComponent(spinW, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jchEnableWindowsCap)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblWindowsCap)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbWindowsCapList, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(2, 2, 2)
                        .addComponent(btnRefreshWindowsList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDesktopX)
                    .addComponent(spinX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDesktopY)
                    .addComponent(spinY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDesktopW)
                    .addComponent(spinW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDesktopH)
                    .addComponent(spinH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jchEnableWindowsCap)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcbWindowsCapList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblWindowsCap)))
                    .addComponent(btnRefreshWindowsList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void spinXStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinXStateChanged
        source.setDesktopX((Integer)spinX.getValue());
    }//GEN-LAST:event_spinXStateChanged

    private void spinYStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinYStateChanged
        source.setDesktopY((Integer)spinY.getValue());
    }//GEN-LAST:event_spinYStateChanged

    private void spinWStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinWStateChanged
        source.setDesktopW((Integer)spinW.getValue());
    }//GEN-LAST:event_spinWStateChanged

    private void spinHStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinHStateChanged
        source.setDesktopH((Integer)spinH.getValue());
    }//GEN-LAST:event_spinHStateChanged

    private void spinNStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinNStateChanged
//        source.setDesktopN((Integer)spinN.getValue());
    }//GEN-LAST:event_spinNStateChanged

    private void jchEnableWindowsCapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jchEnableWindowsCapActionPerformed
        if (jchEnableWindowsCap.isSelected()){
            lblDesktopX.setEnabled(false);
            spinX.setEnabled(false);
            lblDesktopY.setEnabled(false);
            spinY.setEnabled(false);
            lblDesktopW.setEnabled(false);
            spinW.setEnabled(false);
            lblDesktopH.setEnabled(false);
            spinH.setEnabled(false);
            jcbWindowsCapList.setEnabled(true);
            lblWindowsCap.setEnabled(true);
            btnRefreshWindowsList.setEnabled(true);
            source.setSingleWindow(true);
        } else {
            lblDesktopX.setEnabled(true);
            spinX.setEnabled(true);
            lblDesktopY.setEnabled(true);
            spinY.setEnabled(true);
            lblDesktopW.setEnabled(true);
            spinW.setEnabled(true);
            lblDesktopH.setEnabled(true);
            spinH.setEnabled(true);
            jcbWindowsCapList.setEnabled(false);
            lblWindowsCap.setEnabled(false);
            btnRefreshWindowsList.setEnabled(false);
            source.setSingleWindow(false);
            source.setDesktopXid("");
            source.setElementXid("");
            source.setDesktopN("0");
        }
    }//GEN-LAST:event_jchEnableWindowsCapActionPerformed

    private void jcbWindowsCapListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbWindowsCapListActionPerformed
        String elementXid = jcbWindowsCapList.getSelectedItem().toString();
        String[] getXid = null;
        for (int i=0 ; i < xidList.size() ; i++){
            if (xidList.get(i).contains(elementXid)){
                getXid = xidList.get(i).split(" ");
                source.setDesktopXid(getXid[0]);
                source.setElementXid(elementXid);
                source.setDesktopN(deskList.get(i));
            }
        }
    }//GEN-LAST:event_jcbWindowsCapListActionPerformed

    private void btnRefreshWindowsListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshWindowsListActionPerformed
        initCapWindows();
    }//GEN-LAST:event_btnRefreshWindowsListActionPerformed
    
    @SuppressWarnings("unchecked")
    private void initCapWindows() {
        Runtime rt = Runtime.getRuntime();
        String getAllWindowsComm = "wmctrl -l";
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        
        try {
            Process getAllWindowsList = rt.exec(getAllWindowsComm);
            Tools.sleep(10);
            getAllWindowsList.waitFor(); //Author spoonybard896
            BufferedReader buf = new BufferedReader(new InputStreamReader(
            getAllWindowsList.getInputStream()));
            String line = "";
            while ((line = buf.readLine()) != null) {
                System.out.println("Windows: "+line);
                line = line.replaceAll("  ", " ");
                String[] window = line.split(" ");
                String windowRest = "";
                for (int i = 3; i < window.length ; i++) {
                    windowRest += window[i];
                }
                model.addElement(windowRest);
                xidList.add(window[0]+" "+windowRest);
                String desktop = window[1];
//                System.out.println("desktop: "+desktop);
                deskList.add(desktop);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }       
        jcbWindowsCapList.setModel(model);
        if ("GS".equals(source.getComm())){
            jchEnableWindowsCap.setEnabled(true);
        } else {
            jchEnableWindowsCap.setEnabled(false);
        }
        
    }
    
//    private String getSelectedWindowXid() {    
//        String[] xid = jcbWindowsCapList.getSelectedItem().toString().split(" ");
//        return xid[0];   
//    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRefreshWindowsList;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JComboBox jcbWindowsCapList;
    private javax.swing.JCheckBox jchEnableWindowsCap;
    private javax.swing.JLabel lblDesktopH;
    private javax.swing.JLabel lblDesktopW;
    private javax.swing.JLabel lblDesktopX;
    private javax.swing.JLabel lblDesktopY;
    private javax.swing.JLabel lblWindowsCap;
    private javax.swing.JSpinner spinH;
    private javax.swing.JSpinner spinN;
    private javax.swing.JSpinner spinW;
    private javax.swing.JSpinner spinX;
    private javax.swing.JSpinner spinY;
    // End of variables declaration//GEN-END:variables
}