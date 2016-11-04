package modele;

public class CategoriePlaces {
    private String nom;
    private float tarif;

    public CategoriePlaces(String nom, float tarif) {
        this.nom = nom;
        this.tarif = tarif;
    }

    public String getNom() {
        return nom;
    }

    public float getTarif() {
        return tarif;
    }
}
