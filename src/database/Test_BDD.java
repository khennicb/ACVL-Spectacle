/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;
import modele.*;
import java.sql.*;
import java.util.Vector;
/**
 *
 * @author benkh_000
 */
public class Test_BDD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Test_BDD test_BDD = new Test_BDD();

        test_BDD.initializeBDD();
        
        test_BDD.testClient();

        test_BDD.testSpectacle();
        
        test_BDD.testSalle();
        
        test_BDD.testPlace();

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
        Theme theme = new Theme("Sauvetage des licornes");
        Spectacle spectacle = new Spectacle(1, "Comment carresser l animal", "Demonstration de carressage avancé de ces animaux magiques", theme);
        
        System.out.println("id :   theme= " + theme.getNumero() + "spectacle=" + spectacle.getNumero());
        DatabaseManager.getDatabaseManager().insertTheme(theme);
        DatabaseManager.getDatabaseManager().insertSpectacle(spectacle);
        System.out.println("id :   theme= " + theme.getNumero() + "spectacle=" + spectacle.getNumero());
        
        Vector<Spectacle> vector = DatabaseManager.getDatabaseManager().selectAllSpectacle();
        
        for (Spectacle s : vector){
            System.out.println("Numero=" + s.getNumero() + "\tNom=" + s.getNom() + "\tTheme=" + s.getTheme().getNom() + "\tDescription=" + s.getDescription());
        }
        
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
