package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import modele.Spectacle;
import modele.Theme;
import vue.ComboBoxElement;
import vue.Center.PanelCenterListeSpectacles;
import vue.Center.PanelCenterSpectacleClient;
import vue.Center.PanelCenterSpectacleResponsable;
import vue.Header.PanelHeaderClient;
import vue.Header.PanelHeaderResponsable;

public class ControleurResponsable extends ControleurUtilisateur {
	final private static ControleurResponsable instanceUnique = new ControleurResponsable();

	static ControleurResponsable instance() {
		return instanceUnique;
	}
	
	@Override
	public void loadHome() {
		PanelHeaderResponsable header = new PanelHeaderResponsable();
		header.getBtnHome().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				ControleurResponsable.instance().loadHome();				
			}});
		this.controleurPrincipal.getVue().setHeader(header);
		LinkedList<Theme> themes = this.controleurPrincipal.getDatabaseManager().selectAllTheme();
		ComboBoxElement[] filtres = new ComboBoxElement[100];
		int i = 0;
		for(Theme theme: themes){
			filtres[i] = new ComboBoxElement(theme.getNumero(), theme.getNom());
			i++;
		}
		PanelCenterListeSpectacles panelCenterHome = new PanelCenterListeSpectacles(filtres);
		this.controleurPrincipal.getVue().setCenter(panelCenterHome);
	}
	
	@Override
	public void loadDetailSpectacle(int numeroSpectacle){
		Spectacle spectacle = this.controleurPrincipal.getDatabaseManager().selectSpectacle(numeroSpectacle);
		PanelCenterSpectacleResponsable panelCenter = new PanelCenterSpectacleResponsable(spectacle.getNom());
		this.controleurPrincipal.getVue().setCenter(panelCenter);
	}
}
