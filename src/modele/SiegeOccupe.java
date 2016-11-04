package modele;

public abstract class SiegeOccupe {

    protected int numero;
    protected Place place;

    public SiegeOccupe(Place place) {
        this.place = place;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public Place getPlace() {
        return place;
    }
    

    
}
