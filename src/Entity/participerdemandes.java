/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Axel
 */
public class participerdemandes {
    private Passagers idPassagers; 
    private demandes idDemandes;

    public participerdemandes(Passagers idPassagers, demandes idDemandes) {
        this.idPassagers = idPassagers;
        this.idDemandes = idDemandes;
    }

    public participerdemandes() {
    }

    public Passagers getIdPassagers() {
        return idPassagers;
    }

    public void setIdPassagers(Passagers idPassagers) {
        this.idPassagers = idPassagers;
    }

    public demandes getIdDemandes() {
        return idDemandes;
    }

    public void setIdDemandes(demandes idDemandes) {
        this.idDemandes = idDemandes;
    }
    
    
}
