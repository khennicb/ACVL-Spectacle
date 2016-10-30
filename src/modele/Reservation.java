package modele;

public class Reservation extends SiegeOccupe {

    private Client client;
    private Representation representation;

    public Reservation(Place place, Client client, Representation representation) {
        super(place);
        this.client = client;
        this.representation = representation;
    }

    public Client getClient() {
        return client;
    }

    public Representation getRepresentation() {
        return representation;
    }

    
}
