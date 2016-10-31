package vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.Font;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class ResaSpectacle {

	private JFrame frame;
	private JTextField textField_connexion_login;
	private JPasswordField passwordField_connexion_mdp;
	private JTextField textField_inscription_Nom;
	private JTextField textField_inscription_prenom;
	private JTextField textField_inscription_email;
	private JTextField textField_inscription_login;
	private JPasswordField passwordField_inscription_mdp;
	private JPasswordField passwordField_inscription_confirm_mdp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResaSpectacle window = new ResaSpectacle();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ResaSpectacle() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 680, 566);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel_header = new JPanel();
		frame.getContentPane().add(panel_header, BorderLayout.NORTH);
		
		JLabel lblTitre = new JLabel("ResaSpectacle");
		lblTitre.setFont(new Font("Arial", Font.PLAIN, 24));
		panel_header.add(lblTitre);
		
		JPanel panel_center = new JPanel();
		frame.getContentPane().add(panel_center, BorderLayout.CENTER);
		panel_center.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_connexion = new JPanel();
		panel_center.add(panel_connexion);
		panel_connexion.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_connexion_titre = new JPanel();
		panel_connexion.add(panel_connexion_titre, BorderLayout.NORTH);
		
		JLabel lblConnexion = new JLabel("Connexion");
		lblConnexion.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_connexion_titre.add(lblConnexion);
		
		JPanel panel_connexion_center = new JPanel();
		panel_connexion.add(panel_connexion_center, BorderLayout.CENTER);
		panel_connexion_center.setLayout(new MigLayout("", "[][grow]", "[][][]"));
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_connexion_center.add(lblLogin, "cell 0 0");
		
		textField_connexion_login = new JTextField();
		lblLogin.setLabelFor(textField_connexion_login);
		panel_connexion_center.add(textField_connexion_login, "cell 1 0,growx");
		textField_connexion_login.setColumns(10);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe:");
		lblMotDePasse.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_connexion_center.add(lblMotDePasse, "cell 0 1,aligny center");
		
		passwordField_connexion_mdp = new JPasswordField();
		lblMotDePasse.setLabelFor(passwordField_connexion_mdp);
		panel_connexion_center.add(passwordField_connexion_mdp, "cell 1 1,growx,aligny center");
		
		JButton btnConnexion = new JButton("Valider");
		panel_connexion_center.add(btnConnexion, "cell 1 2");
		
		JPanel panel_inscription = new JPanel();
		panel_center.add(panel_inscription);
		panel_inscription.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_inscription_titre = new JPanel();
		panel_inscription.add(panel_inscription_titre, BorderLayout.NORTH);
		
		JLabel lblNewLabel_1 = new JLabel("Insciption");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_inscription_titre.add(lblNewLabel_1);
		
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
		
		JButton btnInscription = new JButton("Valider");
		panel_inscription_center.add(btnInscription, "cell 1 6");
	}

}
