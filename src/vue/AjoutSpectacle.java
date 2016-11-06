package vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.FlowLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

public class AjoutSpectacle {

	private JFrame frame;
	private JTextField textField;
	private JTextField txtDate;
	private JTextField txtHeure;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjoutSpectacle window = new AjoutSpectacle();
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
	public AjoutSpectacle() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 259);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
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
		
		JLabel lblAjoutDunSpectacle = new JLabel("Ajout d'un spectacle");
		lblAjoutDunSpectacle.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_titre.add(lblAjoutDunSpectacle);
		
		JPanel panel_content = new JPanel();
		panel_center.add(panel_content, BorderLayout.CENTER);
		panel_content.setLayout(new MigLayout("", "[][grow]", "[][][grow][grow][grow]"));
		
		JLabel lblNomDuSpectacle = new JLabel("Nom du spectacle:");
		lblNomDuSpectacle.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_content.add(lblNomDuSpectacle, "cell 0 0,alignx trailing");
		
		textField = new JTextField();
		panel_content.add(textField, "cell 1 0,growx");
		textField.setColumns(10);
		
		JLabel lblThme = new JLabel("Th\u00E8me:");
		lblThme.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_content.add(lblThme, "cell 0 1,alignx trailing");
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Danse", "bfhizeh"}));
		panel_content.add(comboBox, "flowx,cell 1 1,growx");
		
		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_content.add(lblDescription, "cell 0 2,alignx right");
		
		JTextArea textArea = new JTextArea();
		panel_content.add(textArea, "cell 1 2,grow");
		
		JPanel panel_representation = new JPanel();
		panel_content.add(panel_representation, "cell 1 3,grow");
		panel_representation.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblDate_1 = new JLabel("Date: ");
		panel_representation.add(lblDate_1);
		
		JLabel lblJjmmaa = new JLabel("JJ/MM/AA");
		panel_representation.add(lblJjmmaa);
		
		JLabel lblHeure_1 = new JLabel("Heure:");
		panel_representation.add(lblHeure_1);
		
		JLabel lblHh = new JLabel("HH");
		panel_representation.add(lblHh);
		
		JLabel lblSalle = new JLabel("Salle:");
		panel_representation.add(lblSalle);
		
		JLabel label = new JLabel("10");
		panel_representation.add(label);
		
		JLabel lblAjoutReprsentation = new JLabel("Ajout repr\u00E9sentation :");
		lblAjoutReprsentation.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_content.add(lblAjoutReprsentation, "cell 0 4");
		
		JPanel panel_ajoutRepresentation = new JPanel();
		panel_content.add(panel_ajoutRepresentation, "cell 1 4,grow");
		panel_ajoutRepresentation.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblDate = new JLabel("Date:");
		panel_ajoutRepresentation.add(lblDate);
		
		txtDate = new JTextField();
		txtDate.setText("JJ/MM/AA");
		panel_ajoutRepresentation.add(txtDate);
		txtDate.setColumns(10);
		
		JLabel lblHeure = new JLabel("Heure:");
		panel_ajoutRepresentation.add(lblHeure);
		
		txtHeure = new JTextField();
		txtHeure.setText("HH");
		panel_ajoutRepresentation.add(txtHeure);
		txtHeure.setColumns(10);
		
		JLabel lblSalle_1 = new JLabel("Salle:");
		panel_ajoutRepresentation.add(lblSalle_1);
		
		JComboBox comboBox_Salle = new JComboBox();
		panel_ajoutRepresentation.add(comboBox_Salle);
		
		JButton btnAjoutRepresentation = new JButton("+");
		panel_ajoutRepresentation.add(btnAjoutRepresentation);
		
		JButton btnAddTheme = new JButton("+");
		panel_content.add(btnAddTheme, "cell 1 1");
		
		JPanel panel_footer = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_footer.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		panel_center.add(panel_footer, BorderLayout.SOUTH);
		
		JButton btnValider = new JButton("Valider");
		panel_footer.add(btnValider);
	}

}
