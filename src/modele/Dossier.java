package modele;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class Dossier {
    private int numero;
    private float montant;
    private Date date_achat;
    private Client client;
    private List<Billet> billets;

    public Dossier(int numero, float montant, Date date_achat, Client client) {
        this.numero = numero;
        this.montant = montant;
        this.date_achat = date_achat;
        this.client = client;
        this.billets = new ArrayList<Billet>();
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public float getMontant() {
        return montant;
    }

    public Date getDate_achat() {
        return date_achat;
    }

    public Client getClient() {
        return client;
    }

    public List<Billet> getAllBillets() {
        return billets;
    }    
}
