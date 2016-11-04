package vue.Center;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class PanelCenterCompte extends PanelCenter {
	private JPasswordField passwordField_OldMdp;
	private JPasswordField passwordField_newMdp;
	private JPasswordField passwordField_ConfMdp;
	private JTextField txtNom;
	private JTextField txtPrenom;
	private JTextField txtEmail;
	private JButton btnValiderMdp;
	private JButton btnValiderModifications;
	
	
	public PanelCenterCompte(String nom, String prenom, String email){
		this.init();
		
		JLabel lblVotreCompte = new JLabel("Votre compte");
		lblVotreCompte.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_titre.add(lblVotreCompte);
		
		JPanel panel_modif_compte = new JPanel();
		panel_content.add(panel_modif_compte);
		panel_modif_compte.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_modif_compte_titre = new JPanel();
		panel_modif_compte.add(panel_modif_compte_titre, BorderLayout.NORTH);
		
		JLabel lblModificationDuCompte = new JLabel("Modification du compte");
		lblModificationDuCompte.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_modif_compte_titre.add(lblModificationDuCompte);
		
		JPanel panel_modif_compte_content = new JPanel();
		panel_modif_compte.add(panel_modif_compte_content, BorderLayout.CENTER);
		panel_modif_compte_content.setLayout(new MigLayout("", "[][grow]", "[][][][]"));
		
		JLabel lblNom = new JLabel("Nom:");
		panel_modif_compte_content.add(lblNom, "cell 0 0,alignx trailing");
		
		txtNom = new JTextField();
		txtNom.setText("nom");
		lblNom.setLabelFor(txtNom);
		panel_modif_compte_content.add(txtNom, "cell 1 0,growx");
		txtNom.setColumns(10);
		
		JLabel lblPrnom = new JLabel("Pr\u00E9nom:");
		panel_modif_compte_content.add(lblPrnom, "cell 0 1,alignx trailing");
		
		txtPrenom = new JTextField();
		txtPrenom.setText("prenom");
		lblPrnom.setLabelFor(txtPrenom);
		panel_modif_compte_content.add(txtPrenom, "cell 1 1,growx");
		txtPrenom.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail:");
		panel_modif_compte_content.add(lblEmail, "cell 0 2,alignx trailing");
		
		txtEmail = new JTextField();
		txtEmail.setText("email");
		lblEmail.setLabelFor(txtEmail);
		panel_modif_compte_content.add(txtEmail, "cell 1 2,growx");
		txtEmail.setColumns(10);
		
		btnValiderModifications = new JButton("Valider modifications");
		panel_modif_compte_content.add(btnValiderModifications, "cell 1 3");
		
		JPanel panel_modif_mdp = new JPanel();
		panel_content.add(panel_modif_mdp);
		panel_modif_mdp.setLayout(new BorderLayout(0, 0));
		
		
		JPanel panel_modif_mdp_titre = new JPanel();
		panel_modif_mdp.add(panel_modif_mdp_titre, BorderLayout.NORTH);
		
		JLabel lblModifMdpTitre = new JLabel("Modification du mot de passe");
		lblModifMdpTitre.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_modif_mdp_titre.add(lblModifMdpTitre);
		
		JPanel panel_modif_mdp_content = new JPanel();
		panel_modif_mdp.add(panel_modif_mdp_content, BorderLayout.CENTER);
		panel_modif_mdp_content.setLayout(new MigLayout("", "[][grow]", "[][][][]"));
		
		JLabel lblOldMdp = new JLabel("Ancien mot de passe:");
		lblOldMdp.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_modif_mdp_content.add(lblOldMdp, "cell 0 0,alignx trailing");
		
		passwordField_OldMdp = new JPasswordField();
		lblOldMdp.setLabelFor(passwordField_OldMdp);
		panel_modif_mdp_content.add(passwordField_OldMdp, "cell 1 0,growx");
		
		JLabel lblNewMdp = new JLabel("Nouveau mot de pass:");
		lblNewMdp.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_modif_mdp_content.add(lblNewMdp, "cell 0 1,alignx trailing");
		
		passwordField_newMdp = new JPasswordField();
		lblNewMdp.setLabelFor(passwordField_newMdp);
		panel_modif_mdp_content.add(passwordField_newMdp, "cell 1 1,growx");
		
		JLabel lblConfMdp = new JLabel("Confirmation mot de passe:");
		lblConfMdp.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_modif_mdp_content.add(lblConfMdp, "cell 0 2,alignx trailing");
		
		passwordField_ConfMdp = new JPasswordField();
		lblConfMdp.setLabelFor(passwordField_ConfMdp);
		panel_modif_mdp_content.add(passwordField_ConfMdp, "cell 1 2,growx");
		
		btnValiderMdp = new JButton("Modifier mot de passe");
	
		panel_modif_mdp_content.add(btnValiderMdp, "cell 1 3");
	}
}
