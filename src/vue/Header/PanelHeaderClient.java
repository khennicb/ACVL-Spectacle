package vue.Header;

import javax.swing.JButton;

public class PanelHeaderClient extends PanelHeaderUser{
	private JButton btnCompte;
	private JButton btnVosCommande;
	
	public PanelHeaderClient() {
		btnCompte = new JButton("Compte");
		panel_user.add(btnCompte);
		btnVosCommande = new JButton("Vos commande");
		panel_user.add(btnVosCommande);
	}
}
