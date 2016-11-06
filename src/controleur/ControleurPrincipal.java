/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;


import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

import database.DatabaseManager;
import modele.*;
import vue.*;
import vue.Center.*;
import vue.Header.*;

/**
 *
 * @author noon
 */
public class ControleurPrincipal {
    
	private FenetrePrincipale vue;
    private ControleurUtilisateur userControleur;
    private DatabaseManager dm;
    
    public ControleurPrincipal() {
    	this.initDataBase();
    	vue = new FenetrePrincipale(new PanelHeaderConnexion(), new PanelCenterConnexion() );
    	EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vue.show();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
    	    	
    	((PanelCenterConnexion)(vue.getCenter())).getBtnConnexion().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String login = ((PanelCenterConnexion)(vue.getCenter())).getTextField_connexion_login().getText();
				@SuppressWarnings("deprecation")
				String motDePasse = ((PanelCenterConnexion)(vue.getCenter())).getPasswordField_connexion_mdp().getText();
				try {
					if(connexion(login, motDePasse)){
						userControleur.loadHome();
					} else {
						((PanelCenterConnexion)(vue.getCenter())).setWarningConnexion("Login ou mot de passe incorrect");
					}
				} catch (UnsupportedEncodingException
						| NoSuchAlgorithmException e1) {
					e1.printStackTrace();
				}
			}
		});
    	
    	ControleurPrincipal cp = this;
    	
    	((PanelCenterConnexion)(vue.getCenter())).getBtnInscription().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String login = ((PanelCenterConnexion)(vue.getCenter())).getTextField_inscription_login().getText();
				String email = ((PanelCenterConnexion)(vue.getCenter())).getTextField_inscription_email().getText();
				String nom = ((PanelCenterConnexion)(vue.getCenter())).getTextField_inscription_Nom().getText();
				String prenom = ((PanelCenterConnexion)(vue.getCenter())).getTextField_inscription_prenom().getText();
				@SuppressWarnings("deprecation")
				String motDePasse = ((PanelCenterConnexion)(vue.getCenter())).getPasswordField_inscription_mdp().getText();
				@SuppressWarnings("deprecation")
				String motDePasseConfirm = ((PanelCenterConnexion)(vue.getCenter())).getPasswordField_inscription_confirm_mdp().getText();
				//inscription
				if(!login.isEmpty() && !nom.isEmpty() && !email.isEmpty() && !prenom.isEmpty() && !motDePasse.isEmpty()) {
					if(motDePasse.equals(motDePasseConfirm)) {
						Utilisateur utilisateur = new Client(login, motDePasse, nom, prenom, email);
						dm.insertUtilisateur(utilisateur);
						userControleur = ControleurClient.instance();
			    		userControleur.setUtilisateurCourant(utilisateur);
			    		userControleur.setControleurPrincipal(cp);
			    		userControleur.loadHome();
						
					} else {
						((PanelCenterConnexion)(vue.getCenter())).setWarningInscription("Les deux mots de passe sont différents");
					}
				} else {
					((PanelCenterConnexion)(vue.getCenter())).setWarningInscription("Tous les champs doivent être renseignés");
				}
				
			}
		});
    	
    	vue.getFrame().addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
               dm.close();
            }
          });
    	
    }
       
    public void addSpectacle(){
        // TODO
    }
    
    public List<Spectacle> getAllSpectacles(){
        List<Spectacle> spectacles = dm.selectAllSpectacle();
        return spectacles;
    }
    
    
    public List<Representation> getAllRepresentations(Spectacle s){
        return s.getAllRepresentations();
    }
    
    public void addRepresentation(Spectacle s, Date date, int heure, Salle salle){
        // TODO : choisir la salle automatiquement (en fonction de celles qui sont libres)?
        s.addRepresentation(date, heure, salle);
    }
    
    public boolean connexion(String login, String motDePasse) throws UnsupportedEncodingException, NoSuchAlgorithmException{
    	//verification login et mot de passe
    	if(login.isEmpty() || motDePasse.isEmpty()){
    		return false;
    	}
    	
    	//verification base de donnees
    	Utilisateur utilisateur = dm.selectUtilisateur(login, motDePasse);
    	
    	if(utilisateur == null) {
    		return false;
    	}
    	
    	if(utilisateur instanceof Client) {
    		//si l'utilisateur est un client
    		userControleur = ControleurClient.instance();
    		userControleur.setUtilisateurCourant(utilisateur);
    	}else {
    		//si l'utilisateur est responsable
    		userControleur = ControleurResponsable.instance();
    		userControleur.setUtilisateurCourant(utilisateur);
    	}
    	
    	userControleur.setControleurPrincipal(this);
    	return true;
    	
    }
    
    public FenetrePrincipale getVue() {
		return vue;
	}

	public DatabaseManager getDatabaseManager() {
		return dm;
	}
	
	
	public static void main(String [] args) {
			ControleurPrincipal resaSpectacle = new ControleurPrincipal();

	}
	
	private void initDataBase() {
		dm = DatabaseManager.getDatabaseManager();
    	dm.connect();
    	dm.dropAllTable();
    	dm.createTables();
    	
    	//verifier si la table utilisateur est vide
    	if(dm.isUtilisateurEmpty()){
    		dm.insertUtilisateur(new ResponsableProgrammation("admin", "admin"));
    		//insertion de client
    		dm.insertUtilisateur(new Client("login_1","mdp1" , "Bernard", "Nia", "totodu38@tes_pa_bo.fr"));
    		dm.insertUtilisateur(new Client("login_2","mdp2" , "Bruno", "Frage", "xxxdark59@skyfighter.fr"));
    	}
    	//verifier si theme est vide
    	if(dm.isThemeEmpty()){
    		dm.insertTheme(new Theme("Sauvetage des licornes"));
    		dm.insertTheme(new Theme("Contemplation du ciel"));
    	}
    	//verifier si la table spectacle est vide
    	if(dm.isSpectacleEmpty()){
    		dm.insertSpectacle(new Spectacle(1, "Comment carresser l animal", "Demonstration de carressage avancé de ces animaux magiques", dm.selectTheme(1)));
    		Theme t = dm.selectTheme(2);
    		dm.insertSpectacle(new Spectacle(1, "L'interpolation des nuages", "Exposé surprennant des théorême de visualisation des spectre nuageux", t));
    	}
    	//verifier si la table representation est vide
    	//verifier si la table salle est vide
    	//verifier si la table place est vide
    	
	}
    
}
