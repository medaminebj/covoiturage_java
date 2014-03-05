/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Axel
 */
public class delegations {
    
    private int idDelegations ;
    private String NomDelegation ; 
    private gouvernorats idGouvernorats;

    public delegations(int idDelegations, String NomDelegation, gouvernorats idGouvernorats) {
        this.idDelegations = idDelegations;
        this.NomDelegation = NomDelegation;
        this.idGouvernorats = idGouvernorats;
    }

    public delegations() {
    }

    public int getIdDelegations() {
        return idDelegations;
    }

    public void setIdDelegations(int idDelegations) {
        this.idDelegations = idDelegations;
    }

    public String getNomDelegation() {
        return NomDelegation;
    }

    public void setNomDelegation(String NomDelegation) {
        this.NomDelegation = NomDelegation;
    }

    public gouvernorats getIdGouvernorats() {
        return idGouvernorats;
    }

    public void setIdGouvernorats(gouvernorats idGouvernorats) {
        this.idGouvernorats = idGouvernorats;
    }
    
    
}
