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

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.DropMode;
import javax.swing.JScrollBar;

import net.miginfocom.swing.MigLayout;

import java.awt.ScrollPane;

public class PageSpectacleClient {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PageSpectacleClient window = new PageSpectacleClient();
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
	public PageSpectacleClient() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 560, 400);
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
		
		JLabel lblTitreSpectacle = new JLabel("Spectacle des oisillons chantant");
		lblTitreSpectacle.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_titre.add(lblTitreSpectacle);
		
		JPanel panel_content = new JPanel();
		panel_center.add(panel_content, BorderLayout.CENTER);
		GridBagLayout gbl_panel_content = new GridBagLayout();
		gbl_panel_content.columnWidths = new int[]{0, 0};
		gbl_panel_content.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_content.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_content.rowWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		panel_content.setLayout(gbl_panel_content);
		
		JPanel panel_theme = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_theme.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panel_theme = new GridBagConstraints();
		gbc_panel_theme.fill = GridBagConstraints.BOTH;
		gbc_panel_theme.gridx = 0;
		gbc_panel_theme.gridy = 0;
		panel_content.add(panel_theme, gbc_panel_theme);
		
		JLabel lblThme = new JLabel("Th\u00E8me:");
		panel_theme.add(lblThme);
		
		JLabel lblDrame = new JLabel("Drame");
		panel_theme.add(lblDrame);
		
		JPanel panel_description = new JPanel();
		GridBagConstraints gbc_panel_description = new GridBagConstraints();
		gbc_panel_description.insets = new Insets(0, 0, 5, 0);
		gbc_panel_description.fill = GridBagConstraints.BOTH;
		gbc_panel_description.gridx = 0;
		gbc_panel_description.gridy = 1;
		panel_content.add(panel_description, gbc_panel_description);
		panel_description.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_description_titre = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_description_titre.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		panel_description.add(panel_description_titre, BorderLayout.NORTH);
		
		JLabel lblDescription = new JLabel("Description:");
		panel_description_titre.add(lblDescription);
		
		JPanel panel_description_content = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_description_content.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel_description.add(panel_description_content, BorderLayout.CENTER);
		
		JTextPane txtpnl_description = new JTextPane();
		txtpnl_description.setBackground(UIManager.getColor("menu"));
		txtpnl_description.setText("Lanc\u00E9s dans l'ouest sauvage, deux amis se retrouvent plong\u00E9s en plein cauchemar quand l'un des andro\u00EFdes se d\u00E9traque et les prend en chasse...\r\nUn parc d'attractions peupl\u00E9 de robots propose aux visiteurs de se replonger dans plusieurs \u00E9poques. \r\n");
		panel_description_content.add(txtpnl_description);
		
		
		JPanel panel_listeRepresentation = new JPanel();
		GridBagConstraints gbc_panel_listeRepresentation = new GridBagConstraints();
		gbc_panel_listeRepresentation.gridheight = 2;
		gbc_panel_listeRepresentation.insets = new Insets(0, 0, 5, 0);
		gbc_panel_listeRepresentation.fill = GridBagConstraints.BOTH;
		gbc_panel_listeRepresentation.gridx = 0;
		gbc_panel_listeRepresentation.gridy = 2;
		panel_content.add(panel_listeRepresentation, gbc_panel_listeRepresentation);
		GridBagLayout gbl_panel_listeRepresentation = new GridBagLayout();
		gbl_panel_listeRepresentation.columnWidths = new int[]{0, 0};
		gbl_panel_listeRepresentation.rowHeights = new int[]{0, 0, 0};
		gbl_panel_listeRepresentation.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_listeRepresentation.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		panel_listeRepresentation.setLayout(gbl_panel_listeRepresentation);
		
		JPanel panel_representation_1 = new JPanel();
		GridBagConstraints gbc_panel_representation_1 = new GridBagConstraints();
		gbc_panel_representation_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_representation_1.fill = GridBagConstraints.BOTH;
		gbc_panel_representation_1.gridx = 0;
		gbc_panel_representation_1.gridy = 0;
		panel_listeRepresentation.add(panel_representation_1, gbc_panel_representation_1);
		panel_representation_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblDateHeure = new JLabel("10/01/2016 - 20H");
		panel_representation_1.add(lblDateHeure);
		
		JButton btnAcheter = new JButton("Acheter");
		panel_representation_1.add(btnAcheter);
		
		JButton btnRserver = new JButton("R\u00E9server");
		panel_representation_1.add(btnRserver);
		
		JPanel panel_representation_2 = new JPanel();
		GridBagConstraints gbc_panel_representation_2 = new GridBagConstraints();
		gbc_panel_representation_2.fill = GridBagConstraints.BOTH;
		gbc_panel_representation_2.gridx = 0;
		gbc_panel_representation_2.gridy = 1;
		panel_listeRepresentation.add(panel_representation_2, gbc_panel_representation_2);
		panel_representation_2.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblDateheure = new JLabel("10/01/2016 - 22H");
		panel_representation_2.add(lblDateheure);
		
		JButton btnAcheter_1 = new JButton("Acheter");
		panel_representation_2.add(btnAcheter_1);
		
		JButton btnRserver_1 = new JButton("R\u00E9server");
		panel_representation_2.add(btnRserver_1);
		
		
	}

}
