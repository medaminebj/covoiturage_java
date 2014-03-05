/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Axel
 */
public class VilleItineraire {
    
    private int IdVilleItineraire ;
    private Itineraire idItineraires ;
    private localites idLocalites ;
    private double longitude ;
    private double lattitude ;
    private int    numVille;

    public VilleItineraire(int IdVilleItineraire, Itineraire idItineraires, localites idLocalites, double longitude, double lattitude, int numVille) {
        this.IdVilleItineraire = IdVilleItineraire;
        this.idItineraires = idItineraires;
        this.idLocalites = idLocalites;
        this.longitude = longitude;
        this.lattitude = lattitude;
        this.numVille = numVille;
    }

    public VilleItineraire() {
    }

    public int getIdVilleItineraire() {
        return IdVilleItineraire;
    }

    public void setIdVilleItineraire(int IdVilleItineraire) {
        this.IdVilleItineraire = IdVilleItineraire;
    }

    public Itineraire getIdItineraires() {
        return idItineraires;
    }

    public void setIdItineraires(Itineraire idItineraires) {
        this.idItineraires = idItineraires;
    }

    public localites getIdLocalites() {
        return idLocalites;
    }

    public void setIdLocalites(localites idLocalites) {
        this.idLocalites = idLocalites;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLattitude() {
        return lattitude;
    }

    public void setLattitude(double lattitude) {
        this.lattitude = lattitude;
    }

    public int getNumVille() {
        return numVille;
    }

    public void setNumVille(int numVille) {
        this.numVille = numVille;
    }
    
    
    
}
