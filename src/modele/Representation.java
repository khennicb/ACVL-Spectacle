package modele;

import java.util.ArrayList;
import java.util.Date;

public class Representation implements FactoryVendeur {
    private Date date;
    // utilite d'heure si date ?
    private int heure;
    private Salle salle;
    private Spectacle spectacle;

    // private List<Billet> billets; //????
    // private List<Reservation> reservations; //????
    public Representation(Date date, int heure, Salle salle, Spectacle spectacle) {
        this.date = date;
        this.heure = heure;
        this.salle = salle;
        this.spectacle = spectacle;
        // this.billets = new ArrayList<Billet>();
        // this.reservations = new ArrayList<Reservation>();
    }

    public Date getDate() {
        return date;
    }

    public int getHeure() {
        return heure;
    }

    public Salle getSalle() {
        return salle;
    }

    public Spectacle getSpectacle() {
        return spectacle;
    }

    public Billet acheterPlace(Place place) {
        return null;
    }

    public Reservation reserverPlace(Place place) {
        return null;
    }

}
