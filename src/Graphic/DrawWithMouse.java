package Graphic;

import java.awt.Color;  //drawing color
import java.awt.Graphics;
import java.awt.Point; //points for identifying drawing area
import javax.swing.JColorChooser; 

public class DrawWithMouse extends javax.swing.JFrame {

    Graphics g = null;   //object for drawing
    Point p1 = null, p2 = null;         //2 points represent the drawing area
    Color color = Color.RED;  //current color

    public DrawWithMouse() {
        initComponents();
        g = this.pLines.getGraphics();
        //when the program run, the panel pLines is default.
        //So, the graphic mode is draw only
        this.rdFill.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        tabbed = new javax.swing.JTabbedPane();
        pLines = new javax.swing.JPanel();
        pEllipses = new javax.swing.JPanel();
        pRectangle = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnColor = new javax.swing.JButton();
        rdDraw = new javax.swing.JCheckBox();
        rdFill = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Draw with mouse");

        tabbed.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabbedMouseClicked(evt);
            }
        });

        pLines.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pLinesMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                pLinesMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout pLinesLayout = new javax.swing.GroupLayout(pLines);
        pLines.setLayout(pLinesLayout);
        pLinesLayout.setHorizontalGroup(
            pLinesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 415, Short.MAX_VALUE)
        );
        pLinesLayout.setVerticalGroup(
            pLinesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 210, Short.MAX_VALUE)
        );

        tabbed.addTab("Lines", pLines);

        pEllipses.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pEllipsesMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                pEllipsesMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout pEllipsesLayout = new javax.swing.GroupLayout(pEllipses);
        pEllipses.setLayout(pEllipsesLayout);
        pEllipsesLayout.setHorizontalGroup(
            pEllipsesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 415, Short.MAX_VALUE)
        );
        pEllipsesLayout.setVerticalGroup(
            pEllipsesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 210, Short.MAX_VALUE)
        );

        tabbed.addTab("Ellipses", pEllipses);

        pRectangle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pRectangleMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                pRectangleMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout pRectangleLayout = new javax.swing.GroupLayout(pRectangle);
        pRectangle.setLayout(pRectangleLayout);
        pRectangleLayout.setHorizontalGroup(
            pRectangleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 415, Short.MAX_VALUE)
        );
        pRectangleLayout.setVerticalGroup(
            pRectangleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 210, Short.MAX_VALUE)
        );

        tabbed.addTab("Rectangles", pRectangle);

        btnColor.setText("Select Color");
        btnColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColorActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdDraw);
        rdDraw.setSelected(true);
        rdDraw.setText("Draw Only");

        buttonGroup1.add(rdFill);
        rdFill.setText("Draw and Fill");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnColor, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rdDraw)
                .addGap(18, 18, 18)
                .addComponent(rdFill)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnColor)
                    .addComponent(rdDraw)
                    .addComponent(rdFill))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbed)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabbed))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColorActionPerformed
        color = JColorChooser.showDialog(this, "Choose a color", Color.BLACK);
        g.setColor(color);
    }//GEN-LAST:event_btnColorActionPerformed

    private void tabbedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabbedMouseClicked
        int index = this.tabbed.getSelectedIndex();
        switch (index) {  //update the graphics object
            case 0:
                g = pLines.getGraphics();
                this.rdDraw.setSelected(true);
                this.rdFill.setEnabled(false);
                break;
            case 1:
                g = pEllipses.getGraphics();
                this.rdFill.setEnabled(true);
                break;
            case 2:
                g = pRectangle.getGraphics();
                this.rdFill.setEnabled(true);
                break;
        }
        g.setColor(color);
    }//GEN-LAST:event_tabbedMouseClicked

    private void pLinesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pLinesMousePressed
        p1 = evt.getPoint();  //get the first point
    }//GEN-LAST:event_pLinesMousePressed

    private void pLinesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pLinesMouseReleased
        p2 = evt.getPoint();  //get the second point
        g.drawLine(p1.x, p1.y, p2.x, p2.y);
        p1 = p2 = null;
    }//GEN-LAST:event_pLinesMouseReleased

    private void pEllipsesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pEllipsesMousePressed
        p1 = evt.getPoint();  //get the first point
    }//GEN-LAST:event_pEllipsesMousePressed

    private void pEllipsesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pEllipsesMouseReleased
        p2 = evt.getPoint();  //get the second point
        int left = p1.x < p2.x ? p1.x : p2.x;  //determine the draw area
        int top = p1.y < p2.y ? p1.y : p2.y;
        int width = p1.x - p2.x;
        if (width < 0) {
            width = -width;
        }
        int height = p1.y - p2.y;
        if (height < 0) {
            height = -height;
        }
        if (rdDraw.isSelected()) {
            g.drawOval(left, top, width, height);  //draw
        } else {
            g.fillOval(left, top, width, height); //draw and fill
        }
        p1 = p2 = null;

    }//GEN-LAST:event_pEllipsesMouseReleased

    private void pRectangleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pRectangleMousePressed
        p1 = evt.getPoint();   //get the first point
    }//GEN-LAST:event_pRectangleMousePressed

    private void pRectangleMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pRectangleMouseReleased
        p2 = evt.getPoint(); //get the second point
        int left = p1.x < p2.x ? p1.x : p2.x;//determine the draw area
        int top = p1.y < p2.y ? p1.y : p2.y;
        int width = p1.x - p2.x;
        if (width < 0) {
            width = -width;
        }
        int height = p1.y - p2.y;
        if (height < 0) {
            height = -height;
        }
        if (rdDraw.isSelected()) {
            g.drawRect(left, top, width, height); //draw
        } else {
            g.fillRect(left, top, width, height); //draw and fill
        }
        p1 = p2 = null;
    }//GEN-LAST:event_pRectangleMouseReleased

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
            java.util.logging.Logger.getLogger(DrawWithMouse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DrawWithMouse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DrawWithMouse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DrawWithMouse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DrawWithMouse().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnColor;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel pEllipses;
    private javax.swing.JPanel pLines;
    private javax.swing.JPanel pRectangle;
    private javax.swing.JCheckBox rdDraw;
    private javax.swing.JCheckBox rdFill;
    private javax.swing.JTabbedPane tabbed;
    // End of variables declaration//GEN-END:variables
}
