package modele;

import java.util.ArrayList;
import java.util.List;

public class Salle {

    private String nom;
    private int numero;
    private List<Place> places;

    public Salle(String nom) {
        this.nom = nom;
        this.places = new ArrayList<Place>();
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public String getNom() {
        return nom;
    }

    public List<Place> getAllPlaces() {
        return places;
    }    
}
