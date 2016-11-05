package controleur;

import java.util.ArrayList;
import java.util.LinkedList;

import modele.Theme;
import vue.Center.PanelCenterListeSpectacles;
import vue.Header.PanelHeaderClient;

public class ControleurClient extends ControleurUtilisateur {
	final private static ControleurClient instanceUnique = new ControleurClient();

	static ControleurUtilisateur instance() {
		return instanceUnique;
	}

	public void loadHome() {
		this.controleurPrincipal.getVue().setHeader(new PanelHeaderClient());
		LinkedList<Theme> themes = this.controleurPrincipal.getDatabaseManager().selectAllTheme();
		String[] filtres = new String[100];
		int i = 0;
		for(Theme theme: themes){
			filtres[i] = (theme.getNom());
			i++;
		}
		PanelCenterListeSpectacles panelCenterHome = new PanelCenterListeSpectacles((String[]) filtres);
		this.controleurPrincipal.getVue().setCenter(panelCenterHome);
	}
}
