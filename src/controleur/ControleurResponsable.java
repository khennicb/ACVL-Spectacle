package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import modele.Theme;
import vue.Center.PanelCenterListeSpectacles;
import vue.Header.PanelHeaderClient;
import vue.Header.PanelHeaderResponsable;

public class ControleurResponsable extends ControleurUtilisateur {
	final private static ControleurResponsable instanceUnique = new ControleurResponsable();

	static ControleurResponsable instance() {
		return instanceUnique;
	}
	
	public void loadHome() {
		PanelHeaderResponsable header = new PanelHeaderResponsable();
		header.getBtnHome().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				ControleurClient.instance().loadHome();				
			}});
		this.controleurPrincipal.getVue().setHeader(header);
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
