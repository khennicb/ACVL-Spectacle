package vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JComboBox;

public class PageSpectacleAdmin {

	private JFrame frame;
	private JTextField txtdate;
	private JTextField txtheure;
	private JButton btnNbrReservation;
	private JTextField textField_search;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PageSpectacleAdmin window = new PageSpectacleAdmin();
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
	public PageSpectacleAdmin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 660, 319);
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
		
		textField_search = new JTextField();
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
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_titre = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_titre.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel.add(panel_titre, BorderLayout.NORTH);
		
		JLabel lblNomDuSpectacle = new JLabel("Nom du spectacle");
		lblNomDuSpectacle.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_titre.add(lblNomDuSpectacle);
		
		JPanel panel_content = new JPanel();
		panel.add(panel_content, BorderLayout.CENTER);
		panel_content.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_ajoutRepresentation = new JPanel();
		panel_content.add(panel_ajoutRepresentation, BorderLayout.SOUTH);
		panel_ajoutRepresentation.setLayout(new MigLayout("", "[][][grow]", "[]"));
		
		JLabel lblAjoutDeRepresentation = new JLabel("Ajout de representation:");
		lblAjoutDeRepresentation.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_ajoutRepresentation.add(lblAjoutDeRepresentation, "cell 0 0");
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_ajoutRepresentation.add(lblDate, "cell 1 0,alignx trailing");
		
		txtdate = new JTextField();
		lblDate.setLabelFor(txtdate);
		txtdate.setText("JJ/MM/AA  ");
		panel_ajoutRepresentation.add(txtdate, "flowx,cell 2 0,growx");
		txtdate.setColumns(10);
		
		JLabel lblHeure = new JLabel("Heure:");
		lblHeure.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_ajoutRepresentation.add(lblHeure, "cell 2 0");
		
		txtheure = new JTextField();
		lblHeure.setLabelFor(txtheure);
		txtheure.setText("HH:MM  ");
		panel_ajoutRepresentation.add(txtheure, "cell 2 0");
		txtheure.setColumns(10);
		
		JLabel lblSalle = new JLabel("Salle:");
		panel_ajoutRepresentation.add(lblSalle, "cell 2 0");
		
		JComboBox comboBoxSalle = new JComboBox();
		panel_ajoutRepresentation.add(comboBoxSalle, "cell 2 0");
		
		JButton btnAjout = new JButton("Ajout");
		panel_ajoutRepresentation.add(btnAjout, "cell 2 0");
		
		JPanel panel_ListeRepresentation = new JPanel();
		panel_content.add(panel_ListeRepresentation, BorderLayout.CENTER);
		panel_ListeRepresentation.setLayout(new MigLayout("", "[][][][]", "[][]"));
		
		JLabel lblHorraire = new JLabel("Horraire");
		lblHorraire.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_ListeRepresentation.add(lblHorraire, "cell 0 0");
		
		JLabel lblVentes = new JLabel("Ventes");
		lblVentes.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_ListeRepresentation.add(lblVentes, "cell 1 0");
		
		JLabel lblRservations = new JLabel("R\u00E9servations");
		lblRservations.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_ListeRepresentation.add(lblRservations, "cell 2 0");
		
		JLabel lblDateHeure = new JLabel("Date - heure");
		lblDateHeure.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_ListeRepresentation.add(lblDateHeure, "cell 0 1");
		
		JLabel lblNbreVentes = new JLabel("12");
		panel_ListeRepresentation.add(lblNbreVentes, "cell 1 1");
		
		btnNbrReservation = new JButton("10");
		panel_ListeRepresentation.add(btnNbrReservation, "cell 2 1");
		
		JButton btnAnnuler = new JButton("Annuler");
		panel_ListeRepresentation.add(btnAnnuler, "cell 3 1,aligny baseline");
	}

}
