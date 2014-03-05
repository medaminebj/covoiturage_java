/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Passager;

import GUI.Administrateur.*;
import javax.swing.JOptionPane;
import Entity.Session;
/**
 *
 * @author Amine
 */
public class Accueil extends javax.swing.JFrame {

    /**
     * Creates new form Accueil
     */
    public Accueil() {
        initComponents();
        //UserNameLabel.setText(Session.getInstance().getUser().);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        decoBtn = new javax.swing.JButton();
        ModifierProfileBtn = new javax.swing.JButton();
        StatistiqueBtn = new javax.swing.JButton();
        UserNameLabel = new javax.swing.JLabel();
        ChercherItinieraireBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Back Office");
        setMinimumSize(new java.awt.Dimension(1024, 768));
        setResizable(false);
        getContentPane().setLayout(null);

        decoBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/deco.png"))); // NOI18N
        decoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decoBtnActionPerformed(evt);
            }
        });
        getContentPane().add(decoBtn);
        decoBtn.setBounds(906, 0, 118, 115);

        ModifierProfileBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/modifierProfile.png"))); // NOI18N
        ModifierProfileBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ModifierProfileBtnMouseClicked(evt);
            }
        });
        getContentPane().add(ModifierProfileBtn);
        ModifierProfileBtn.setBounds(80, 280, 180, 180);

        StatistiqueBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/stat.png"))); // NOI18N
        getContentPane().add(StatistiqueBtn);
        StatistiqueBtn.setBounds(790, 280, 180, 180);
        getContentPane().add(UserNameLabel);
        UserNameLabel.setBounds(930, 130, 0, 0);

        ChercherItinieraireBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/chercherItineraire.png"))); // NOI18N
        getContentPane().add(ChercherItinieraireBtn);
        ChercherItinieraireBtn.setBounds(440, 280, 180, 180);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/bg admin.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1030, 770);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void decoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decoBtnActionPerformed
        // TODO add your handling code here:
        int dialogResult = JOptionPane.showConfirmDialog(null, "Voulez vous continuer ?", "Deconnexion", JOptionPane.YES_NO_OPTION);
        
        if (dialogResult == JOptionPane.YES_OPTION)
        {
            GUI.Authentification acc = new GUI.Authentification();
            acc.setVisible(true);
            this.dispose();
            Session.getInstance().deconnexion();
        }
    }//GEN-LAST:event_decoBtnActionPerformed

    private void ModifierProfileBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ModifierProfileBtnMouseClicked
        GUI.GestionProfil.GestionProfil gaInterface = new GUI.GestionProfil.GestionProfil();
        gaInterface.setVisible(true);
    }//GEN-LAST:event_ModifierProfileBtnMouseClicked

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
            java.util.logging.Logger.getLogger(Accueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Accueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Accueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Accueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Accueil().setVisible(true);
            }
        });
    }
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ChercherItinieraireBtn;
    private javax.swing.JButton ModifierProfileBtn;
    private javax.swing.JButton StatistiqueBtn;
    private javax.swing.JLabel UserNameLabel;
    private javax.swing.JButton decoBtn;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
