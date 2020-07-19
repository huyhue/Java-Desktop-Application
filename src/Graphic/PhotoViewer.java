package Graphic;

import java.awt.Graphics;  //graphic object
import java.awt.image.BufferedImage;  //image in memory
import java.io.File;  //file processing
import java.util.Vector; //list of filenames
import javax.imageio.ImageIO; //for loading image
import javax.swing.JFileChooser; //for getting files
import javax.swing.JOptionPane;  //system dialog
import javax.swing.filechooser.FileNameExtensionFilter;

public class PhotoViewer extends javax.swing.JFrame {

    boolean autoSlide = false; //view mode
    int rate = 0; //rate of auto sliding
    BufferedImage currentImage = null;
    JFileChooser fChooser = new JFileChooser();
    Vector<String> list = new Vector<String>();  //list of filenames
    int x = 10, y = 20;  //drawing position
    int imgIndex = -1;  //index of image in the list
    Graphics g = null;  //graphics object
    TimeThread timeCounter;  //thread for sliding images (auto sliding throught a thread)

    public PhotoViewer() {
        initComponents();
//        this.setSize(1000, 600);
        //setup filter for image files to the file chooser
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Image files", "GIF", "JPG", "JPEG", "PNG");
        fChooser.setFileFilter(filter);
        //user can selects some files
        fChooser.setMultiSelectionEnabled(true);
        //drawing on pView, get it's graphic object
        g = this.pView.getGraphics();
        //Initially, user can not select auto-sliding mode
        this.sldRate.setEnabled(false);
        //default rate of sliding = 1 images/sec
        this.sldRate.setValue(1);
    }

    //loading selected image file to the currentImage object
    private void loadImage() {
        //Gt filename
        String filename = list.elementAt(imgIndex);
        try {  //load image file
            currentImage = ImageIO.read(new File(filename));
        } catch (Exception e) {
            currentImage = null;
            JOptionPane.showMessageDialog(this, e);
        }
    }

    //show currentImage to the panel pView
    private void showImage() {
        if (currentImage != null) {  //calcular the drawing position
            g.clearRect(x, y, pView.getWidth() - x, pView.getHeight() - y); //clear old image
            int imgWidth = currentImage.getWidth();//get real image size
            int imgHeight = currentImage.getHeight();
            double ratio = 1.0 * imgWidth / imgHeight; 
            int areaWidth = this.pView.getWidth() - 2 * x;  //area for showing
            int areaHeight = this.pView.getHeight() - 2 * y;
            //the image is narrower than drawing area
            if (imgWidth <= areaWidth && imgHeight <= areaHeight) {
                areaWidth = imgWidth;
                areaHeight = imgHeight;
            } else if (imgWidth > imgHeight) { //horizontal image
                if (imgWidth < areaWidth) {
                    areaWidth = imgWidth;
                }
                areaHeight = (int) (areaWidth / ratio);
            } else {   //vertical image
                if (imgHeight < areaHeight) {
                    areaHeight = imgHeight;
                }
                areaWidth = (int) (areaHeight * ratio);
            }
            g.drawImage(currentImage, x, y, areaWidth, areaHeight, this.pView);

        }
    }

    //Inner class -Thread for auto-sliding
    class TimeThread extends Thread {

        @Override
        public void run() {
            imgIndex = lstFiles.getSelectedIndex();
            int n = lstFiles.getModel().getSize();  //number of files
            if (n > 0 && autoSlide) {  //auto-slide condition
                while (imgIndex < n) {  //sliding to the end of the list
                    try {
                        loadImage();
                        showImage();
                        imgIndex++;
                        sleep(1000 * rate); //1000 = 1 sec
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
                }
            }
        }
    }

