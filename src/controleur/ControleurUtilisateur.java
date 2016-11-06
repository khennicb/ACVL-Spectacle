package controleur;

import modele.Utilisateur;

public class ControleurUtilisateur {
	final private static ControleurUtilisateur instanceUnique = new ControleurUtilisateur();
	protected ControleurPrincipal controleurPrincipal;
	protected Utilisateur utilisateurCourant;
	
	public void setUtilisateurCourant(Utilisateur utilisateurCourant) {
		this.utilisateurCourant = utilisateurCourant;
	}

	static ControleurUtilisateur instance(){
		return instanceUnique;
	}
	
	protected ControleurUtilisateur () {
		
	}
	
	public void loadHome() {
	}
	
	public void loadDetailSpectacle(int numeroSpectacle){
	}
	
	public void setControleurPrincipal(ControleurPrincipal cp){
		this.controleurPrincipal = cp;
	}
}
