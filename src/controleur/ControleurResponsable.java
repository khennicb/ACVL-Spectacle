package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.text.DateFormatter;

import modele.Representation;
import modele.Salle;
import modele.Spectacle;
import modele.Theme;
import vue.ComboBoxElement;
import vue.Center.PanelCenter;
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
					ControleurResponsable.instance().majListeSpectacles(panelCenterHome, spectacles);
					controleurPrincipal.getVue().show();
				}
				else{
					panelCenterHome.viderListeSpectacle();
					LinkedList<Spectacle> spectacles = controleurPrincipal.getDatabaseManager().selectAllSpectacle();
					ControleurResponsable.instance().majListeSpectacles(panelCenterHome, spectacles);
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
					ControleurResponsable.instance().loadDetailSpectacle(s.getNumero());					
				}});
		}
	}
	
	@Override
	public void loadDetailSpectacle(int numeroSpectacle){
		Spectacle spectacle = this.controleurPrincipal.getDatabaseManager().selectSpectacle(numeroSpectacle);
		PanelCenterSpectacleResponsable panelCenter = new PanelCenterSpectacleResponsable(spectacle.getNom());
		LinkedList<Salle> salles = this.controleurPrincipal.getDatabaseManager().selectAllSalle();
		ComboBoxElement[] elements = new ComboBoxElement[salles.size()];
		int i = 0;
		for(Salle salle: salles){
			elements[i] = new ComboBoxElement(salle.getNumero(), salle.getNom());
			i++;
		}
		panelCenter.getComboBoxSalle().setModel(new DefaultComboBoxModel<>(elements));
		panelCenter.getBtnAjout().addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
				try{
					Date date = df.parse(panelCenter.getTxtDate().getText());
					int heure = Integer.parseInt(panelCenter.getTxtHeure().getText());
					if(panelCenter.getComboBoxSalle().getSelectedItem() == null){
						return;
					}
					int salleId = ((ComboBoxElement)panelCenter.getComboBoxSalle().getSelectedItem()).getIndex();
					Salle salle = controleurPrincipal.getDatabaseManager().selectSalle(salleId);
					if(salle==null){
						return;
					}
					Representation representation = new Representation(date, heure, salle, spectacle);
					//Verification du non chevauchement de seance sur une salle
					if(controleurPrincipal.getDatabaseManager().existsOverlappingRepresentation(new java.sql.Date(date.getTime()), heure, salle)){
						return;
					}
					controleurPrincipal.getDatabaseManager().insertRepresentation(representation);
					JButton btnSpectacle = panelCenter.ajoutElmtRepresentation(representation.getDate(),
							representation.getHeure(), 0, 0);
					btnSpectacle.addActionListener(new ActionListener(){
						@Override
						public void actionPerformed(ActionEvent arg0) {
							//TODO
						}});
					controleurPrincipal.getVue().show();
				}
				catch(ParseException ex){
					ex.printStackTrace();
				}
			}
		});
		this.controleurPrincipal.getVue().setCenter(panelCenter);
		LinkedList<Representation> representations = this.controleurPrincipal.getDatabaseManager().selectRepresentations(spectacle);
		majListeRepresentations(panelCenter, representations);
		this.controleurPrincipal.getVue().show();
	}
	
	public void majListeRepresentations(PanelCenterSpectacleResponsable panelCenter, LinkedList<Representation> representations){
		for(Representation r : representations) {
			int nbBillet = 0;
			int nbReserv = 0;
			JButton btnSpectacle = panelCenter.ajoutElmtRepresentation(r.getDate(), r.getHeure(), nbBillet, nbReserv);
			btnSpectacle.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
					//TODO
				}});
		}
	}
	
}
