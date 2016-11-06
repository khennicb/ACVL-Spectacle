package modele;

import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

public class Spectacle {

    private int numero;
    private String nom;
    private String description;
    private Theme theme;
    private List<Representation> representations;

    public Spectacle(int numero, String nom, String description, Theme theme) {
        this.numero = numero;
        this.nom = nom;
        this.description = description;
        this.theme = theme;
        this.representations = new ArrayList<Representation>();
    }
    
    public Spectacle(String nom, String description, Theme theme) {
        this.nom = nom;
        this.description = description;
        this.theme = theme;
        this.representations = new ArrayList<Representation>();
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

    public String getDescription() {
        return description;
    }

    public Theme getTheme() {
        return theme;
    }

    public List<Representation> getAllRepresentations() {
        return representations;
    }

    public void addRepresentation(Date date, int heure, Salle salle) {
        representations.add(new Representation(date, heure, salle, this));
    }
}
