package modele;

public class CategoriePlaces {
    private int numero;
    private String nom;
    private float tarif;

    public CategoriePlaces(String nom, float tarif) {
        this.nom = nom;
        this.tarif = tarif;
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

    public float getTarif() {
        return tarif;
    }
}
