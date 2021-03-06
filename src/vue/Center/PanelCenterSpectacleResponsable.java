package vue.Center;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import vue.ComboBoxElement;

public class PanelCenterSpectacleResponsable extends PanelCenter {
	private JTextField txtdate;
	private JTextField txtheure;
	private JButton btnAjout;
	private JPanel panel_ListeRepresentation;
	private int lig;
	private JComboBox<ComboBoxElement> comboBoxSalle;
	
	public PanelCenterSpectacleResponsable(String nom) {
		this.init();
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
		txtdate.setText("JJ/MM/AAAA ");
		panel_ajoutRepresentation.add(txtdate, "flowx,cell 2 0,growx");
		txtdate.setColumns(10);
		
		JLabel lblHeure = new JLabel("Heure:");
		lblHeure.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_ajoutRepresentation.add(lblHeure, "cell 2 0");
		
		txtheure = new JTextField();
		lblHeure.setLabelFor(txtheure);
		txtheure.setText("HH  ");
		panel_ajoutRepresentation.add(txtheure, "cell 2 0");
		txtheure.setColumns(10);
		
		JLabel lblSalle = new JLabel("Salle:");
		panel_ajoutRepresentation.add(lblSalle, "cell 2 0");
		
		comboBoxSalle = new JComboBox<ComboBoxElement>();
		panel_ajoutRepresentation.add(comboBoxSalle, "cell 2 0");

		btnAjout = new JButton("Ajout");
		panel_ajoutRepresentation.add(btnAjout, "cell 2 0");
		
		panel_ListeRepresentation = new JPanel();
		panel_content.add(panel_ListeRepresentation, BorderLayout.CENTER);
		panel_ListeRepresentation.setLayout(new MigLayout("", "[][][]", "[][]"));
		
		JLabel lblHorraire = new JLabel("Horaire");
		lblHorraire.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_ListeRepresentation.add(lblHorraire, "cell 0 0");
		
		JLabel lblVentes = new JLabel("Ventes");
		lblVentes.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_ListeRepresentation.add(lblVentes, "cell 1 0");
		
		JLabel lblRservations = new JLabel("R\u00E9servations");
		lblRservations.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_ListeRepresentation.add(lblRservations, "cell 2 0");
		
		lig = 0;
	}
	
	public JButton ajoutElmtRepresentation(Date date, int heure, int nbVentes, int nbReservations) {
		lig++;
		
		JLabel lblDateHeure = new JLabel(date + " - " + heure);
		lblDateHeure.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_ListeRepresentation.add(lblDateHeure, "cell 0 " + lig);
		
		JLabel lblNbreVentes = new JLabel("" + nbVentes);
		panel_ListeRepresentation.add(lblNbreVentes, "cell 1 " + lig);
		
		JButton btnNbrReservation = new JButton("" + nbReservations);
		panel_ListeRepresentation.add(btnNbrReservation, "cell 2 " + lig);
		
		
		return btnNbrReservation;
	}
	
	public void effacerListeRepresentation() {
		panel_ListeRepresentation.removeAll();
		
		JLabel lblHorraire = new JLabel("Horaire");
		lblHorraire.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_ListeRepresentation.add(lblHorraire, "cell 0 0");
		
		JLabel lblVentes = new JLabel("Ventes");
		lblVentes.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_ListeRepresentation.add(lblVentes, "cell 1 0");
		
		JLabel lblRservations = new JLabel("R\u00E9servations");
		lblRservations.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_ListeRepresentation.add(lblRservations, "cell 2 0");
		
		lig = 0;
	}
	
	public JButton getBtnAjout(){
		return btnAjout;
	}
	
	public JComboBox<ComboBoxElement> getComboBoxSalle(){
		return comboBoxSalle;
	}
	
	public JTextField getTxtDate(){
		return txtdate;
	}
	
	public JTextField getTxtHeure(){
		return txtheure;
	}
}
