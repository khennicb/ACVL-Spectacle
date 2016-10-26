package modele;

public class CategoriePlaces {
    private String nom;
    private int tarif;

    public CategoriePlaces(String nom, int tarif) {
        this.nom = nom;
        this.tarif = tarif;
    }

    public String getNom() {
        return nom;
    }

    public int getTarif() {
        return tarif;
    }
}
