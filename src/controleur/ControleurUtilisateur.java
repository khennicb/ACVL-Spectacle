package controleur;

public class ControleurUtilisateur {
	final private static ControleurUtilisateur instanceUnique = new ControleurUtilisateur();
	
	static ControleurUtilisateur instance(){
		return instanceUnique;
	}
	
	protected ControleurUtilisateur () {
		
	}
	
	public void loadHome() {
	}
}
