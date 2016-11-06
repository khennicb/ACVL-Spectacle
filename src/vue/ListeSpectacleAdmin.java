package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import net.miginfocom.swing.MigLayout;

public class ListeSpectacleAdmin {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListeSpectacleAdmin window = new ListeSpectacleAdmin();
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
	public ListeSpectacleAdmin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 559, 409);
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
		panel_center.add(panel_titre, BorderLayout.NORTH);
		
		JLabel lblSpectaclesVenir = new JLabel("Spectacles \u00E0 venir");
		lblSpectaclesVenir.setFont(new Font("Arial", Font.PLAIN, 16));
		lblSpectaclesVenir.setHorizontalAlignment(SwingConstants.LEFT);
		panel_titre.add(lblSpectaclesVenir);
		
		JPanel panel_content = new JPanel();
		panel_center.add(panel_content, BorderLayout.CENTER);
		panel_content.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_filtre = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_filtre.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_content.add(panel_filtre, BorderLayout.NORTH);
		
		JLabel lblFiltres = new JLabel("Filtre:");
		lblFiltres.setHorizontalAlignment(SwingConstants.LEFT);
		panel_filtre.add(lblFiltres);
		
		JComboBox comboBox_filtres = new JComboBox();
		comboBox_filtres.setModel(new DefaultComboBoxModel(new String[] {"Test", "Test2"}));
		comboBox_filtres.setToolTipText("Test\r\n");
		panel_filtre.add(comboBox_filtres);
		
		JPanel panel_liste = new JPanel();
		panel_content.add(panel_liste, BorderLayout.CENTER);
		panel_liste.setLayout(new MigLayout("", "[][]", "[]"));
		
		JButton btnSpectacle = new JButton("Spectacle_1");
		panel_liste.add(btnSpectacle, "cell 0 0");
		
		JButton btnSpectacle_1 = new JButton("Spectacle_2");
		panel_liste.add(btnSpectacle_1, "cell 1 0");
	}

}
