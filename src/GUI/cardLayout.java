/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author ASUS
 */
public class cardLayout extends javax.swing.JFrame {

    /**
     * Creates new form cardLayout
     */
    public cardLayout() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pParrent = new javax.swing.JPanel();
        pRed = new javax.swing.JPanel();
        pBlue = new javax.swing.JPanel();
        pYellow = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnRed = new javax.swing.JButton();
        btnBlue = new javax.swing.JButton();
        btnYellow = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pParrent.setBackground(new java.awt.Color(0, 153, 153));
        pParrent.setLayout(new java.awt.CardLayout());

        pRed.setBackground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout pRedLayout = new javax.swing.GroupLayout(pRed);
        pRed.setLayout(pRedLayout);
        pRedLayout.setHorizontalGroup(
            pRedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        pRedLayout.setVerticalGroup(
            pRedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );

        pParrent.add(pRed, "card2");

        pBlue.setBackground(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout pBlueLayout = new javax.swing.GroupLayout(pBlue);
        pBlue.setLayout(pBlueLayout);
        pBlueLayout.setHorizontalGroup(
            pBlueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        pBlueLayout.setVerticalGroup(
            pBlueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );

        pParrent.add(pBlue, "card3");

        pYellow.setBackground(new java.awt.Color(255, 255, 0));

        javax.swing.GroupLayout pYellowLayout = new javax.swing.GroupLayout(pYellow);
        pYellow.setLayout(pYellowLayout);
        pYellowLayout.setHorizontalGroup(
            pYellowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        pYellowLayout.setVerticalGroup(
            pYellowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );

        pParrent.add(pYellow, "card4");

        getContentPane().add(pParrent, java.awt.BorderLayout.CENTER);

        jPanel2.setBackground(new java.awt.Color(0, 255, 0));

        btnRed.setText("RED");
        btnRed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRedActionPerformed(evt);
            }
        });

        btnBlue.setText("BLUE");
        btnBlue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBlueActionPerformed(evt);
            }
        });

        btnYellow.setText("YELLOW");
        btnYellow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnYellowActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(btnRed, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addComponent(btnBlue)
                .addGap(57, 57, 57)
                .addComponent(btnYellow)
                .addGap(31, 31, 31))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRed)
                    .addComponent(btnBlue)
                    .addComponent(btnYellow))
                .addGap(37, 37, 37))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRedActionPerformed
        pParrent.removeAll();
        pParrent.add(pRed);
        pParrent.repaint();
        pParrent.revalidate();
    }//GEN-LAST:event_btnRedActionPerformed

    private void btnBlueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBlueActionPerformed
        pParrent.removeAll();
        pParrent.add(pBlue);
        pParrent.repaint();
        pParrent.revalidate();
    }//GEN-LAST:event_btnBlueActionPerformed

    private void btnYellowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnYellowActionPerformed
        pParrent.removeAll();
        pParrent.add(pYellow);
        pParrent.repaint();
        pParrent.revalidate();
    }//GEN-LAST:event_btnYellowActionPerformed

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
            java.util.logging.Logger.getLogger(cardLayout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cardLayout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cardLayout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cardLayout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cardLayout().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBlue;
    private javax.swing.JButton btnRed;
    private javax.swing.JButton btnYellow;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel pBlue;
    private javax.swing.JPanel pParrent;
    private javax.swing.JPanel pRed;
    private javax.swing.JPanel pYellow;
    // End of variables declaration//GEN-END:variables
}
