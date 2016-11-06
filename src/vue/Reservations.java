package vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;

public class Reservations {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reservations window = new Reservations();
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
	public Reservations() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 209);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel_header = new JPanel();
		frame.getContentPane().add(panel_header, BorderLayout.NORTH);
		panel_header.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_home = new JPanel();
		panel_header.add(panel_home);
		panel_home.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnHome = new JButton("Home");
		panel_home.add(btnHome);
		
		JPanel panel_search = new JPanel();
		panel_header.add(panel_search);
		panel_search.setLayout(new GridLayout(1, 0, 0, 0));
		
		JTextField textField_search = new JTextField();
		panel_search.add(textField_search);
		textField_search.setColumns(10);
		
		JButton btnOk = new JButton("Ok");
		panel_search.add(btnOk);
		
		JPanel panel_admin = new JPanel();
		panel_header.add(panel_admin);
		panel_admin.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnAjoutSpectacle = new JButton("Ajout spectacle");
		panel_admin.add(btnAjoutSpectacle);
		
		JPanel panel_Deconnexion = new JPanel();
		panel_header.add(panel_Deconnexion);
		panel_Deconnexion.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnDeconnexion = new JButton("D\u00E9connexion");
		panel_Deconnexion.add(btnDeconnexion);
		
		JPanel panel_center = new JPanel();
		frame.getContentPane().add(panel_center, BorderLayout.CENTER);
		panel_center.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_titre = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_titre.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_center.add(panel_titre, BorderLayout.NORTH);
		
		JLabel lblRservationsPourNomspectacle = new JLabel("R\u00E9servations pour nom_spectacle");
		lblRservationsPourNomspectacle.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_titre.add(lblRservationsPourNomspectacle);
		
		JPanel panel_content = new JPanel();
		panel_center.add(panel_content, BorderLayout.CENTER);
		panel_content.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_horraire = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_horraire.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel_content.add(panel_horraire, BorderLayout.NORTH);
		
		JLabel lblDateHeure = new JLabel("Date - heure");
		panel_horraire.add(lblDateHeure);
		
		JPanel panel_Reservations = new JPanel();
		panel_content.add(panel_Reservations, BorderLayout.CENTER);
		panel_Reservations.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_Reservations_filtre = new JPanel();
		panel_Reservations.add(panel_Reservations_filtre, BorderLayout.NORTH);
		panel_Reservations_filtre.setLayout(new MigLayout("", "[grow][grow][grow][grow]", "[grow]"));
		
		JPanel panel_search_2 = new JPanel();
		panel_Reservations_filtre.add(panel_search_2, "cell 0 0,grow");
		panel_search_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		textField = new JTextField();
		panel_search_2.add(textField);
		textField.setColumns(10);
		
		JPanel panel_search_2_validation = new JPanel();
		panel_Reservations_filtre.add(panel_search_2_validation, "cell 1 0,grow");
		panel_search_2_validation.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnOk_2 = new JButton("Ok");
		panel_search_2_validation.add(btnOk_2);
		
		JPanel panel_ToutSelectionner = new JPanel();
		panel_Reservations_filtre.add(panel_ToutSelectionner, "cell 2 0,grow");
		panel_ToutSelectionner.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnToutSlectionner = new JButton("Tout s\u00E9lectionner");
		panel_ToutSelectionner.add(btnToutSlectionner);
		
		JPanel panel_AnnulerReservation = new JPanel();
		panel_Reservations_filtre.add(panel_AnnulerReservation, "cell 3 0,grow");
		panel_AnnulerReservation.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnAnnulerRservation = new JButton("Annuler R\u00E9servation");
		panel_AnnulerReservation.add(btnAnnulerRservation);
		
		JPanel panel_Reservations_liste = new JPanel();
		panel_Reservations.add(panel_Reservations_liste, BorderLayout.CENTER);
		panel_Reservations_liste.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_Reservations_elmt_1 = new JPanel();
		panel_Reservations_liste.add(panel_Reservations_elmt_1);
		panel_Reservations_elmt_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblNumClient = new JLabel("NumClient");
		panel_Reservations_elmt_1.add(lblNumClient);
		
		JLabel lblNomClient = new JLabel("Nom");
		panel_Reservations_elmt_1.add(lblNomClient);
		
		JLabel lblPrenomClient = new JLabel("Prenom");
		panel_Reservations_elmt_1.add(lblPrenomClient);
		
		JLabel lblEmailclientcom = new JLabel("email@client.com");
		panel_Reservations_elmt_1.add(lblEmailclientcom);
		
		JCheckBox checkBox_NumClient = new JCheckBox("");
		panel_Reservations_elmt_1.add(checkBox_NumClient);
		
		JPanel panel_Reservations_elmt_2 = new JPanel();
		panel_Reservations_liste.add(panel_Reservations_elmt_2);
		panel_Reservations_elmt_2.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblNumclient = new JLabel("NumClient");
		panel_Reservations_elmt_2.add(lblNumclient);
		
		JLabel lblNomClient_2 = new JLabel("Nom");
		panel_Reservations_elmt_2.add(lblNomClient_2);
		
		JLabel lblPrnom = new JLabel("Pr\u00E9nom");
		panel_Reservations_elmt_2.add(lblPrnom);
		
		JLabel lblEmailclientfr = new JLabel("email@client.fr");
		panel_Reservations_elmt_2.add(lblEmailclientfr);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		panel_Reservations_elmt_2.add(chckbxNewCheckBox);
	}

}
