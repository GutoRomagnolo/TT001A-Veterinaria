package model;

import view.MainPanel;

public class TT01Veterinaria {
  public static void main(String args[]) {
    /* Set the Nimbus look and feel */
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
      * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
      */
    try {
        javax.swing.UIManager.setLookAndFeel("com.formdev.flatlaf.FlatDarculaLaf");
    } catch (ClassNotFoundException ex) {
        java.util.logging.Logger.getLogger(MainPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
        java.util.logging.Logger.getLogger(MainPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
        java.util.logging.Logger.getLogger(MainPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        java.util.logging.Logger.getLogger(MainPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        new MainPanel().setVisible(true);
      }
    });
  }
}
