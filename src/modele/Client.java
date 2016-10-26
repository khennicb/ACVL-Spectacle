package modele;

import java.util.ArrayList;
import java.util.List;

public class Client extends Utilisateur{
	private String nom;
	private String prenom;
	private String mail;
	private List<Reservation> reservations;
	private List<Dossier> dossiers;
	
	public Client(String login, String password, String nom, String prenom, String email){
		super(login, password);
		this.nom = nom;
		this.prenom = prenom;
		this.mail = email;		
		this.reservations = new ArrayList<Reservation>();
		this.dossiers = new ArrayList<Dossier>();
	}
        
        public List<Reservation> getAllReservations(){
            return reservations;
        }
}