/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;


import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
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
    	dm = DatabaseManager.getDatabaseManager();
    	dm.connect();
    	EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vue = new FenetrePrincipale(new PanelHeaderConnexion(), new PanelCenterConnexion() );
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
				String motDePasse = ((PanelCenterConnexion)(vue.getCenter())).getPasswordField_connexion_mdp().getText();
				if(connexion(login, motDePasse)){
					
					
				} else {
					((PanelCenterConnexion)(vue.getCenter())).setWarningConnexion("Login ou mot de passe incorrect");
				}
			}
		});
    	
    	
    }
       
    public void addSpectacle(){
        // TODO
    }
    
    public List<Spectacle> getAllSpectacles(){
        // TODO 
        return null;
    }
    
    
    public List<Representation> getAllRepresentations(Spectacle s){
        return s.getAllRepresentations();
    }
    
    public void addRepresentation(Spectacle s, Date date, int heure, Salle salle){
        // TODO : choisir la salle automatiquement (en fonction de celles qui sont libres)?
        s.addRepresentation(date, heure, salle);
    }
    
    public boolean connexion(String login, String motDePasse){
    	//verification login et mot de passe
    	if(login.isEmpty() || motDePasse.isEmpty()){
    		return false;
    	}
    	//TODO verification base de donnees
    	//si l'utilisateur est responsable
		//si l'utilisateur est un client
		userControleur = ControleurClient.instance();
  
    	return true;
    	
    }
    
    
    
}
