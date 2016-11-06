package vue.Center;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import net.miginfocom.swing.MigLayout;

public class PanelCenterConnexion extends PanelCenter {
	private JTextField textField_connexion_login;
	private JPasswordField passwordField_connexion_mdp;
	private JTextField textField_inscription_Nom;
	private JTextField textField_inscription_prenom;
	private JTextField textField_inscription_email;
	private JTextField textField_inscription_login;
	private JPasswordField passwordField_inscription_mdp;
	private JPasswordField passwordField_inscription_confirm_mdp;
	private JButton btnConnexion;
	private JButton btnInscription;
	
	private JLabel lblWarningConnexion;
	private JLabel lblWarningInscription;
	
	public PanelCenterConnexion() {		
		this.panel.setLayout(new GridLayout(1, 0, 0, 0));
		JPanel panel_connexion = new JPanel();
		this.panel.add(panel_connexion);
		panel_connexion.setLayout(new BorderLayout(0, 0));
		
		
		JPanel panel_connexion_titre = new JPanel();
		panel_connexion.add(panel_connexion_titre, BorderLayout.NORTH);
		panel_connexion_titre.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblConnexion = new JLabel("Connexion");
		lblConnexion.setHorizontalAlignment(SwingConstants.CENTER);
		lblConnexion.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_connexion_titre.add(lblConnexion);
		
		lblWarningConnexion = new JLabel("");
		lblWarningConnexion.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_connexion_titre.add(lblWarningConnexion);
		
		JPanel panel_connexion_center = new JPanel();
		panel_connexion.add(panel_connexion_center, BorderLayout.CENTER);
		panel_connexion_center.setLayout(new MigLayout("", "[][grow]", "[][][]"));
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_connexion_center.add(lblLogin, "cell 0 1");
		
		textField_connexion_login = new JTextField();
		lblLogin.setLabelFor(textField_connexion_login);
		panel_connexion_center.add(textField_connexion_login, "cell 1 1,growx");
		textField_connexion_login.setColumns(10);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe:");
		lblMotDePasse.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_connexion_center.add(lblMotDePasse, "cell 0 2,aligny center");
		
		passwordField_connexion_mdp = new JPasswordField();
		lblMotDePasse.setLabelFor(passwordField_connexion_mdp);
		panel_connexion_center.add(passwordField_connexion_mdp, "cell 1 2,growx,aligny center");
		
		btnConnexion = new JButton("Valider");
		panel_connexion_center.add(btnConnexion, "cell 1 3");
		
		JPanel panel_inscription = new JPanel();
		this.panel.add(panel_inscription);
		panel_inscription.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_inscription_titre = new JPanel();
		panel_inscription.add(panel_inscription_titre, BorderLayout.NORTH);
		panel_inscription_titre.setLayout(new GridLayout(2, 1, 0, 0));
		
		JLabel lblInscription = new JLabel("Insciption");
		lblInscription.setHorizontalAlignment(SwingConstants.CENTER);
		lblInscription.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_inscription_titre.add(lblInscription);
		
		lblWarningInscription = new JLabel("");
		panel_inscription_titre.add(lblWarningInscription);
		
		JPanel panel_inscription_center = new JPanel();
		panel_inscription.add(panel_inscription_center, BorderLayout.CENTER);
		panel_inscription_center.setLayout(new MigLayout("", "[][grow]", "[][][][][][][]"));
		
		JLabel lblNom = new JLabel("Nom:");
		lblNom.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_inscription_center.add(lblNom, "cell 0 0,alignx trailing");
		
		textField_inscription_Nom = new JTextField();
		lblNom.setLabelFor(textField_inscription_Nom);
		panel_inscription_center.add(textField_inscription_Nom, "cell 1 0,growx");
		textField_inscription_Nom.setColumns(10);
		
		JLabel lblPrnom = new JLabel("Pr\u00E9nom:");
		lblPrnom.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_inscription_center.add(lblPrnom, "cell 0 1,alignx trailing");
		
		textField_inscription_prenom = new JTextField();
		lblPrnom.setLabelFor(textField_inscription_prenom);
		panel_inscription_center.add(textField_inscription_prenom, "cell 1 1,growx");
		textField_inscription_prenom.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_inscription_center.add(lblEmail, "cell 0 2,alignx trailing");
		
		textField_inscription_email = new JTextField();
		lblEmail.setLabelFor(textField_inscription_email);
		panel_inscription_center.add(textField_inscription_email, "cell 1 2,growx");
		textField_inscription_email.setColumns(10);
		
		JLabel lblLogin_1 = new JLabel("Login:");
		lblLogin_1.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_inscription_center.add(lblLogin_1, "cell 0 3,alignx trailing");
		
		textField_inscription_login = new JTextField();
		lblLogin_1.setLabelFor(textField_inscription_login);
		panel_inscription_center.add(textField_inscription_login, "cell 1 3,growx");
		textField_inscription_login.setColumns(10);
		
		JLabel lblMotDePasse_1 = new JLabel("Mot de passe:");
		lblMotDePasse_1.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_inscription_center.add(lblMotDePasse_1, "cell 0 4,alignx trailing");
		
		passwordField_inscription_mdp = new JPasswordField();
		lblMotDePasse_1.setLabelFor(passwordField_inscription_mdp);
		panel_inscription_center.add(passwordField_inscription_mdp, "cell 1 4,growx");
		
		JLabel lblConfirmationMotDe = new JLabel("Confirmation mot de passe");
		lblConfirmationMotDe.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_inscription_center.add(lblConfirmationMotDe, "cell 0 5,alignx trailing");
		
		passwordField_inscription_confirm_mdp = new JPasswordField();
		lblConfirmationMotDe.setLabelFor(passwordField_inscription_confirm_mdp);
		panel_inscription_center.add(passwordField_inscription_confirm_mdp, "cell 1 5,growx");
		
		btnInscription = new JButton("Valider");
		panel_inscription_center.add(btnInscription, "cell 1 6");
	}

	public JTextField getTextField_connexion_login() {
		return textField_connexion_login;
	}

	public JPasswordField getPasswordField_connexion_mdp() {
		return passwordField_connexion_mdp;
	}

	public JTextField getTextField_inscription_Nom() {
		return textField_inscription_Nom;
	}

	public JTextField getTextField_inscription_prenom() {
		return textField_inscription_prenom;
	}

	public JTextField getTextField_inscription_email() {
		return textField_inscription_email;
	}

	public JTextField getTextField_inscription_login() {
		return textField_inscription_login;
	}

	public JPasswordField getPasswordField_inscription_mdp() {
		return passwordField_inscription_mdp;
	}

	public JPasswordField getPasswordField_inscription_confirm_mdp() {
		return passwordField_inscription_confirm_mdp;
	}

	public JButton getBtnConnexion() {
		return btnConnexion;
	}

	public JButton getBtnInscription() {
		return btnInscription;
	}
	
	public void setWarningConnexion(String msg){
		this.lblWarningConnexion.setText(msg);
		this.lblWarningInscription.setText("");
	}
	
	public void setWarningInscription(String msg) {
		this.lblWarningInscription.setText(msg);
		this.lblWarningConnexion.setText("");
	}
}
