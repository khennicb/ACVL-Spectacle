package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Map;

import javax.swing.JButton;

import modele.Representation;
import modele.Spectacle;
import modele.Theme;
import vue.ComboBoxElement;
import vue.Center.PanelCenter;
import vue.Center.PanelCenterListeSpectacles;
import vue.Center.PanelCenterSpectacleClient;
import vue.Header.PanelHeaderClient;

public class ControleurClient extends ControleurUtilisateur {
	final private static ControleurClient instanceUnique = new ControleurClient();

	static ControleurUtilisateur instance() {
		return instanceUnique;
	}
	
	@Override
	public void loadHome() {
		PanelHeaderClient header = new PanelHeaderClient();
		header.getBtnHome().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				ControleurClient.instance().loadHome();				
			}});
		this.controleurPrincipal.getVue().setHeader(header);
		LinkedList<Theme> themes = this.controleurPrincipal.getDatabaseManager().selectAllTheme();
		ComboBoxElement[] filtres = new ComboBoxElement[themes.size() + 1];
		int i = 1;
		filtres[0] = null;
		for(Theme theme: themes){
			filtres[i] = new ComboBoxElement(theme.getNumero(),theme.getNom());
			i++;
		}
		PanelCenterListeSpectacles panelCenterHome = new PanelCenterListeSpectacles(filtres);
		panelCenterHome.getComboBoxFiltres().addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				ComboBoxElement item = (ComboBoxElement)panelCenterHome.getComboBoxFiltres().getSelectedItem();
				if(item != null){
					panelCenterHome.viderListeSpectacle();
					LinkedList<Spectacle> spectacles = controleurPrincipal.getDatabaseManager().selectAllSpectacleByTheme(item.getIndex());
					ControleurClient.instance().majListeSpectacles(panelCenterHome, spectacles);
					controleurPrincipal.getVue().show();
				}
				else{
					panelCenterHome.viderListeSpectacle();
					LinkedList<Spectacle> spectacles = controleurPrincipal.getDatabaseManager().selectAllSpectacle();
					ControleurClient.instance().majListeSpectacles(panelCenterHome, spectacles);
					controleurPrincipal.getVue().show();
				}
			}
		});		
		this.controleurPrincipal.getVue().setCenter(panelCenterHome);
		LinkedList<Spectacle> spectacles =  this.controleurPrincipal.getDatabaseManager().selectAllSpectacle();
		this.majListeSpectacles(panelCenterHome, spectacles);
		this.controleurPrincipal.getVue().show();
	}
	
	@Override
	public void majListeSpectacles(PanelCenterListeSpectacles panelCenter, LinkedList<Spectacle> spectacles){
		for(Spectacle s : spectacles) {
			JButton btnSpectacle = panelCenter.ajoutElmtListeSpectacle(s.getNom());
			btnSpectacle.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
					ControleurClient.instance().loadDetailSpectacle(s.getNumero());					
				}});
		}
	}
	
	@Override
	public void loadDetailSpectacle(int numeroSpectacle){
		Spectacle spectacle = this.controleurPrincipal.getDatabaseManager().selectSpectacle(numeroSpectacle);
		PanelCenterSpectacleClient panelCenter = new PanelCenterSpectacleClient(spectacle.getNom(), spectacle.getDescription(), spectacle.getTheme().getNom());
		this.controleurPrincipal.getVue().setCenter(panelCenter);
		LinkedList<Representation> representations = this.controleurPrincipal.getDatabaseManager().selectRepresentations(spectacle);
		majListeRepresentations(panelCenter, representations);
		this.controleurPrincipal.getVue().show();
	}
	
	public void majListeRepresentations(PanelCenterSpectacleClient panelCenter, LinkedList<Representation> representations){
		for(Representation r : representations) {
			int nbBillet = 0;
			int nbReserv = 0;
			Map<String, JButton> btnSpectacle = panelCenter.ajoutElmtRepresentation(r.getDate(), r.getHeure());
			/*btnSpectacle.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
					//TODO
				}});*/
		}
	}
}
