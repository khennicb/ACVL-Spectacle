package vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.FlowLayout;

public class ListeSpectacle {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListeSpectacle window = new ListeSpectacle();
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
	public ListeSpectacle() {
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
		
		JPanel panel_home = new JPanel();
		panel_home.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnHome = new JButton("Home");
		panel_home.add(btnHome);
		
		JPanel panel_search = new JPanel();
		panel_search.setLayout(new GridLayout(0, 2, 0, 0));
		
		textField = new JTextField();
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
