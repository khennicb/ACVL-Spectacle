package vue.Center;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class PanelCenterAjoutSpectacle extends PanelCenter{
	private JTextField textField_nom;
	private JComboBox<String> comboBox_theme;
	private int ligne_representation;
	private JTextField txtDate;
	private JTextField txtHeure;
	private JTextArea textArea_description;
	private JPanel panel_ajoutRepresentation;

	public PanelCenterAjoutSpectacle(String [] themes) {
		this.init();
		JLabel lblAjoutDunSpectacle = new JLabel("Ajout d'un spectacle");
		lblAjoutDunSpectacle.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_titre.add(lblAjoutDunSpectacle);
		
		panel_content.setLayout(new MigLayout("", "[][grow]", "[][][grow][grow][grow]"));
		
		JLabel lblNomDuSpectacle = new JLabel("Nom du spectacle:");
		lblNomDuSpectacle.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_content.add(lblNomDuSpectacle, "cell 0 0,alignx trailing");
		
		textField_nom = new JTextField();
		panel_content.add(textField_nom, "cell 1 0,growx");
		textField_nom.setColumns(10);
		
		JLabel lblThme = new JLabel("Th\u00E8me:");
		lblThme.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_content.add(lblThme, "cell 0 1,alignx trailing");
		
		this.comboBox_theme = new JComboBox<String>();
		comboBox_theme.setModel(new DefaultComboBoxModel<String>(themes));
		panel_content.add(comboBox_theme, "cell 1 1,growx");
		
		JButton btnAddTheme = new JButton("+");
		panel_content.add(btnAddTheme, "cell 1 1");
		
		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_content.add(lblDescription, "cell 0 2,alignx right");
		
		textArea_description = new JTextArea();
		panel_content.add(textArea_description, "cell 1 2,grow");
		
		JLabel lblAjoutReprsentation = new JLabel("Ajout repr\u00E9sentation :");
		lblAjoutReprsentation.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_content.add(lblAjoutReprsentation, "cell 0 4");
		
		panel_ajoutRepresentation = new JPanel();
		panel_content.add(panel_ajoutRepresentation, "cell 1 3,grow");
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
		
		JButton btnAjoutRepresentation = new JButton("+");
		panel_ajoutRepresentation.add(btnAjoutRepresentation);
		
		ligne_representation = 3;
		
		JPanel panel_footer = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_footer.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		this.panel.add(panel_footer, BorderLayout.SOUTH);
		
		JButton btnValider = new JButton("Valider");
		panel_footer.add(btnValider);
		
	}
	
	
	public void ajoutElmtRepresentation(Date date, int heure) {
		JPanel panel_representation = new JPanel();
		panel_content.add(panel_representation, "cell 1 "+ this.ligne_representation +",grow");
		panel_representation.setLayout(new GridLayout(1, 0, 0, 0));
		
		panel_representation.add(new JLabel("Date: "));
		panel_representation.add(new JLabel(date + ""));
		panel_representation.add(new JLabel("Heure:"));
		panel_representation.add(new JLabel(heure + "h"));
		
		ligne_representation++;
		
		panel_content.add(panel_ajoutRepresentation, "cell 1 " + ligne_representation + ",grow");
		
		
	}
}
