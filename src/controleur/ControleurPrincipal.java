/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.util.Date;
import java.util.List;
import modele.*;

/**
 *
 * @author noon
 */
public class ControleurPrincipal {
    
    
    public void addSpectacle(){
        // TODO
    }
    
    public List<Spectacle> getAllSpectacls(){
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
}
