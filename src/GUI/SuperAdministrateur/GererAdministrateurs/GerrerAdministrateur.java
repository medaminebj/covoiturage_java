/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.SuperAdministrateur.GererAdministrateurs;

import Entity.Administrateur;
import Entity.Authentification;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import metier.AuthentificationMetier;
import utils.Exceptions.ProblemeTechniqueException;
import utils.components.jtable.tableModelGerrerAdmins;



/**
 *
 * @author Axel
 */
public class GerrerAdministrateur extends javax.swing.JFrame {

    /**
     * Creates new form Accueil2
     */
    Authentification authentification;
    Administrateur administrateur;
    metier.AuthentificationMetier authentificationMetier;
    metier.AdministrateurMetier administrateurMetier ; 
    public GerrerAdministrateur() {
        initComponents();
        
        authentificationMetier = new AuthentificationMetier();
        
        //cacher les erreurs
        errLoginLabel.setVisible(false);
        
        //disable btns
        modifierBtn.setVisible(false);
        supprimerBtn.setVisible(false);
        informationsContainer.setVisible(false);
        enregisterBtn.setVisible(false);
        
        //disable dates
        dateCreationTF.setEnabled(false);
        dateDerniereModificationTF.setEnabled(false);
        
        //les champs des mot de passe
        changerEtatMotDePasse(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        datagrid = new javax.swing.JTable();
        supprimerBtn = new javax.swing.JButton();
        informationsContainer = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        ConfirmPasswordLabel = new javax.swing.JLabel();
        nomTF = new javax.swing.JTextField();
        prenomTF = new javax.swing.JTextField();
        dateNaissanceTF = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        adresseTA = new javax.swing.JTextArea();
        telephoneTF = new javax.swing.JTextField();
        sexeCB = new javax.swing.JComboBox();
        loginTF = new javax.swing.JTextField();
        dateCreationTF = new javax.swing.JTextField();
        dateDerniereModificationTF = new javax.swing.JTextField();
        passwordTF = new javax.swing.JPasswordField();
        confirmationPasswordTF = new javax.swing.JPasswordField();
        errLoginLabel = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        RetourBTN = new javax.swing.JButton();
        modifierBtn = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();
        enregisterBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gerrer les administrateurs");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(1024, 500));

        datagrid.setModel(new utils.components.jtable.tableModelGerrerAdmins());
        datagrid.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        datagrid.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                datagridMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(datagrid);

        supprimerBtn.setText("Supprimer");
        supprimerBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                supprimerBtnMouseClicked(evt);
            }
        });

        jLabel1.setText("Nom :");

        jLabel2.setText("Prénom :");

        jLabel3.setText("Date de naissance :");

        jLabel4.setText("Adresse :");

        jLabel5.setText("Téléphone :");

        jLabel6.setText("Sexe :");

        jLabel7.setText("Login :");

        jLabel8.setText("Date de création :");

        jLabel9.setText("Date de la derniere modification :");

        passwordLabel.setText("Nouveau mot de passel :");

        ConfirmPasswordLabel.setText("Confirmation du mot de passe :");

        adresseTA.setColumns(20);
        adresseTA.setRows(5);
        jScrollPane2.setViewportView(adresseTA);

        sexeCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Homme", "Femme" }));

        loginTF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                loginTFFocusLost(evt);
            }
        });

        errLoginLabel.setForeground(new java.awt.Color(255, 0, 0));
        errLoginLabel.setText("Login existant");
        errLoginLabel.setFocusable(false);

        jLabel10.setText("YYYY-MM-DD");

        javax.swing.GroupLayout informationsContainerLayout = new javax.swing.GroupLayout(informationsContainer);
        informationsContainer.setLayout(informationsContainerLayout);
        informationsContainerLayout.setHorizontalGroup(
            informationsContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, informationsContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(informationsContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(informationsContainerLayout.createSequentialGroup()
                        .addGroup(informationsContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(26, 26, 26)
                        .addGroup(informationsContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sexeCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(informationsContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(telephoneTF)
                                .addComponent(nomTF)
                                .addComponent(prenomTF)
                                .addComponent(jScrollPane2)
                                .addComponent(dateNaissanceTF)))))
                .addGap(10, 10, 10)
                .addComponent(jLabel10)
                .addGap(138, 138, 138)
                .addGroup(informationsContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(informationsContainerLayout.createSequentialGroup()
                        .addGroup(informationsContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(informationsContainerLayout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addGroup(informationsContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(passwordLabel, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGroup(informationsContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(informationsContainerLayout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(informationsContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(loginTF)
                                    .addComponent(dateCreationTF, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)))
                            .addGroup(informationsContainerLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(informationsContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dateDerniereModificationTF, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                                    .addComponent(passwordTF)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, informationsContainerLayout.createSequentialGroup()
                        .addComponent(ConfirmPasswordLabel)
                        .addGap(18, 18, 18)
                        .addComponent(confirmationPasswordTF, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(errLoginLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        informationsContainerLayout.setVerticalGroup(
            informationsContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(informationsContainerLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(informationsContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel7)
                    .addComponent(nomTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loginTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(errLoginLabel))
                .addGap(22, 22, 22)
                .addGroup(informationsContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel8)
                    .addComponent(prenomTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateCreationTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(informationsContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel9)
                    .addComponent(dateNaissanceTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateDerniereModificationTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(24, 24, 24)
                .addGroup(informationsContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(informationsContainerLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addGroup(informationsContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(telephoneTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(informationsContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sexeCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(23, 23, 23))
                    .addGroup(informationsContainerLayout.createSequentialGroup()
                        .addGroup(informationsContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(passwordLabel)
                            .addComponent(passwordTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(informationsContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ConfirmPasswordLabel)
                            .addComponent(confirmationPasswordTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        RetourBTN.setText("Accueil");
        RetourBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RetourBTNMouseClicked(evt);
            }
        });

        modifierBtn.setText("Modifier");
        modifierBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifierBtnActionPerformed(evt);
            }
        });

        addBtn.setText("Ajouter");
        addBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addBtnMouseClicked(evt);
            }
        });

        enregisterBtn.setText("Enregistrer");
        enregisterBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enregisterBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(RetourBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(supprimerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                        .addComponent(enregisterBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(modifierBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(informationsContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RetourBTN)
                    .addComponent(supprimerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modifierBtn)
                    .addComponent(addBtn)
                    .addComponent(enregisterBtn))
                .addGap(3, 3, 3)
                .addComponent(informationsContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void datagridMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_datagridMouseClicked
        modifierBtn.setVisible(true);
        modifierBtn.setEnabled(true);
        supprimerBtn.setVisible(true);
        supprimerBtn.setEnabled(true);
        informationsContainer.setVisible(true);
        
        enregisterBtn.setVisible(false);
        
        changerEtatInformation(false);
        changerEtatMotDePasse(false);
        
        remplireInformations(datagrid.getSelectedRow());
    }//GEN-LAST:event_datagridMouseClicked

    private void addBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addBtnMouseClicked
        
        //si les champs ne sont pas visible, on les affiche
        if (!informationsContainer.isVisible())
            informationsContainer.setVisible(true);
        
        //si les champs sont déactivés (setEnable(false), on les active
        changerEtatInformation(true);
        
        //on affiche les champs des mot de passe
        changerEtatMotDePasse(true);
        
        //on vide les champs
        viderChamps();
        
        enregisterBtn.setVisible(true);
        modifierBtn.setEnabled(false);
        supprimerBtn.setEnabled(false);
        
        //créer un entité authentification vide
        authentification = new Authentification();
        administrateur = new Administrateur();
    }//GEN-LAST:event_addBtnMouseClicked

    private void loginTFFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_loginTFFocusLost
        
        errLoginLabel.setVisible(false);
        
        if (!loginTF.getText().equals("") || loginTF.getText() != null){
            try {
                if (authentificationMetier.loginExistant(loginTF.getText()))
                    errLoginLabel.setVisible(true);
            } catch (ProblemeTechniqueException ex) {
                JOptionPane.showMessageDialog(null, "il ya un probleme technique.");
            }
        }
    }//GEN-LAST:event_loginTFFocusLost

    private void enregisterBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enregisterBtnActionPerformed
        
        if (verifierChamps())
        {
        //on doit savoir si nous allons modifier ou ajouter
            if (authentification.getIdAuthentification() == -1)//ajout
            {
                authentification.setLogin(loginTF.getText());
                authentification.setPassword(utils.Functions.ConvertToMd5(passwordTF.getPassword().toString()));
                authentification.setType('a');
                authentification.setDateCreation(new Date(new java.util.Date().getTime()));
                authentification.setDateDernierModification(null);

                administrateur.setNom(nomTF.getText());
                administrateur.setPrenom(prenomTF.getText());
                administrateur.setAdresse(adresseTA.getText());
                administrateur.setNumeroTel(telephoneTF.getText());
                administrateur.setEstSuper(0);
                administrateur.setDateNaissance(null);

                if (sexeCB.getSelectedIndex() == 1)
                    administrateur.setSexe('H');
                else
                    administrateur.setSexe('F');

                authentification.setCompte(administrateur);
                try {
                        //Tester si l'ajout avec succé on rafréchi le Jtable
                        if (DAO.AuthentificationDAO.getInstance().create(authentification))
                        {
                               datagrid.setModel(new tableModelGerrerAdmins());
                               JOptionPane.showMessageDialog(null, "Ajout avec succé");
                               viderChamps();
                               informationsContainer.setVisible(false);
                               enregisterBtn.setVisible(false);
                               supprimerBtn.setVisible(false);
                               modifierBtn.setVisible(false);
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "Ajout n'as pas été abouti");
                        }
                } catch (ProblemeTechniqueException ex) {
                    Logger.getLogger(GerrerAdministrateur.class.getName()).log(Level.SEVERE, null, ex);
                }
             }
        //modification
            else
            {   
                authentification.setLogin(loginTF.getText());
                if (passwordTF.getPassword().length != 0)
                    authentification.setPassword(utils.Functions.ConvertToMd5(passwordTF.getPassword().toString()));
                else
                     authentification.setPassword(authentification.getPassword());
                
                authentification.setType('a');
                authentification.setDateCreation(new Date(new java.util.Date().getTime()));
                authentification.setDateDernierModification(null);
                authentification.setEmail(null);
                String jjj = nomTF.getText();
                administrateur.setNom(jjj);
                administrateur.setPrenom(prenomTF.getText());
                administrateur.setAdresse(adresseTA.getText());
                administrateur.setNumeroTel(telephoneTF.getText());
                administrateur.setEstSuper(0);
                administrateur.setDateNaissance(null);
                

                if (sexeCB.getSelectedIndex() == 1)
                    administrateur.setSexe('H');
                else
                    administrateur.setSexe('F');

                authentification.setCompte(administrateur);
                
                try {
                        //Tester si la modification avec succé on rafréchi le Jtable
                        if (DAO.AuthentificationDAO.getInstance().update(authentification))
                        {
                               datagrid.setModel(new tableModelGerrerAdmins());
                               JOptionPane.showMessageDialog(null, "Modification avec succé");
                               viderChamps();
                               informationsContainer.setVisible(false);
                               enregisterBtn.setVisible(false);
                               supprimerBtn.setVisible(false);
                               modifierBtn.setVisible(false);
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "Modification n'as pas été abouti");
                        }
                } catch (ProblemeTechniqueException ex) {
                    Logger.getLogger(GerrerAdministrateur.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_enregisterBtnActionPerformed

    private void RetourBTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RetourBTNMouseClicked
            GUI.Administrateur.Accueil acc = new GUI.Administrateur.Accueil();
            acc.setVisible(true);
           
    }//GEN-LAST:event_RetourBTNMouseClicked

    private void supprimerBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_supprimerBtnMouseClicked
        
          try {
            Authentification authentification = ((tableModelGerrerAdmins)datagrid.getModel()).getRowEntity(datagrid.getSelectedRow());
            Administrateur admin = (Administrateur)authentification.getCompte();
            
            // supression d'un admin séléctionner apartir de la table authentification et administrateur 
            if (authentificationMetier.DeleteAuthentification(authentification))
            {
                if (DAO.AdministrateurDAO.getInstance().delete(admin))
                {
                     JOptionPane.showMessageDialog(null, "Supression avec succé");
                     datagrid.setModel(new tableModelGerrerAdmins());
                }
                else
                    JOptionPane.showMessageDialog(null, "Supression non abouti"); 
            }
            else
                  System.out.println("aaa");
           
                   
                   
        } catch (ProblemeTechniqueException ex) {
            System.out.println("Probléme de supression");
        }
        
        
    }//GEN-LAST:event_supprimerBtnMouseClicked

    private void modifierBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifierBtnActionPerformed
        // TODO add your handling code here:
        if (!informationsContainer.isVisible())
            informationsContainer.setVisible(true);
        
        //si les champs sont déactivés (setEnable(false), on les active
        changerEtatInformation(true);
        
        //on affiche les champs des mot de passe
        changerEtatMotDePasse(true);
        
        //on vide les champs
        remplireInformations(datagrid.getSelectedRow());
        
        enregisterBtn.setVisible(true);
        modifierBtn.setEnabled(false);
        supprimerBtn.setEnabled(false);
        authentification = ((tableModelGerrerAdmins)datagrid.getModel()).getRowEntity(datagrid.getSelectedRow());
        administrateur = (Administrateur)authentification.getCompte();
    }//GEN-LAST:event_modifierBtnActionPerformed
    
    
    private void remplireInformations(int ligne){
        Authentification authentification = ((tableModelGerrerAdmins)datagrid.getModel()).getRowEntity(ligne);
        Administrateur admin = (Administrateur)authentification.getCompte();
        
        nomTF.setText(admin.getNom());
        prenomTF.setText(admin.getPrenom());
        dateNaissanceTF.setText(admin.getDateNaissance().toString());
        adresseTA.setText(admin.getAdresse());
        telephoneTF.setText(admin.getNumeroTel());
        
        if (admin.getSexe() == 'M')
            sexeCB.setSelectedIndex(0);
        else
            sexeCB.setSelectedIndex(1);
        
        loginTF.setText(authentification.getLogin());
        dateCreationTF.setText(authentification.getDateCreation().toString());
        
        if (authentification.getDateDernierModification() == null)
            dateDerniereModificationTF.setText(null);
        else
            dateDerniereModificationTF.setText(authentification.getDateDernierModification().toString());
    }
    
    private void changerEtatInformation(boolean etat){
        nomTF.setEnabled(etat);
        prenomTF.setEnabled(etat);
        dateNaissanceTF.setEnabled(etat);
        adresseTA.setEnabled(etat);
        telephoneTF.setEnabled(etat);
        sexeCB.setEnabled(etat);
        loginTF.setEnabled(etat);
    }
    
    private void viderChamps(){
        nomTF.setText(null);
        prenomTF.setText(null);
        dateNaissanceTF.setText(null);
        adresseTA.setText(null);
        telephoneTF.setText(null);
        sexeCB.setSelectedIndex(0);
        loginTF.setText(null);
        dateCreationTF.setText(null);
        dateDerniereModificationTF.setText(null);
    }
    
    private void changerEtatMotDePasse(boolean etat){
        passwordLabel.setVisible(etat);
        passwordTF.setVisible(etat);
        ConfirmPasswordLabel.setVisible(etat);
        confirmationPasswordTF.setVisible(etat);
    }
    // Méthode pour vérifier les champs saisies par l'utilisateur
    private boolean verifierChamps(){
        String erreurMsg = "";
        boolean result = true;
        
        if (nomTF.getText().length() < 3)
        {
            erreurMsg += "Le nom doit au moins avoir trois caracteres.\n";
            result = false;
        }
        
        if (prenomTF.getText().length() < 3)
        {
            erreurMsg += "Le prenom doit au moins avoir trois caracteres.\n";
            result = false;
        }    
        
        if (!utils.Validators.NumeroTelValidator(telephoneTF.getText()) )
        {
            erreurMsg += "Le numéro de téléphone n'est pas valide.\n";
            result = false;
        }
        else if (!utils.Validators.TailleNumTelValidator(telephoneTF.getText()) )
        {
            erreurMsg += "Le numéro de téléphone est supérieur a 8 chiffre .\n";
            result = false;
        }
       else if (!utils.Validators.NomPrenomValidator(nomTF.getText()) )
        {
            erreurMsg += "Le Nom est invalide.\n";
            result = false;
        }
       else if (!utils.Validators.NomPrenomValidator(prenomTF.getText()) )
        {
            erreurMsg += "Le Prennom est invalide.\n";
            result = false;
        }
       else if (!utils.Validators.DateValidator(dateNaissanceTF.getText()) )
        {
            erreurMsg += "Le Format de la date est incorecte .\n";
            result = false;
        }
       else if (!utils.Validators.ConfirmerMotDePasseValidator(passwordTF.getText(),confirmationPasswordTF.getText()))
       {
            erreurMsg += "la confirmation du mot de passe est inccorecte \n";
            result = false;
       }
        if (!result)
            JOptionPane.showMessageDialog(null, erreurMsg);
        
        return result;
    }
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
            java.util.logging.Logger.getLogger(GerrerAdministrateur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GerrerAdministrateur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GerrerAdministrateur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GerrerAdministrateur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GerrerAdministrateur().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ConfirmPasswordLabel;
    private javax.swing.JButton RetourBTN;
    private javax.swing.JButton addBtn;
    private javax.swing.JTextArea adresseTA;
    private javax.swing.JPasswordField confirmationPasswordTF;
    private javax.swing.JTable datagrid;
    private javax.swing.JTextField dateCreationTF;
    private javax.swing.JTextField dateDerniereModificationTF;
    private javax.swing.JTextField dateNaissanceTF;
    private javax.swing.JButton enregisterBtn;
    private javax.swing.JLabel errLoginLabel;
    private javax.swing.JPanel informationsContainer;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField loginTF;
    private javax.swing.JButton modifierBtn;
    private javax.swing.JTextField nomTF;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JPasswordField passwordTF;
    private javax.swing.JTextField prenomTF;
    private javax.swing.JComboBox sexeCB;
    private javax.swing.JButton supprimerBtn;
    private javax.swing.JTextField telephoneTF;
    // End of variables declaration//GEN-END:variables
}
