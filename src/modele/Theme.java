package modele;

public class Theme {
    private int numero;
    private String nom;

    public Theme(String nom) {
        this.nom = nom;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }
    
    public String getNom() {
        return nom;
    }
}