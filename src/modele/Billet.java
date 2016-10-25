package modele;

public class Billet extends SiegeOccupe {
	private int numero;
	private Dossier dossier;
	private Representation representation;

	public Billet(Place place, int numero, Dossier dossier, Representation representation){
		super(place);
		this.numero = numero;
		this.dossier = dossier;
		this.representation = representation;
	}
}