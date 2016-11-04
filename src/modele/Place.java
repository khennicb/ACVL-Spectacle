package modele;

public class Place {
    private int numero;
    private int numeroRang;
    private int placeRang;
    private CategoriePlaces categorie;
    private Salle salle;

    public Place(int numeroRang, int placeRang, CategoriePlaces categorie, Salle salle) {
        this.numeroRang = numeroRang;
        this.placeRang = placeRang;
        this.categorie = categorie;
        this.salle = salle;
    }

    public int getNumeroRang() {
        return numeroRang;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getPlaceRang() {
        return placeRang;
    }

    public CategoriePlaces getCategorie() {
        return categorie;
    }

    public Salle getSalle() {
        return salle;
    }
    
    
}
