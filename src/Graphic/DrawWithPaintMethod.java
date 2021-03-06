package Graphic;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class DrawWithPaintMethod extends javax.swing.JFrame {
    public DrawWithPaintMethod() {
        initComponents();
    }

    @Override
    public void paint(Graphics g) {
        //The area will be filled with the color BLACK
        int x = this.getContentPane().getX();
        int y = this.getContentPane().getX();
        int w = this.getContentPane().getWidth() + 10;
        int h = this.getContentPane().getHeight() + 10;
        setBackground(Color.black);
        g.fillRect(x, y, w, h); //fill with the color black
        g.setColor(Color.red);
        g.drawString("Hello", 50, 50);
        g.setColor(Color.yellow);
        g.drawString("I am an Java programmer", 80, 70);
        char s[] = {'W', 'o', 'r', 'k', ' ', 'h', 'a', 'r', 'd'};
        g.setColor(new Color(255, 120, 120));
        g.setFont(new Font("SansSerif", Font.ITALIC, 18));
        g.setColor(new Color(255, 120, 120));
        g.drawChars(s, 5, 4, 60, 90);
        byte b[] = {65, 66, 67, 68, 69, 70};
        g.setColor(new Color(255, 120, 120));
        g.drawBytes(b, 2, 3, 50, 110);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DrawWithPaintMethod");
        setSize(300,150);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(DrawWithPaintMethod.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DrawWithPaintMethod.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DrawWithPaintMethod.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DrawWithPaintMethod.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DrawWithPaintMethod().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
