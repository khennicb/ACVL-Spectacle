package vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Compte {

	private JFrame frame;
	private JPasswordField passwordField_OldMdp;
	private JPasswordField passwordField_newMdp;
	private JPasswordField passwordField_ConfMdp;
	private JTextField textField_modif_nom;
	private JTextField textField_modif_prenom;
	private JTextField textField_modif_email;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Compte window = new Compte();
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
	public Compte() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 354);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel_header = new JPanel();
		frame.getContentPane().add(panel_header, BorderLayout.NORTH);
		
		JPanel panel_home = new JPanel();
		panel_home.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnHome = new JButton("Home");
		panel_home.add(btnHome);
		
		JPanel panel_search = new JPanel();
		panel_search.setLayout(new GridLayout(0, 2, 0, 0));
		
		JTextField textField = new JTextField();
		panel_search.add(textField);
		textField.setColumns(10);
		
		JButton btnOk = new JButton("Ok");
		panel_search.add(btnOk);
		
		JPanel panel_client = new JPanel();
		panel_client.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnCompte = new JButton("Compte");
		panel_client.add(btnCompte);
		
		JButton btnVosCommande = new JButton("Vos commande");
		panel_client.add(btnVosCommande);
		panel_header.setLayout(new MigLayout("", "[59px][147px][206px][grow]", "[23px,grow]"));
		panel_header.add(panel_home, "cell 0 0,alignx left,aligny top");
		panel_header.add(panel_search, "cell 1 0,growx,aligny top");
		panel_header.add(panel_client, "cell 2 0,alignx left,aligny top");
		
		JPanel panel_deconnexion = new JPanel();
		panel_header.add(panel_deconnexion, "cell 3 0,grow");
		panel_deconnexion.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnDconnexion = new JButton("D\u00E9connexion");
		panel_deconnexion.add(btnDconnexion);
		
		JPanel panel_center = new JPanel();
		frame.getContentPane().add(panel_center, BorderLayout.CENTER);
		panel_center.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_titre = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_titre.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_center.add(panel_titre, BorderLayout.NORTH);
		
		JLabel lblVotreCompte = new JLabel("Votre compte");
		lblVotreCompte.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_titre.add(lblVotreCompte);
		
		JPanel panel_content = new JPanel();
		panel_center.add(panel_content, BorderLayout.CENTER);
		panel_content.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_modif_compte = new JPanel();
		panel_content.add(panel_modif_compte);
		panel_modif_compte.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_modif_compte_titre = new JPanel();
		panel_modif_compte.add(panel_modif_compte_titre, BorderLayout.NORTH);
		
		JLabel lblModificationDuCompte = new JLabel("Modification du compte");
		lblModificationDuCompte.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_modif_compte_titre.add(lblModificationDuCompte);
		
		JPanel panel_1 = new JPanel();
		panel_modif_compte.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new MigLayout("", "[][grow]", "[][][][]"));
		
		JLabel lblNom = new JLabel("Nom:");
		panel_1.add(lblNom, "cell 0 0,alignx trailing");
		
		textField_modif_nom = new JTextField();
		lblNom.setLabelFor(textField_modif_nom);
		panel_1.add(textField_modif_nom, "cell 1 0,growx");
		textField_modif_nom.setColumns(10);
		
		JLabel lblPrnom = new JLabel("Pr\u00E9nom:");
		panel_1.add(lblPrnom, "cell 0 1,alignx trailing");
		
		textField_modif_prenom = new JTextField();
		lblPrnom.setLabelFor(textField_modif_prenom);
		panel_1.add(textField_modif_prenom, "cell 1 1,growx");
		textField_modif_prenom.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail:");
		panel_1.add(lblEmail, "cell 0 2,alignx trailing");
		
		textField_modif_email = new JTextField();
		lblEmail.setLabelFor(textField_modif_email);
		panel_1.add(textField_modif_email, "cell 1 2,growx");
		textField_modif_email.setColumns(10);
		
		JButton btnValiderModifications = new JButton("Valider modifications");
		panel_1.add(btnValiderModifications, "cell 1 3");
		
		JPanel panel_modif_mdp = new JPanel();
		panel_content.add(panel_modif_mdp);
		panel_modif_mdp.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_modif_mdp_titre = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_modif_mdp_titre.getLayout();
		panel_modif_mdp.add(panel_modif_mdp_titre, BorderLayout.NORTH);
		
		JLabel lblModifMdpTitre = new JLabel("Modification du mot de passe");
		lblModifMdpTitre.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_modif_mdp_titre.add(lblModifMdpTitre);
		
		JPanel panel = new JPanel();
		panel_modif_mdp.add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[][grow]", "[][][][]"));
		
		JLabel lblOldMdp = new JLabel("Ancien mot de passe:");
		lblOldMdp.setFont(new Font("Arial", Font.PLAIN, 12));
		panel.add(lblOldMdp, "cell 0 0,alignx trailing");
		
		passwordField_OldMdp = new JPasswordField();
		lblOldMdp.setLabelFor(passwordField_OldMdp);
		panel.add(passwordField_OldMdp, "cell 1 0,growx");
		
		JLabel lblNewMdp = new JLabel("Nouveau mot de pass:");
		lblNewMdp.setFont(new Font("Arial", Font.PLAIN, 12));
		panel.add(lblNewMdp, "cell 0 1,alignx trailing");
		
		passwordField_newMdp = new JPasswordField();
		lblNewMdp.setLabelFor(passwordField_newMdp);
		panel.add(passwordField_newMdp, "cell 1 1,growx");
		
		JLabel lblConfMdp = new JLabel("Confirmation mot de passe:");
		lblConfMdp.setFont(new Font("Arial", Font.PLAIN, 12));
		panel.add(lblConfMdp, "cell 0 2,alignx trailing");
		
		passwordField_ConfMdp = new JPasswordField();
		lblConfMdp.setLabelFor(passwordField_ConfMdp);
		panel.add(passwordField_ConfMdp, "cell 1 2,growx");
		
		JButton btnValiderMdp = new JButton("Modifier mot de passe");
		btnValiderMdp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(btnValiderMdp, "cell 1 3");
	}

}
