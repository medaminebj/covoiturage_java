/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.GestionPorfilePassager;

import GUI.GestionProfil.*;
import Entity.Administrateur;
import Entity.Authentification;
import Entity.Passagers;
import java.sql.Date;
import java.text.ParseException;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import utils.Exceptions.ProblemeTechniqueException;

/**
 *
 * @author Ahmed
 */
public class GestionProfil extends javax.swing.JFrame {

    private Authentification authentification = new Authentification();
    private Administrateur admin = new Administrateur();
    private Passagers passager = new Passagers();

    /**
     * Creates new form GestionProfil
     */
    public GestionProfil() {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        nomTf = new javax.swing.JTextField();
        prenomTf = new javax.swing.JTextField();
        adresseTf = new javax.swing.JTextField();
        numtelTf = new javax.swing.JTextField();
        datedenaissanceTf = new javax.swing.JTextField();
        emailTf = new javax.swing.JTextField();
        passwordTf = new javax.swing.JTextField();
        confirmPasswordTf = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        EnregistrerBtn = new javax.swing.JButton();
        AcceuilBtn = new javax.swing.JButton();
        ModifierBtn = new javax.swing.JButton();
        AnnulerBtn = new javax.swing.JButton();
        sexeTf = new javax.swing.JComboBox();
        formaDate = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setText("Nom");

        jLabel2.setText("Prenom");

        jLabel3.setText("Adresse");

        jLabel4.setText("Numero de telephone");

        jLabel5.setText("Date de naissance");

        jLabel6.setText("Sexe");

        jLabel7.setText("E-mail");

        nomTf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomTfActionPerformed(evt);
            }
        });

        jLabel8.setText("Password");

        jLabel9.setText("Confirmer password");

        EnregistrerBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Enregistrer.png"))); // NOI18N
        EnregistrerBtn.setText("Enregistrer");
        EnregistrerBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EnregistrerBtnMouseClicked(evt);
            }
        });

        AcceuilBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/quitter.png"))); // NOI18N
        AcceuilBtn.setText("Quiiter");
        AcceuilBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AcceuilBtnMouseClicked(evt);
            }
        });

        ModifierBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/modifier.png"))); // NOI18N
        ModifierBtn.setText("Modifier");
        ModifierBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ModifierBtnMouseClicked(evt);
            }
        });
        ModifierBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModifierBtnActionPerformed(evt);
            }
        });

        AnnulerBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Annuler.png"))); // NOI18N
        AnnulerBtn.setText("Annuler");
        AnnulerBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AnnulerBtnMouseClicked(evt);
            }
        });

        sexeTf.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Homme", "Femme" }));

        formaDate.setText("yyyy-mm-dd");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("Mon profil ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(AcceuilBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ModifierBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                        .addGap(7, 7, 7)
                        .addComponent(EnregistrerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(AnnulerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(100, 100, 100)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(emailTf)
                            .addComponent(datedenaissanceTf)
                            .addComponent(numtelTf)
                            .addComponent(passwordTf)
                            .addComponent(confirmPasswordTf)
                            .addComponent(sexeTf, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nomTf)
                            .addComponent(prenomTf)
                            .addComponent(adresseTf, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addComponent(formaDate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(236, 236, 236)
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nomTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(prenomTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(adresseTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(numtelTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(datedenaissanceTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(formaDate)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(sexeTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(emailTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmPasswordTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(AnnulerBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AcceuilBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ModifierBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(EnregistrerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private boolean verifierChamps() {
        String erreurMsg = "";
        boolean result = true;

        if (nomTf.getText().length() < 3) {
            erreurMsg += "Le nom doit au moins avoir trois caracteres.\n";
            result = false;
        }

        if (prenomTf.getText().length() < 3) {
            erreurMsg += "Le prenom doit au moins avoir trois caracteres.\n";
            result = false;
        }

        if (!utils.Validators.NumeroTelValidator(numtelTf.getText())) {
            erreurMsg += "Le numéro de téléphone n'est pas valide.\n";
            result = false;
        } else if (!utils.Validators.TailleNumTelValidator(numtelTf.getText())) {
            erreurMsg += "Le numéro de téléphone est supérieur a 8 chiffre .\n";
            result = false;
        } else if (!utils.Validators.NomPrenomValidator(nomTf.getText())) {
            erreurMsg += "Le Nom est invalide.\n";
            result = false;
        } else if (!utils.Validators.NomPrenomValidator(prenomTf.getText())) {
            erreurMsg += "Le Prennom est invalide.\n";
            result = false;
        } else if (!utils.Validators.DateValidator(datedenaissanceTf.getText())) {
            erreurMsg += "Le Format de la date est incorecte .\n";
            result = false;
        } else if (!utils.Validators.ConfirmerMotDePasseValidator(passwordTf.getText(), confirmPasswordTf.getText())) {
            erreurMsg += "la confirmation du mot de passe est inccorecte \n";
            result = false;
        }
        if (!result) {
            JOptionPane.showMessageDialog(null, erreurMsg);
        }

        return result;
    }

    private void RemplissageChamps() {

        try {
            authentification = DAO.AuthentificationDAO.getInstance().findById(Entity.Session.getInstance().getUser().getIdAuthentification());

            if ((authentification.getType() == 'p')) {
                passager = (Passagers) authentification.getCompte();
                nomTf.setText(passager.getNom());
                prenomTf.setText(passager.getPrenom());
                adresseTf.setText(passager.getAdresse());
                numtelTf.setText(passager.getNumeroTel());
                emailTf.setText(passager.getEmail());
                datedenaissanceTf.setText(passager.getDateNaissance().toString());
                if (passager.getSexe() == 'M') {
                    sexeTf.setSelectedIndex(0);

                } else {
                    sexeTf.setSelectedIndex(1);
                }


            }

        } catch (ProblemeTechniqueException ex) {
            System.out.println("Probléme de recuperation des données");

        }

    }

    private void setAllDesable() {
        nomTf.enable(false);
        prenomTf.enable(false);
        adresseTf.enable(false);
        numtelTf.enable(false);
        datedenaissanceTf.enable(false);
        sexeTf.enable(false);
        emailTf.enable(false);
        passwordTf.enable(false);
        confirmPasswordTf.enable(false);
        



    }

    private void setAllEnable() {
        nomTf.enable(true);
        prenomTf.enable(true);
        adresseTf.enable(true);
        numtelTf.enable(true);
        datedenaissanceTf.enable(true);
        sexeTf.enable(true);
        emailTf.enable(true);
        passwordTf.enable(true);
        confirmPasswordTf.enable(true);



    }
    private void nomTfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomTfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomTfActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        setAllDesable();
        AnnulerBtn.setVisible(false);
        EnregistrerBtn.setVisible(false);
        formaDate.setVisible(false);


        RemplissageChamps();


    }//GEN-LAST:event_formWindowOpened

    private void ModifierBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ModifierBtnMouseClicked
        ModifierBtn.setVisible(false);
        AnnulerBtn.setVisible(true);
        EnregistrerBtn.setVisible(true);
        formaDate.setVisible(true);
        setAllEnable();

    }//GEN-LAST:event_ModifierBtnMouseClicked

    private void AnnulerBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AnnulerBtnMouseClicked
        ModifierBtn.setVisible(true);
        AnnulerBtn.setVisible(false);
        EnregistrerBtn.setVisible(false);
        formaDate.setVisible(false);
        RemplissageChamps();
        setAllDesable();


    }//GEN-LAST:event_AnnulerBtnMouseClicked

    private void ModifierBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModifierBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ModifierBtnActionPerformed

    private void EnregistrerBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EnregistrerBtnMouseClicked
        ModifierBtn.setVisible(true);
        AnnulerBtn.setVisible(true);
        EnregistrerBtn.setVisible(false);
        
        if (verifierChamps()) {
            if (!passwordTf.getText().equals("")) {
                authentification.setPassword(utils.Functions.ConvertToMd5 (passwordTf.getText()));
            }
            
            passager.setNom(nomTf.getText());
            passager.setPrenom(prenomTf.getText());
            passager.setAdresse(adresseTf.getText());
            passager.setNumeroTel(numtelTf.getText());
            passager.setEmail(emailTf.getText());
            java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-mm-dd");
            try {
                passager.setDateNaissance(df.parse(datedenaissanceTf.getText()));
            } catch (ParseException ex) {
                Logger.getLogger(GestionProfil.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(admin.getDateNaissance());
            
            if (sexeTf.getSelectedIndex()== 0)
            {
                passager.setSexe('M');
            }
            else 
                passager.setSexe('F');
        }
        try {
                if (DAO.AuthentificationDAO.getInstance().update(authentification))
                {
                     JOptionPane.showMessageDialog(null, "La modification de votre profile a été abouti");
                     formaDate.setVisible(false);
        
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "La modification n'a pas été abouti");
                }
            
        } catch (ProblemeTechniqueException ex) {
            System.out.println("Probléme de mise à jour ");
        }
        AnnulerBtn.setVisible(false);
        setAllDesable();
        
    }//GEN-LAST:event_EnregistrerBtnMouseClicked

    private void AcceuilBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AcceuilBtnMouseClicked
       this.dispose();
    }//GEN-LAST:event_AcceuilBtnMouseClicked

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
            java.util.logging.Logger.getLogger(GestionProfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionProfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionProfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionProfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionProfil().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AcceuilBtn;
    private javax.swing.JButton AnnulerBtn;
    private javax.swing.JButton EnregistrerBtn;
    private javax.swing.JButton ModifierBtn;
    private javax.swing.JTextField adresseTf;
    private javax.swing.JTextField confirmPasswordTf;
    private javax.swing.JTextField datedenaissanceTf;
    private javax.swing.JTextField emailTf;
    private javax.swing.JLabel formaDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField nomTf;
    private javax.swing.JTextField numtelTf;
    private javax.swing.JTextField passwordTf;
    private javax.swing.JTextField prenomTf;
    private javax.swing.JComboBox sexeTf;
    // End of variables declaration//GEN-END:variables
}