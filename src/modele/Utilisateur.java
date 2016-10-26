package modele;

public abstract class Utilisateur {

    protected String login;
    protected String password;

    public Utilisateur(String login, String password) {
        this.login = login;
        this.password = password;
    }

}
