package modele;

public class Billet extends SiegeOccupe {
    private Dossier dossier;
    private Representation representation;

    public Billet(Place place, int numero, Dossier dossier, Representation representation) {
        super(place);
        this.numero = numero;
        this.dossier = dossier;
        this.representation = representation;
    }

    public Dossier getDossier() {
        return dossier;
    }

    public Representation getRepresentation() {
        return representation;
    }    
}