    //Sliding images
    private void slidingImage() {
        timeCounter = new TimeThread(); //create a thread
        timeCounter.start();  //the thread runs
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pControl = new javax.swing.JPanel();
        btnAddFile = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstFiles = new javax.swing.JList<>(list);
        btnRemove = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        chkOnOff = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        sldRate = new javax.swing.JSlider();
        pView = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Photo Viewer");

        pControl.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Control Panel", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 204))); // NOI18N

        btnAddFile.setText("Add Image Files");
        btnAddFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddFileActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel1.setText("Current Files");

        lstFiles.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstFiles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstFilesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(lstFiles);

        btnRemove.setText("Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Auto Sliding", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 153))); // NOI18N

        jLabel2.setText("On/Off");

        chkOnOff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chkOnOffMouseClicked(evt);
            }
        });

        jLabel3.setText("seconds/image");

        sldRate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                sldRateMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(30, 30, 30)
                        .addComponent(chkOnOff))
                    .addComponent(sldRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(chkOnOff))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sldRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout pControlLayout = new javax.swing.GroupLayout(pControl);
        pControl.setLayout(pControlLayout);
        pControlLayout.setHorizontalGroup(
            pControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pControlLayout.createSequentialGroup()
                .addGroup(pControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pControlLayout.createSequentialGroup()
                        .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnAddFile, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pControlLayout.setVerticalGroup(
            pControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pControlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAddFile)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRemove)
                    .addComponent(btnClear))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pView.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "View Panel", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 204)))); // NOI18N
        pView.setPreferredSize(new java.awt.Dimension(1000, 80));

        javax.swing.GroupLayout pViewLayout = new javax.swing.GroupLayout(pView);
        pView.setLayout(pViewLayout);
        pViewLayout.setHorizontalGroup(
            pViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 722, Short.MAX_VALUE)
        );
        pViewLayout.setVerticalGroup(
            pViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pControl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pView, javax.swing.GroupLayout.DEFAULT_SIZE, 734, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pControl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pView, javax.swing.GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddFileActionPerformed
        //getting image filenames
        int returnVal = fChooser.showOpenDialog(this);  //open file dialog
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File[] files = fChooser.getSelectedFiles();
            for (File f : files) {
                list.add(f.getAbsolutePath());
            }
            lstFiles.setSelectedIndex(0);  //the first filename
            this.lstFiles.updateUI();
        }
    }//GEN-LAST:event_btnAddFileActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        //remove an image from the list
        int[] indices = lstFiles.getSelectedIndices();
        for (int i = indices.length - 1; i >= 0; i--) {
            list.removeElementAt(i);
        }
        lstFiles.updateUI();
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        list.removeAllElements();
        lstFiles.updateUI();
    }//GEN-LAST:event_btnClearActionPerformed

    private void lstFilesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstFilesMouseClicked
        //show image
        imgIndex = lstFiles.getSelectedIndex();
        this.loadImage();
        this.showImage();
    }//GEN-LAST:event_lstFilesMouseClicked

    private void chkOnOffMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chkOnOffMouseClicked
        //change view mode
        if (chkOnOff.isSelected() && lstFiles.getSelectedIndex() >= 0) {
            this.autoSlide = true;
            this.sldRate.setEnabled(true);
            this.rate = this.sldRate.getValue();
            slidingImage();
        } else {
            if (timeCounter != null) {
                timeCounter = null;
            }
            autoSlide = false;
            this.sldRate.setEnabled(false);
        }
    }//GEN-LAST:event_chkOnOffMouseClicked

    private void sldRateMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sldRateMouseReleased
        this.rate = sldRate.getValue();
    }//GEN-LAST:event_sldRateMouseReleased

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
            java.util.logging.Logger.getLogger(PhotoViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PhotoViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PhotoViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PhotoViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PhotoViewer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddFile;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnRemove;
    private javax.swing.JCheckBox chkOnOff;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> lstFiles;
    private javax.swing.JPanel pControl;
    private javax.swing.JPanel pView;
    private javax.swing.JSlider sldRate;
    // End of variables declaration//GEN-END:variables
}
