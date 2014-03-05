/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Axel
 */
public class gouvernorats {
    
    private int idGouvernorats ;  
    private String NomGouvernorat ;

    public gouvernorats(int idGouvernorats, String NomGouvernorat) {
        this.idGouvernorats = idGouvernorats;
        this.NomGouvernorat = NomGouvernorat;
    }

    public gouvernorats() {
    }

    public int getIdGouvernorats() {
        return idGouvernorats;
    }

    public void setIdGouvernorats(int idGouvernorats) {
        this.idGouvernorats = idGouvernorats;
    }

    public String getNomGouvernorat() {
        return NomGouvernorat;
    }

    public void setNomGouvernorat(String NomGouvernorat) {
        this.NomGouvernorat = NomGouvernorat;
    }
    
    
}
