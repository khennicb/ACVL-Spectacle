/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;
import java.sql.*;
import modele.Client;
import modele.Spectacle;
import modele.Theme;
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

        test_BDD.terminateBDD();
    }
    
    public void initializeBDD(){
        DatabaseManager.getDatabaseManager().connect();
        DatabaseManager.getDatabaseManager().createTables();
        DatabaseManager.getDatabaseManager().printTable();
    }
    
    public void testClient(){
        Client client = new Client("login", "mdp", "Bernard", "Dinoumouk", "totodu38@tes_pa_bo.fr");
        DatabaseManager.getDatabaseManager().insertUtilisateur(client);
    }
    public void testSpectacle(){
        Theme theme = new Theme("Sauvetage des licornes");
        Spectacle spectacle = new Spectacle(1, "Comment carresser l animal", "Demonstration de carressage avancé de ces animaux magiques", theme);
        
        DatabaseManager.getDatabaseManager().insertTheme(theme);
        DatabaseManager.getDatabaseManager().insertSpectacle(spectacle);
    }
    
    public void terminateBDD(){
        DatabaseManager.getDatabaseManager().dropAllTable();
        DatabaseManager.getDatabaseManager().close();
    }
   
}
