package vue.Center;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class PanelCenterListeReservations extends PanelCenter {
	private JTextField textField_filtre;
	private JButton btnOk;
	private JButton btnToutSlectionner;
	private JButton btnAnnulerReservation;
	private JPanel panel_Reservations_liste;
	private Map<Integer, JCheckBox> listeCheckbox;
	
	public PanelCenterListeReservations (String nomSpectacle, Date date, int heure){
		this.init();
		
		JLabel lblRservationsPourNomspectacle = new JLabel("R\u00E9servations pour " + nomSpectacle);
		lblRservationsPourNomspectacle.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_titre.add(lblRservationsPourNomspectacle);
		
		JPanel panel_horraire = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_horraire.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_content.add(panel_horraire, BorderLayout.NORTH);
		
		panel_horraire.add(new JLabel(date + " - " + heure));
		
		JPanel panel_Reservations = new JPanel();
		panel_content.add(panel_Reservations, BorderLayout.CENTER);
		panel_Reservations.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_Reservations_filtre = new JPanel();
		panel_Reservations.add(panel_Reservations_filtre, BorderLayout.NORTH);
		panel_Reservations_filtre.setLayout(new MigLayout("", "[grow][grow][grow][grow]", "[grow]"));
		
		JPanel panel_search = new JPanel();
		panel_Reservations_filtre.add(panel_search, "cell 0 0,grow");
		panel_search.setLayout(new GridLayout(0, 1, 0, 0));
		
		textField_filtre = new JTextField();
		panel_search.add(textField_filtre);
		textField_filtre.setColumns(10);
		
		JPanel panel_search_validation = new JPanel();
		panel_Reservations_filtre.add(panel_search_validation, "cell 1 0,grow");
		panel_search_validation.setLayout(new GridLayout(0, 1, 0, 0));
		
		btnOk = new JButton("Ok");
		panel_search_validation.add(btnOk);
		
		JPanel panel_ToutSelectionner = new JPanel();
		panel_Reservations_filtre.add(panel_ToutSelectionner, "cell 2 0,grow");
		panel_ToutSelectionner.setLayout(new GridLayout(0, 1, 0, 0));
		
		btnToutSlectionner = new JButton("Tout s\u00E9lectionner");
		panel_ToutSelectionner.add(btnToutSlectionner);
		
		JPanel panel_AnnulerReservation = new JPanel();
		panel_Reservations_filtre.add(panel_AnnulerReservation, "cell 3 0,grow");
		panel_AnnulerReservation.setLayout(new GridLayout(0, 1, 0, 0));
		
		btnAnnulerReservation = new JButton("Annuler R\u00E9servation");
		panel_AnnulerReservation.add(btnAnnulerReservation);
		
		panel_Reservations_liste = new JPanel();
		panel_Reservations.add(panel_Reservations_liste, BorderLayout.CENTER);
		panel_Reservations_liste.setLayout(new GridLayout(0, 1, 0, 0));
		
		this.listeCheckbox = new HashMap<Integer, JCheckBox>();
	}
	
	public void ajoutElmtReservation(int numClient, String nomClient, String prenomClient, String emailClient) {
		JPanel panel_Reservations_elmt = new JPanel();
		panel_Reservations_liste.add(panel_Reservations_elmt);
		panel_Reservations_elmt.setLayout(new GridLayout(1, 0, 0, 0));
		
		panel_Reservations_elmt.add(new JLabel("" + numClient));
		panel_Reservations_elmt.add(new JLabel(nomClient));
		panel_Reservations_elmt.add(new JLabel(prenomClient));
		panel_Reservations_elmt.add(new JLabel(emailClient));
		
		JCheckBox checkBox = new JCheckBox("");
		this.listeCheckbox.put(numClient, checkBox);
		panel_Reservations_elmt.add(checkBox);
	}
}
