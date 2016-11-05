/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;
import java.sql.*;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modele.*;

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
            System.out.println("Erreur de connexion");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println("Erreur de connexion");
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
        createPlaceOccupeTable();
        
    }
    
    
    
    
    
    public void createUtilisateurTable() {
        String userTable =  "CREATE TABLE IF NOT EXISTS UTILISATEUR (" +
                                " UTILISATEUR_ID   INTEGER            PRIMARY KEY AUTOINCREMENT ," +
                                " LOGIN            TEXT               NOT NULL, " + 
                                " Password         TEXT                NOT NULL, " + 
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
                                " THEME_ID   INTEGER                PRIMARY KEY AUTOINCREMENT NOT NULL," +
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
                                " SPECTACLE_ID     INTEGER                PRIMARY KEY AUTOINCREMENT NOT NULL," +
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
                                " SALLE_ID     INTEGER            PRIMARY KEY AUTOINCREMENT NOT NULL," +
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
                                " REPRESENTATION_ID  INTEGER                PRIMARY KEY AUTOINCREMENT NOT NULL," +
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
                                " CATEGORIE_ID       INTEGER                PRIMARY KEY AUTOINCREMENT NOT NULL," +
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
                                " PLACE_ID           INTEGER                PRIMARY KEY AUTOINCREMENT NOT NULL," +
                                " SALLE              INT                NOT NULL, " + 
                                " CATEGORIE          INT                NOT NULL, " +   
                                " NUMERO_DE_RANG     INT                NOT NULL, " + 
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
                                " PLACE              INT                NOT NULL," +
                                " REPRESENTATION     INT                NOT NULL," + 
                                " DOSSIER            INT                , " +   
                                " PROPRIETAIRE       INT                NOT NULL, " + 
                                " ACHETE             INT(1)             NOT NULL, " +
                                " FOREIGN KEY(REPRESENTATION)  REFERENCES REPRESENTATION(REPRESENTATION_ID),  " +
                                " FOREIGN KEY(DOSSIER)      REFERENCES DOSSIER(DOSSIER_ID), " +
                                " FOREIGN KEY(PROPRIETAIRE)      REFERENCES UTILISATEUR(UTILISATEUR_ID), " +
                                " PRIMARY KEY (PLACE, REPRESENTATION) " +
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
            statement.executeUpdate(categorieTable);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }                
    }
    
    // INSERT

    
    public void insertUtilisateur(Utilisateur utilisateur){
        try {
                
            int key = 0;

            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO UTILISATEUR (LOGIN, PASSWORD, TYPE_UTILISATEUR, NOM, PRENOM, MAIL) VALUES(?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, utilisateur.getLogin());
            preparedStatement.setString(2, utilisateur.getPassword());
            
            if(utilisateur instanceof Client){
                Client client = (Client) utilisateur;
                preparedStatement.setInt(3, 0);
                preparedStatement.setString(4, client.getNom());
                preparedStatement.setString(5, client.getPrenom());
                if(client.getMail() != null) {
                    preparedStatement.setString(6, client.getMail());
                }
            } else if (utilisateur instanceof ResponsableProgrammation) {
                preparedStatement.setInt(3, 1);
            } else if (utilisateur instanceof SuperUser) {
                preparedStatement.setInt(3, 2);
            }
            
            preparedStatement.executeUpdate();
                    
            ResultSet rs = preparedStatement.getGeneratedKeys();
            
            if (rs != null && rs.next()) {
                key = (int)rs.getLong(1);
            }
            
            utilisateur.setNumero(key);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    public void insertTheme(Theme theme){
        try {
            
            int key = 0;
            
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO THEME (NOM) VALUES(?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, theme.getNom());
            preparedStatement.executeUpdate();
        
            ResultSet rs = preparedStatement.getGeneratedKeys();
            
            if (rs != null && rs.next()) {
                key = (int)rs.getLong(1);
            }
            
            theme.setNumero(key);

        
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public void insertSpectacle(Spectacle spectacle){
        
        try {
            int key = 0;
            
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO SPECTACLE (THEME, NOM, DESCRIPTION) VALUES(?,?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, spectacle.getTheme().getNumero());
            preparedStatement.setString(2, spectacle.getNom());
            preparedStatement.setString(3, spectacle.getDescription());
            preparedStatement.executeUpdate();
            
            ResultSet rs = preparedStatement.getGeneratedKeys();
            
            if (rs != null && rs.next()) {
                key = (int)rs.getLong(1);
            }
            
            spectacle.setNumero(key);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
public void insertDossier(Dossier dossier){
        
        try {
            int key = 0;
            
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO DOSSIER(MONTANT, DATE) VALUES(?,?,?)", Statement.RETURN_GENERATED_KEYS);
            
            
            String date = "" + dossier.getDate_achat().getYear()+ "-" + dossier.getDate_achat().getMonth()+ "-" + dossier.getDate_achat().getDay() ;
            
            preparedStatement.setString(3, date);  // as ISO8601 strings ("YYYY-MM-DD").
            
            preparedStatement.setFloat(1, dossier.getMontant());
            preparedStatement.setString(2, date);
            preparedStatement.executeUpdate();
            
            ResultSet rs = preparedStatement.getGeneratedKeys();
            
            if (rs != null && rs.next()) {
                key = (int)rs.getLong(1);
            }
            
            dossier.setNumero(key);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertRepresentation(Representation representation){
        
        
        try {
            int key = 0;
            
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO REPRESENTATION (SPECTACLE, SALLE, DATE, HEURE) VALUES(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, representation.getSpectacle().getNumero());
            preparedStatement.setInt(2, representation.getSalle().getNumero());
            
            String date = "" + representation.getDate().getYear()+ "-" + representation.getDate().getMonth()+ "-" +representation.getDate().getDay() ;
            
            preparedStatement.setString(3, date);  // as ISO8601 strings ("YYYY-MM-DD").
            preparedStatement.setInt(4, representation.getHeure());
            preparedStatement.executeUpdate();
            
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs != null && rs.next()) {
                key = (int)rs.getLong(1);
            }            
            representation.setNumero(key);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    

    public void insertSalle(Salle salle){
        
        try {
            int key = 0;
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO SALLE (NOM) VALUES(?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, salle.getNom());
            preparedStatement.executeUpdate();
            
            ResultSet rs = preparedStatement.getGeneratedKeys();
            
            if (rs != null && rs.next()) {
                key = (int)rs.getLong(1);
            }
            salle.setNumero(key);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    
    public void insertCategoriePlaces(CategoriePlaces categoriePlace){
        
        try {
            int key = 0;
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO CATEGORIE (NOM, TARIF) VALUES(?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, categoriePlace.getNom());
            preparedStatement.setInt(2, categoriePlace.getNumero());
            
            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            
            if (rs != null && rs.next()) {
                key = (int)rs.getLong(1);
            }
            categoriePlace.setNumero(key);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void insertPlace(Place place){
        
        try {
            int key = 0;
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO PLACE (SALLE, CATEGORIE, NUMERO_DE_RANG, PLACE_DANS_LE_RANG) VALUES(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, place.getSalle().getNumero());
            preparedStatement.setInt(2, place.getCategorie().getNumero());
            preparedStatement.setInt(3, place.getNumeroRang());
            preparedStatement.setInt(4, place.getPlaceRang());
            
            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            
            if (rs != null && rs.next()) {
                key = (int)rs.getLong(1);
            }
            
            place.setNumero(key);
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public void insertPlaceOccupe(SiegeOccupe siegeOccupe){
        
        int representation_id;
        int dossier_id;
        int place_id;
        int utilisateur_id;
        if(siegeOccupe instanceof Billet) {
            representation_id = ((Billet)siegeOccupe).getRepresentation().getNumero();
            dossier_id = ((Billet)siegeOccupe).getDossier().getNumero();
            place_id = ((Billet)siegeOccupe).getPlace().getNumero();
            utilisateur_id = ((Billet)siegeOccupe).getDossier().getClient().getNumero();
        } else {
            representation_id = ((Reservation)siegeOccupe).getRepresentation().getNumero();
            dossier_id = 0;
            place_id = ((Reservation)siegeOccupe).getPlace().getNumero();
            utilisateur_id = ((Reservation)siegeOccupe).getClient().getNumero();
        }
        
        try {
            int key = 0;
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO PLACE_OCCUPE (REPRESENTATION, PLACE, DOSSIER, UTILISATEUR) VALUES(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, representation_id);
            preparedStatement.setInt(2, dossier_id);
            preparedStatement.setInt(3, place_id);
            preparedStatement.setInt(4, utilisateur_id);

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();

            siegeOccupe.setNumero(key);

            if (rs != null && rs.next()) {
                key = (int)rs.getLong(1);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    
    public Utilisateur selectUtilisateur(String login, String password){
        Utilisateur utilisateur = null;
        
        try {
            ResultSet rs = statement.executeQuery( "SELECT * FROM UTILISATEUR WHERE LOGIN=\"" + login + "\" AND PASSWORD=\"" + password + "\" ;" );
            while ( rs.next() ) {
                if(rs.getInt("TYPE_UTILISATEUR") == 0) {
                    // L'utilisateur est un client
                    Client client  = new Client(login, password, rs.getString("NOM"), rs.getString("PRENOM"), rs.getString("MAIL"));
                    utilisateur = client;
                } else {
                    // L'utilisateur est le Responsable de la programmation
                    ResponsableProgrammation responsable  = new ResponsableProgrammation(login, password);
                    utilisateur = responsable;
                }
                utilisateur.setNumero(rs.getInt("UTILISATEUR_ID"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return utilisateur;
    }
    
    public Theme selectTheme(int theme_id){
        Theme theme = null;
        
        try {
            ResultSet rs = statement.executeQuery( "SELECT * FROM THEME WHERE THEME_ID=" + theme_id + ";" );
            while ( rs.next() ) {
                theme  = new Theme(rs.getString("nom"));
                theme.setNumero(theme_id);
            }
        
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return theme;
        
    }
    
    public Salle selectSalle(int salle_id){
        Salle salle = null;
        
        try {
            ResultSet rs = statement.executeQuery( "SELECT * FROM Salle WHERE SALLE_ID=" + salle_id + ";" );
            while ( rs.next() ) {
                salle = new Salle(rs.getString("nom"));
                salle.setNumero(salle_id);
            }
        
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return salle;
    }
    
    public Spectacle selectSpectacle(int spectacle_id){
        Spectacle spectacle = null;
        
        try {
            ResultSet rs = statement.executeQuery( "SELECT * FROM SPECTACLE WHERE SPECTACLE_ID=" + spectacle_id + ";" );
            while ( rs.next() ) {
                spectacle = new Spectacle(rs.getInt("SPECTACLE_ID"), rs.getString("NOM"), rs.getString("DESCRIPTION"), selectTheme(rs.getInt("THEME")));
                spectacle.setNumero(spectacle_id);
            }
        
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return spectacle;
    }
    
    
    public LinkedList<Spectacle> selectAllSpectacle(){
        LinkedList<Spectacle> list = new LinkedList<>();
        
        try {
            ResultSet rs = statement.executeQuery( "SELECT * FROM SPECTACLE;" );
            while ( rs.next() ) {
                Spectacle spectacle = new Spectacle(rs.getInt("SPECTACLE_ID"), rs.getString("NOM"), rs.getString("DESCRIPTION"), selectTheme(rs.getInt("THEME")));
                list.push(spectacle);
            }
        
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }
    
    
    public LinkedList<Salle> selectAllSalle(){
        LinkedList<Salle> list = new LinkedList<>();
        
        try {
            ResultSet rs = statement.executeQuery( "SELECT * FROM SALLE;" );
            while ( rs.next() ) {
                Salle salle = new Salle(rs.getString("NOM"));
                list.push(salle);
            }
        
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }
    
    public LinkedList<Theme> selectAllTheme(){
        LinkedList<Theme> list = new LinkedList<>();
        
        try {
            ResultSet rs = statement.executeQuery( "SELECT * FROM THEME;" );
            while ( rs.next() ) {
                Theme theme = new Theme(rs.getString("NOM"));
                theme.setNumero(rs.getInt("THEME_ID"));
                list.push(theme);
            }
        
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }
    
    public LinkedList<Representation> selectRepresentations(Spectacle spectacle){
        LinkedList<Representation> list = new LinkedList<>();
        
        try {
            ResultSet rs = statement.executeQuery( "SELECT * FROM THEME;" );
            while ( rs.next() ) {
                Date date = new Date(   Integer.valueOf(rs.getString("DATE").substring(0, 3)), 
                                        Integer.valueOf(rs.getString("DATE").substring(5, 6)), 
                                        Integer.valueOf(rs.getString("DATE").substring(8, 9))
                );
                Representation representation = new Representation(date, rs.getInt("HEURE"), selectSalle(rs.getInt("SALLE")),selectSpectacle(rs.getInt("SPECTACLE")) );
                representation.setNumero(rs.getInt("THEME_ID"));
                list.push(representation);
            }
        
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }
    
    
}
