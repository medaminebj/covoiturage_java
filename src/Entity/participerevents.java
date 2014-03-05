/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Axel
 */
public class participerevents {
    
    private int idParticiperEvents;
    private Passagers idPassagers;
    private boolean estAccepter ;
    private  VilleItineraire villeDepart ;  
    private  VilleItineraire villeArrivee;
    private Itineraire idItineraires ;

    public participerevents(int idParticiperEvents, Passagers idPassagers, boolean estAccepter, VilleItineraire villeDepart, VilleItineraire villeArrivee,Itineraire idItineraires) {
        this.idParticiperEvents = idParticiperEvents;
        this.idPassagers = idPassagers;
        this.estAccepter = estAccepter;
        this.villeDepart = villeDepart;
        this.villeArrivee = villeArrivee;
        this.idItineraires = idItineraires;
    }

    public participerevents() {
    }

    public int getIdParticiperEvents() {
        return idParticiperEvents;
    }

    public void setIdParticiperEvents(int idParticiperEvents) {
        this.idParticiperEvents = idParticiperEvents;
    }

    public Passagers getIdPassagers() {
        return idPassagers;
    }

    public void setIdPassagers(Passagers idPassagers) {
        this.idPassagers = idPassagers;
    }

    public boolean isEstAccepter() {
        return estAccepter;
    }

    public void setEstAccepter(boolean estAccepter) {
        this.estAccepter = estAccepter;
    }

    public VilleItineraire getVilleDepart() {
        return villeDepart;
    }

    public void setVilleDepart(VilleItineraire villeDepart) {
        this.villeDepart = villeDepart;
    }

    public VilleItineraire getVilleArrivee() {
        return villeArrivee;
    }

    public void setVilleArrivee(VilleItineraire villeArrivee) {
        this.villeArrivee = villeArrivee;
    }

    public Itineraire getIdItineraires() {
        return idItineraires;
    }

    public void setIdItineraires(Itineraire idItineraires) {
        this.idItineraires = idItineraires;
    }
    
    
}
