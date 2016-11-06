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
import javax.swing.JButton;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Commande {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Commande window = new Commande();
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
	public Commande() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 300);
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
		
		JLabel lblVosCommandes = new JLabel("Vos Commandes");
		lblVosCommandes.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_titre.add(lblVosCommandes);
		
		JPanel panel_content = new JPanel();
		panel_center.add(panel_content, BorderLayout.CENTER);
		GridBagLayout gbl_panel_content = new GridBagLayout();
		gbl_panel_content.columnWidths = new int[]{0, 0};
		gbl_panel_content.rowHeights = new int[]{0, 0, 0};
		gbl_panel_content.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_content.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		panel_content.setLayout(gbl_panel_content);
		
		JPanel panel_reservation = new JPanel();
		GridBagConstraints gbc_panel_reservation = new GridBagConstraints();
		gbc_panel_reservation.insets = new Insets(0, 0, 5, 0);
		gbc_panel_reservation.fill = GridBagConstraints.BOTH;
		gbc_panel_reservation.gridx = 0;
		gbc_panel_reservation.gridy = 0;
		panel_content.add(panel_reservation, gbc_panel_reservation);
		panel_reservation.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_reservation_titre = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_reservation_titre.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel_reservation.add(panel_reservation_titre, BorderLayout.NORTH);
		
		JLabel lblRservations = new JLabel("R\u00E9servations");
		lblRservations.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_reservation_titre.add(lblRservations);
		
		JPanel panel_listeResa = new JPanel();
		panel_reservation.add(panel_listeResa, BorderLayout.CENTER);
		GridBagLayout gbl_panel_listeResa = new GridBagLayout();
		gbl_panel_listeResa.columnWidths = new int[]{0, 0};
		gbl_panel_listeResa.rowHeights = new int[]{0, 0, 0};
		gbl_panel_listeResa.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_listeResa.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		panel_listeResa.setLayout(gbl_panel_listeResa);
		
		JPanel panel_Reservation_1 = new JPanel();
		GridBagConstraints gbc_panel_Reservation_1 = new GridBagConstraints();
		gbc_panel_Reservation_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_Reservation_1.fill = GridBagConstraints.BOTH;
		gbc_panel_Reservation_1.gridx = 0;
		gbc_panel_Reservation_1.gridy = 0;
		panel_listeResa.add(panel_Reservation_1, gbc_panel_Reservation_1);
		panel_Reservation_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnSpectacle = new JButton("Spectacle_1");
		panel_Reservation_1.add(btnSpectacle);
		
		JLabel lblDateHeure = new JLabel("Date - Heure");
		panel_Reservation_1.add(lblDateHeure);
		
		JButton btnConfirmation = new JButton("Confirmation");
		panel_Reservation_1.add(btnConfirmation);
		
		JButton btnAnnulation = new JButton("Annulation");
		panel_Reservation_1.add(btnAnnulation);
		
		JPanel panel_Reservation_2 = new JPanel();
		GridBagConstraints gbc_panel_Reservation_2 = new GridBagConstraints();
		gbc_panel_Reservation_2.fill = GridBagConstraints.BOTH;
		gbc_panel_Reservation_2.gridx = 0;
		gbc_panel_Reservation_2.gridy = 1;
		panel_listeResa.add(panel_Reservation_2, gbc_panel_Reservation_2);
		
		JButton btnSpectacle_2 = new JButton("Spectacle_2");
		btnSpectacle_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel_Reservation_2.setLayout(new GridLayout(0, 4, 0, 0));
		panel_Reservation_2.add(btnSpectacle_2);
		
		JLabel lblDatehaure = new JLabel("Date-Heure");
		panel_Reservation_2.add(lblDatehaure);
		
		JButton btnConfirmation_1 = new JButton("Confirmation");
		panel_Reservation_2.add(btnConfirmation_1);
		
		JButton btnAnnulation_1 = new JButton("Annulation");
		panel_Reservation_2.add(btnAnnulation_1);
		
		JPanel panel_achat = new JPanel();
		GridBagConstraints gbc_panel_achat = new GridBagConstraints();
		gbc_panel_achat.fill = GridBagConstraints.BOTH;
		gbc_panel_achat.gridx = 0;
		gbc_panel_achat.gridy = 1;
		panel_content.add(panel_achat, gbc_panel_achat);
		panel_achat.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_achat_titre = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_achat_titre.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		panel_achat.add(panel_achat_titre, BorderLayout.NORTH);
		
		JLabel lblAchats = new JLabel("Achats");
		lblAchats.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_achat_titre.add(lblAchats);
		
		JPanel panel_listeAchats = new JPanel();
		panel_achat.add(panel_listeAchats, BorderLayout.CENTER);
		GridBagLayout gbl_panel_listeAchats = new GridBagLayout();
		gbl_panel_listeAchats.columnWidths = new int[]{0, 0};
		gbl_panel_listeAchats.rowHeights = new int[]{0, 0, 0};
		gbl_panel_listeAchats.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_listeAchats.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		panel_listeAchats.setLayout(gbl_panel_listeAchats);
		
		JPanel panel_achat_1 = new JPanel();
		GridBagConstraints gbc_panel_achat_1 = new GridBagConstraints();
		gbc_panel_achat_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_achat_1.fill = GridBagConstraints.BOTH;
		gbc_panel_achat_1.gridx = 0;
		gbc_panel_achat_1.gridy = 0;
		panel_listeAchats.add(panel_achat_1, gbc_panel_achat_1);
		panel_achat_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton btnSpectacle_1 = new JButton("Spectacle_1");
		panel_achat_1.add(btnSpectacle_1);
		
		JLabel lblDateHeure_1 = new JLabel("Date - Heure");
		panel_achat_1.add(lblDateHeure_1);
		
		JPanel panel_achat_2 = new JPanel();
		GridBagConstraints gbc_panel_achat_2 = new GridBagConstraints();
		gbc_panel_achat_2.fill = GridBagConstraints.BOTH;
		gbc_panel_achat_2.gridx = 0;
		gbc_panel_achat_2.gridy = 1;
		panel_listeAchats.add(panel_achat_2, gbc_panel_achat_2);
		panel_achat_2.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnSpectacle_3 = new JButton("Spectacle_2");
		panel_achat_2.add(btnSpectacle_3);
		
		JLabel lblDateHeure_2 = new JLabel("Date - heure");
		panel_achat_2.add(lblDateHeure_2);
	}

}
