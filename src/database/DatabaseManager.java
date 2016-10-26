/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 *  Implemente Singleton design pattern
 */
public class DatabaseManager {
    
    /** pre-initialized instance */
    private static DatabaseManager database_Manager = new DatabaseManager("data_base.db");
    
    private DatabaseManager(String dBPath){
        DBPath = dBPath;
    }
    
    public static DatabaseManager getDatabaseManager(){
        return database_Manager;
    }
    
    
    private String DBPath = "Chemin aux base de donnée SQLite";
    private Connection connection = null;
    private Statement statement = null;
 
 
    public void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:" + DBPath);
            statement = connection.createStatement();
            System.out.println("Connexion a " + DBPath + " avec succès");
        } catch (ClassNotFoundException notFoundException) {
            notFoundException.printStackTrace();
            System.out.println("Erreur de connecxion");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println("Erreur de connecxion");
        }
    }
 
    public void close() {
        try {
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void createTables(){
        
        createUtilisateurTable();
        createThemeTable();
        createSpectacleTable();
        createSalleTable();
        createRepresentationTable();
        createCategorieTable();
        createPlaceTable();
        
        
        
    }
    
    public void createUtilisateurTable() {
        String userTable =  "CREATE TABLE IF NOT EXISTS UTILISATEUR (" +
                                " UTILISATEUR_ID   INT                PRIMARY KEY  NOT NULL," +
                                " LOGIN            TEXT               NOT NULL, " + 
                                " Password         INT                NOT NULL, " + 
                                " TYPE_UTILISATEUR INT                NOT NULL, " + 
                                " NOM              TEXT               NOT NULL, " + 
                                " PRENOM           TEXT               NOT NULL, " + 
                                " MAIL             TEXT               NOT NULL " + 
                            ")"; 
        try {
            statement.executeUpdate(userTable);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void createThemeTable() {
        String userTable =  "CREATE TABLE IF NOT EXISTS THEME (" +
                                " THEME_ID   INT                PRIMARY KEY  NOT NULL," +
                                " NOM        TEXT               NOT NULL " + 
                            ")"; 
        try {
            statement.executeUpdate(userTable);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void createSpectacleTable() {
        String userTable =  "CREATE TABLE IF NOT EXISTS SPECTACLE (" +
                                " SPECTACLE_ID     INT                PRIMARY KEY  NOT NULL," +
                                " THEME            INT                NOT NULL, " + 
                                " NOM              TEXT               NOT NULL, " + 
                                " DESCRIPTION      TEXT               NOT NULL, " + 
                                " FOREIGN KEY(THEME) REFERENCES THEME(THEME_ID)  " +
                            ")"; 
        try {
            statement.executeUpdate(userTable);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void createSalleTable() {
        String userTable =  "CREATE TABLE IF NOT EXISTS SALLE (" +
                                " SALLE_ID     INT                PRIMARY KEY  NOT NULL," +
                                " NOM          TEXT               NOT NULL " + 
                            ")"; 
        try {
            statement.executeUpdate(userTable);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void createRepresentationTable() {
        String userTable =  "CREATE TABLE IF NOT EXISTS REPRESENTATION (" +
                                " REPRESENTATION_ID  INT                PRIMARY KEY  NOT NULL," +
                                " SPECTACLE          INT                NOT NULL, " + 
                                " SALLE              INT                NOT NULL, " + 
                                " DATE               TEXT               NOT NULL, " +   // as ISO8601 strings ("YYYY-MM-DD").
                                " HEURE              INT                NOT NULL, " + 
                                " FOREIGN KEY(SPECTACLE)  REFERENCES SPECTACLE(SPECTACLE_ID),  " +
                                " FOREIGN KEY(SALLE)      REFERENCES SALLE(SALLE_ID)  " +
                            ")"; 
        try {
            statement.executeUpdate(userTable);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void createCategorieTable() {
        String userTable =  "CREATE TABLE IF NOT EXISTS CATEGORIE (" +
                                " CATEGORIE_ID       INT                PRIMARY KEY  NOT NULL," +
                                " NOM                TEXT               NOT NULL, " + 
                                " TARIF              REAL               NOT NULL " + 
                            ")"; 
        try {
            statement.executeUpdate(userTable);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void createPlaceTable() {
        String userTable =  "CREATE TABLE IF NOT EXISTS PLACE (" +
                                " PLACE_ID           INT                PRIMARY KEY  NOT NULL," +
                                " SALLE              INT                NOT NULL, " + 
                                " CATEGORIE          INT                NOT NULL, " +   
                                " NOMERO_DE_RANG     INT                NOT NULL, " + 
                                " PLACE_DANS_LE_RANG INT                NOT NULL, " +
                                " FOREIGN KEY(SALLE)      REFERENCES SALLE(SALLE_ID), " +
                                " FOREIGN KEY(CATEGORIE)  REFERENCES CATEGORIE(CATEGORIE_ID)  " +
                            ")"; 
        try {
            statement.executeUpdate(userTable);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void createPlaceOccupeTable() {
        String userTable =  "CREATE TABLE IF NOT EXISTS PLACE_OCCUPE (" +
                                " PLACE              INT                PRIMARY KEY  NOT NULL," +
                                " REPRESENTATION     INT                PRIMARY KEY  NOT NULL," + 
                                " DOSSIER            INT                NOT NULL, " +   
                                " PROPRIETAIRE       INT                NOT NULL, " + 
                                " ACHETE             INT(1)                NOT NULL, " +
                                " FOREIGN KEY(SALLE)      REFERENCES SALLE(SALLE_ID), " +
                                " FOREIGN KEY(REPRESENTATION)  REFERENCES REPRESENTATION(REPRESENTATION_ID),  " +
                                " FOREIGN KEY(DOSSIER)      REFERENCES DOSSIER(DOSSIER_ID), " +
                                " FOREIGN KEY(PROPRIETAIRE)      REFERENCES UTILISATEUR(UTILISATEUR_ID) " +
                            ")"; 
        try {
            statement.executeUpdate(userTable);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void printTable(){
        
        try {
            DatabaseMetaData md = connection.getMetaData();
            ResultSet rs;
            rs = md.getTables(null, null, "%", null);
            while (rs.next()) {
                System.out.println(rs.getString(3));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        
    }
    
    
    public void dropAllTable(){

        String place_occupeTable    = "DROP TABLE PLACE_OCCUPE";
        String placeTable           = "DROP TABLE PLACE";
        String representationTable  = "DROP TABLE REPRESENTATION";
        String spectacleTable       = "DROP TABLE SPECTACLE";
        String salleTable           = "DROP TABLE SALLE";
        String categorieTable       = "DROP TABLE CATEGORIE";
        String dossierTable         = "DROP TABLE DOSSIER";
        String userTable            = "DROP TABLE UTILISATEUR";
        String themeTable           = "DROP TABLE THEME";
        
        
        try {
            statement.executeUpdate(place_occupeTable);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            statement.executeUpdate(placeTable);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            statement.executeUpdate(userTable);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            statement.executeUpdate(themeTable);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            statement.executeUpdate(spectacleTable);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            statement.executeUpdate(salleTable);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            statement.executeUpdate(representationTable);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }      
        try {
            statement.executeUpdate(placeTable);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }      
        try {
            statement.executeUpdate(categorieTable);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }                
    }
    
}
