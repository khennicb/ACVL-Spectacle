package modele;

public interface FactoryVendeur {
	
	public Billet acheterPlace(Place place);
	
	public Reservation reserverPlace(Place place);
}