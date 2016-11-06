package controleur;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import modele.CategoriePlaces;
import modele.Representation;
import modele.Spectacle;
import modele.Theme;
import vue.ComboBoxElement;
import vue.Fenetre;
import vue.FenetreAchat;
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
		header.getBtnDeconnexion().addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				controleurPrincipal.deconnexion();
			}
		});
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
			btnSpectacle.get("btnAcheter").addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent arg0) {
						FenetreAchat achat = new FenetreAchat(getCategoriePlace());
						achat.getSpinner().addChangeListener(new ChangeListener() {
							@Override
							public void stateChanged(ChangeEvent e) {
								int value = (Integer)achat.getSpinner().getValue();
								if(value < 0){
									achat.getSpinner().setValue(0);
									return;
								}
								while(value > achat.getNombrePlace()){
									achat.ajoutPlace();
								}
								while(value < achat.getNombrePlace()){
									achat.enleverPlace();
								}
								int catId = ((ComboBoxElement)achat.getComboBoxCategory().getSelectedItem()).getIndex();
								CategoriePlaces cat = controleurPrincipal.getDatabaseManager().selectCategorie(catId);
								if(cat != null){
									achat.getLblTotal().setText(String.format("%.2f",cat.getTarif() * achat.getNombrePlace()));
								}
								achat.show();
							}
						});
						achat.getComboBoxCategory().addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								int catId = ((ComboBoxElement)achat.getComboBoxCategory().getSelectedItem()).getIndex();
								CategoriePlaces cat = controleurPrincipal.getDatabaseManager().selectCategorie(catId);
								if(cat != null){
									achat.getLblTotal().setText(String.format("%.2f",cat.getTarif() * achat.getNombrePlace()));
								}
								achat.show();
							}
						});
						achat.getBtnValider().addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								//TODO: vérifier places valides
								//TODO: vérifier infos carte de crédit valide
								//
							}
						});
						achat.show();
					}
			});
		}
	}
	
	private ComboBoxElement[] getCategoriePlace() {
		LinkedList<CategoriePlaces> listCat = this.controleurPrincipal.getCategoriePlace();
		ComboBoxElement[] listCatCombobox = new ComboBoxElement[listCat.size()];
		int i = 0;
		for(CategoriePlaces c : listCat){
			listCatCombobox[i] = new ComboBoxElement(c.getNumero(), c.getNom());
			i++;
		}
		return listCatCombobox;
	}
}
