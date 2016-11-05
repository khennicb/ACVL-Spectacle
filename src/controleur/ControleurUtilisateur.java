package controleur;

import modele.Utilisateur;

public class ControleurUtilisateur {
	final private static ControleurUtilisateur instanceUnique = new ControleurUtilisateur();
	private ControleurPrincipal controleurPrincipal;
	private Utilisateur utilisateurCourant;
	
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
	
	public void setControleurPrincipal(ControleurPrincipal cp){
		this.controleurPrincipal = cp;
	}
}
