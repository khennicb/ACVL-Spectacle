package controleur;

public class ControleurClient extends ControleurUtilisateur {
	final private static ControleurClient instanceUnique = new ControleurClient();

	static ControleurUtilisateur instance() {
		return instanceUnique;
	}

	
}
