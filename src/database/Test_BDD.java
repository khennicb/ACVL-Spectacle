/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;
import modele.*;
import java.sql.*;
import java.util.LinkedList;
/**
 *
 * @author benkh_000
 */
public class Test_BDD {

    
    LinkedList<Theme> listTheme = new LinkedList<>();
    LinkedList<Spectacle> listSpectacle = new LinkedList<>();
    LinkedList<Salle> listSalle = new LinkedList<>();
    LinkedList<Representation> listRepresentation = new LinkedList<>();
    LinkedList<Place> listPlace = new LinkedList<>();
    LinkedList<SiegeOccupe> listSiege = new LinkedList<>();
    LinkedList<Utilisateur> listUtilisateur = new LinkedList<>();
    LinkedList<Dossier> listDossier = new LinkedList<>();
    
    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) {
        
        Test_BDD test_BDD = new Test_BDD();

        test_BDD.initializeBDD();
        
        try {
            test_BDD.testClient();
            test_BDD.testSpectacle();
            test_BDD.testSalle();
            test_BDD.testPlace();            
        }catch(Exception e) {
            
        }

        test_BDD.terminateBDD();
    }
    
    public void initializeBDD(){
        DatabaseManager.getDatabaseManager().connect();
        DatabaseManager.getDatabaseManager().createTables();
        DatabaseManager.getDatabaseManager().printTable();
    }
    
    public void testClient(){
        
        
        Client client = new Client("login", "mdp", "Bernard", "nia", "totodu38@tes_pa_bo.fr");
        System.out.println("Client id = " + client.getNumero());
        DatabaseManager.getDatabaseManager().insertUtilisateur(client);
        System.out.println("Client id = " + client.getNumero());

    }
    public void testSpectacle(){
        Theme theme1 = new Theme("Sauvetage des licornes");
        Spectacle spectacle1 = new Spectacle(1, "Comment carresser l animal", "Demonstration de carressage avancé de ces animaux magiques", theme1);
        Theme theme2 = new Theme("Contemplation du ciel");
        Spectacle spectacle2 = new Spectacle(1, "L'interpolation des nuages", "Exposé surprennant des théorème de visualisation des spectre nuageux", theme2);
        
        System.out.println("id :   theme1= " + theme1.getNumero() + "spectacle1=" + spectacle1.getNumero());
        System.out.println("id :   theme2= " + theme2.getNumero() + "spectacle2=" + spectacle2.getNumero());
        DatabaseManager.getDatabaseManager().insertTheme(theme1);
        DatabaseManager.getDatabaseManager().insertSpectacle(spectacle1);
        DatabaseManager.getDatabaseManager().insertTheme(theme2);
        DatabaseManager.getDatabaseManager().insertSpectacle(spectacle2);
        System.out.println("id :   theme1= " + theme1.getNumero() + "spectacle1=" + spectacle1.getNumero());
        System.out.println("id :   theme2= " + theme2.getNumero() + "spectacle2=" + spectacle2.getNumero());
        
        LinkedList<Spectacle> list = DatabaseManager.getDatabaseManager().selectAllSpectacle();
        
        for (Spectacle s : list){
            System.out.println("Numero=" + s.getNumero() + "\tNom=" + s.getNom() + "\tTheme=" + s.getTheme().getNom() + "\tDescription=" + s.getDescription());
        }

        Spectacle s = DatabaseManager.getDatabaseManager().selectSpectacle(spectacle1.getNumero());
        System.out.println("Sectacle choosed");
        System.out.println("Numero=" + s.getNumero() + "\tNom=" + s.getNom() + "\tTheme=" + s.getTheme().getNom() + "\tDescription=" + s.getDescription());
        
        
    }
    public void testSalle(){
        Salle salle1 = new Salle("H104");
        Salle salle2 = new Salle("Resto etudiant");
        Salle salle3 = new Salle("Tram B");
        
        System.out.println("id : \t" + salle1.getNumero() + "\t" + salle2.getNumero() + "\t" + salle3.getNumero());
        
        DatabaseManager.getDatabaseManager().insertSalle(salle1);
        DatabaseManager.getDatabaseManager().insertSalle(salle2);
        DatabaseManager.getDatabaseManager().insertSalle(salle3);
        
        System.out.println("id : \t" + salle1.getNumero() + "\t" + salle2.getNumero() + "\t" + salle3.getNumero());

    }
    
    
    public void testPlace(){
        Salle salle = new Salle("salle 1");
        CategoriePlaces categorie = new CategoriePlaces("Elite", 1000);
        Place place = new Place(1, 1, categorie, salle);
        
        DatabaseManager.getDatabaseManager().insertSalle(salle);
        DatabaseManager.getDatabaseManager().insertPlace(place);
    }
    
    
    public void testRepresentation(){
        Theme theme = new Theme("Sauvetage des licornes");
        Spectacle spectacle = new Spectacle(1, "Comment carresser l animal", "Demonstration de carressage avancé de ces animaux magiques", theme);
        Salle salle = new Salle("salle 1");
        spectacle.addRepresentation(new Date(2016, 01,20), 0, salle);
        Representation rep = spectacle.getAllRepresentations().get(0);
        
        DatabaseManager.getDatabaseManager().insertTheme(theme);
        DatabaseManager.getDatabaseManager().insertSpectacle(spectacle);
        DatabaseManager.getDatabaseManager().insertSalle(salle);
        DatabaseManager.getDatabaseManager().insertRepresentation(rep);
    }
    
    public void terminateBDD(){
        DatabaseManager.getDatabaseManager().dropAllTable();
        DatabaseManager.getDatabaseManager().close();
    }
   
}
