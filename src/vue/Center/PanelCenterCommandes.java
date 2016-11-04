package vue.Center;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelCenterCommandes extends PanelCenter {
	private JPanel panel_listeResa;
	private JPanel panel_listeAchats;
	
	public PanelCenterCommandes() {
		this.init();
		
		JLabel lblVosCommandes = new JLabel("Vos Commandes");
		lblVosCommandes.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_titre.add(lblVosCommandes);
		
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
		FlowLayout flowLayout = (FlowLayout) panel_reservation_titre.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_reservation.add(panel_reservation_titre, BorderLayout.NORTH);
		
		JLabel lblRservations = new JLabel("R\u00E9servations");
		lblRservations.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_reservation_titre.add(lblRservations);
		
		this.panel_listeResa = new JPanel();
		panel_reservation.add(panel_listeResa, BorderLayout.CENTER);
		GridBagLayout gbl_panel_listeResa = new GridBagLayout();
		gbl_panel_listeResa.columnWidths = new int[]{0, 0};
		gbl_panel_listeResa.rowHeights = new int[]{0, 0, 0};
		gbl_panel_listeResa.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_listeResa.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		panel_listeResa.setLayout(gbl_panel_listeResa);
		
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
		
		panel_listeAchats = new JPanel();
		panel_achat.add(panel_listeAchats, BorderLayout.CENTER);
		GridBagLayout gbl_panel_listeAchats = new GridBagLayout();
		gbl_panel_listeAchats.columnWidths = new int[]{0, 0};
		gbl_panel_listeAchats.rowHeights = new int[]{0, 0, 0};
		gbl_panel_listeAchats.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_listeAchats.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		panel_listeAchats.setLayout(gbl_panel_listeAchats);
	}
	
	public Map<String, JButton> ajoutElmtReservation(String nom_spectacle, Date date, int heure) {
		JPanel panel_Reservation = new JPanel();
		GridBagConstraints gbc_panel_Reservation = new GridBagConstraints();
		gbc_panel_Reservation.insets = new Insets(0, 0, 5, 0);
		gbc_panel_Reservation.fill = GridBagConstraints.BOTH;
		gbc_panel_Reservation.gridx = 0;
		gbc_panel_Reservation.gridy = 0;
		panel_listeResa.add(panel_Reservation, gbc_panel_Reservation);
		panel_Reservation.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnSpectacle = new JButton(nom_spectacle);
		panel_Reservation.add(btnSpectacle);
		
		JLabel lblDateHeure = new JLabel(date + " - " + heure);
		panel_Reservation.add(lblDateHeure);
		
		JButton btnConfirmation = new JButton("Confirmation");
		panel_Reservation.add(btnConfirmation);
		
		JButton btnAnnulation = new JButton("Annulation");
		panel_Reservation.add(btnAnnulation);
		
		Map<String, JButton> toReturn = new HashMap<String, JButton>();
		toReturn.put("btnConfirmation", btnConfirmation);
		toReturn.put("btnAnnulation", btnAnnulation);
		
		return toReturn;
	}
	
	public JButton ajoutElmtAchat(String nom_spectacle, Date date, int heure) {
		JPanel panel_achat = new JPanel();
		GridBagConstraints gbc_panel_achat = new GridBagConstraints();
		gbc_panel_achat.insets = new Insets(0, 0, 5, 0);
		gbc_panel_achat.fill = GridBagConstraints.BOTH;
		gbc_panel_achat.gridx = 0;
		gbc_panel_achat.gridy = 0;
		panel_listeAchats.add(panel_achat, gbc_panel_achat);
		panel_achat.setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton btnSpectacle = new JButton(nom_spectacle);
		panel_achat.add(btnSpectacle);
		
		JLabel lblDateHeure = new JLabel(date + " - " + heure);
		panel_achat.add(lblDateHeure);
		
		return btnSpectacle;
	}
	
	

}
