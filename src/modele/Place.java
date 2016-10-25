package modele;

public class Place {
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
}