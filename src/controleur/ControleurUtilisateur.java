package controleur;

import java.util.LinkedList;

import modele.Spectacle;
import modele.Utilisateur;
import vue.Center.PanelCenterListeSpectacles;

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
	
	public void majListeSpectacles(PanelCenterListeSpectacles panelCenter, LinkedList<Spectacle> spectacles){
	}
	
	public void loadDetailSpectacle(int numeroSpectacle){
	}
	
	public void setControleurPrincipal(ControleurPrincipal cp){
		this.controleurPrincipal = cp;
	}
	
}
