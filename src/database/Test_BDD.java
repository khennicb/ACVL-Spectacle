/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;
import java.sql.*;
import modele.Client;
/**
 *
 * @author benkh_000
 */
public class Test_BDD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        DatabaseManager.getDatabaseManager().connect();
        DatabaseManager.getDatabaseManager().createTables();
        DatabaseManager.getDatabaseManager().printTable();
        
        Client client = new Client("login", "mdp", "Bernard", "Dinoumouk", "totodu38@tes_pa_bo.fr");
        DatabaseManager.getDatabaseManager().insertUtilisateur(client);
        
        
        DatabaseManager.getDatabaseManager().dropAllTable();
        DatabaseManager.getDatabaseManager().close();
        
  }
   
}
