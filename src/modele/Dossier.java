package modele;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Dossier {
	private int numero;
	private float montant;
	private Date date_achat;
	private Client client;
	private List<Billet> billets;
	
	public Dossier(int numero, float montant, Date date_achat, Client client) {
		this.numero = numero;
		this.montant = montant;
		this.date_achat = date_achat;
		this.client = client;
		this.billets = new ArrayList<Billet>();
	}
	
	
}