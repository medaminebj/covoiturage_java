/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Axel
 */
public class localites {
    
    private int idLocalites;
    private String NomLocalite;
    private delegations idDelegations;

    public localites(int idLocalites, String NomLocalite, delegations idDelegations) {
        this.idLocalites = idLocalites;
        this.NomLocalite = NomLocalite;
        this.idDelegations = idDelegations;
    }

    public localites() {
    }

    public int getIdLocalites() {
        return idLocalites;
    }

    public void setIdLocalites(int idLocalites) {
        this.idLocalites = idLocalites;
    }

    public String getNomLocalite() {
        return NomLocalite;
    }

    public void setNomLocalite(String NomLocalite) {
        this.NomLocalite = NomLocalite;
    }

    public delegations getIdDelegations() {
        return idDelegations;
    }

    public void setIdDelegations(delegations idDelegations) {
        this.idDelegations = idDelegations;
    }
    
    
}
