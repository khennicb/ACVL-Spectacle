package controleur;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import modele.Billet;
import modele.CategoriePlaces;
import modele.Client;
import modele.Dossier;
import modele.Place;
import modele.Representation;
import modele.Spectacle;
import modele.Theme;
import vue.ComboBoxElement;
import vue.Fenetre;
import vue.FenetreAchat;
import vue.Center.PanelCenter;
import vue.Center.PanelCenterAchat;
import vue.Center.PanelCenterAchat.PlaceObject;
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
			Map<String, JButton> btnSpectacle = panelCenter.ajoutElmtRepresentation(r.getDate(), r.getHeure());
			btnSpectacle.get("btnAcheter").addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent arg0) {
						FenetreAchat achat = new FenetreAchat(getCategoriePlace());
						achat.getSpinner().addChangeListener(new ChangeListener() {
							@Override
							public void stateChanged(ChangeEvent e) {
								int nouveauNbPlace = (Integer)achat.getSpinner().getValue();
								int catId = ((ComboBoxElement)achat.getComboBoxCategory().getSelectedItem()).getIndex();
								CategoriePlaces cat = controleurPrincipal.getDatabaseManager().selectCategorie(catId);
								
								if(nouveauNbPlace < 0){
									achat.getSpinner().setValue(0);
									return;
								}
								while(nouveauNbPlace > achat.getNombrePlace()){
									PanelCenterAchat.PlaceObject place = achat.ajoutPlace();
									if(cat != null){
										HashMap<Integer, LinkedList<Integer>> rangs = controleurPrincipal.getDatabaseManager().selectAvailablePlace(r,cat);
										place.getRangComboBox().setModel(new DefaultComboBoxModel<Integer>(rangs.keySet().toArray(new Integer[rangs.keySet().size()])));
										Integer rang = (Integer)place.getRangComboBox().getSelectedItem();	
										if(rang != null){
											place.getNumeroComboBox().setModel(new DefaultComboBoxModel<Integer>(rangs.get(rang).toArray(new Integer[rangs.get(rang).size()])));
										}
										place.getRangComboBox().addActionListener(new ActionListener() {
											@Override
											public void actionPerformed(ActionEvent e) {
												Integer rang = (Integer)place.getRangComboBox().getSelectedItem();	
												if(rang != null && rangs.get(rang) != null){
													place.getNumeroComboBox().setModel(new DefaultComboBoxModel<Integer>(rangs.get(rang).toArray(new Integer[rangs.get(rang).size()])));
												}
											}
										});
									}
								}
								while(nouveauNbPlace < achat.getNombrePlace()){
									achat.enleverPlace();
								}
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
									HashMap<Integer, LinkedList<Integer>> rangs = controleurPrincipal.getDatabaseManager().selectAvailablePlace(r,cat);
									for(PlaceObject place : achat.getListePlace()){
										place.getRangComboBox().setModel(new DefaultComboBoxModel<Integer>(rangs.keySet().toArray(new Integer[rangs.keySet().size()])));
										Integer rang = (Integer)place.getRangComboBox().getSelectedItem();	
										if(rang != null){
											place.getNumeroComboBox().setModel(new DefaultComboBoxModel<Integer>(rangs.get(rang).toArray(new Integer[rangs.get(rang).size()])));
										}
										place.getRangComboBox().addActionListener(new ActionListener() {
											@Override
											public void actionPerformed(ActionEvent e) {
												Integer rang = (Integer)place.getRangComboBox().getSelectedItem();	
												if(rang != null && rangs.get(rang) != null){
													place.getNumeroComboBox().setModel(new DefaultComboBoxModel<Integer>(rangs.get(rang).toArray(new Integer[rangs.get(rang).size()])));
												}
											}
										});
									}
								}
								achat.show();
							}
						});
						
						achat.getBtnValider().addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								//vérification de non redondance des billets
								for(PlaceObject place: achat.getListePlace()){
									for(PlaceObject place2 : achat.getListePlace()){
										if(place != place2){
											if((Integer)place.getRangComboBox().getSelectedItem()==(Integer)place2.getRangComboBox().getSelectedItem()){
												if((Integer)place.getNumeroComboBox().getSelectedItem()==(Integer)place2.getNumeroComboBox().getSelectedItem()){
													return;
												}
											}
										}
									}
								}
								//vérification infos carte de crédit valide
								if(achat.getNumeroCBField().getText().length() == 0
										|| achat.getCodeField().getText().length() == 0
										|| achat.getDateExpField().getText().length() == 0){
									//TODO: on devrait faire une vérification plus approfondie de la date
									return;
								}
								int catId = ((ComboBoxElement)achat.getComboBoxCategory().getSelectedItem()).getIndex();
								CategoriePlaces cat = controleurPrincipal.getDatabaseManager().selectCategorie(catId);
								if(cat != null){
									float montant = achat.getNombrePlace() * cat.getTarif();
									Dossier dossier = new Dossier(montant, Calendar.getInstance().getTime(), (Client)ControleurClient.instance().utilisateurCourant);
									controleurPrincipal.getDatabaseManager().insertDossier(dossier);
									for(PlaceObject placeObj: achat.getListePlace()){
										Integer rang = (Integer)placeObj.getRangComboBox().getSelectedItem();
										Integer numero = (Integer)placeObj.getNumeroComboBox().getSelectedItem();
										if(rang == null || numero == null){
											continue;
										}
										Place place = controleurPrincipal.getDatabaseManager().selectPlace(r.getSalle(), rang, numero);
										Billet billet = new Billet(place, dossier, r);
										controleurPrincipal.getDatabaseManager().insertPlaceOccupe(billet);
									}
									achat.close();
								}
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
