/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author user
 */
public class Voiture 
{
    private int idvoiture;
    private String marque;
    private String modele;
    private int annee;
    private int nbrplaces;
    private boolean bagage;
    private boolean estclimatiser;
    private boolean tabac;
    private boolean enfant;

    public Voiture() {
    }

    public Voiture(int idvoiture, String marque, String modele, int annee, int nbrplaces, boolean bagage, boolean estclimatiser, boolean tabac, boolean enfant) {
        this.idvoiture = idvoiture;
        this.marque = marque;
        this.modele = modele;
        this.annee = annee;
        this.nbrplaces = nbrplaces;
        this.bagage = bagage;
        this.estclimatiser = estclimatiser;
        this.tabac = tabac;
        this.enfant = enfant;
    }

    public int getIdvoiture() {
        return idvoiture;
    }

    public void setIdvoiture(int idvoiture) {
        this.idvoiture = idvoiture;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public int getNbrplaces() {
        return nbrplaces;
    }

    public void setNbrplaces(int nbrplaces) {
        this.nbrplaces = nbrplaces;
    }

    public boolean isBagage() {
        return bagage;
    }

    public void setBagage(boolean bagage) {
        this.bagage = bagage;
    }

    public boolean isEstclimatiser() {
        return estclimatiser;
    }

    public void setEstclimatiser(boolean estclimatiser) {
        this.estclimatiser = estclimatiser;
    }

    public boolean isTabac() {
        return tabac;
    }

    public void setTabac(boolean tabac) {
        this.tabac = tabac;
    }

    public boolean isEnfant() {
        return enfant;
    }

    public void setEnfant(boolean enfant) {
        this.enfant = enfant;
    }

    
    
}
