package modele;

public abstract class Utilisateur {

    protected int numero;
    protected String login;
    protected String password;

    public Utilisateur(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }


    public int getNumero() {
        return numero;
    }
    
    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
    
    

}
