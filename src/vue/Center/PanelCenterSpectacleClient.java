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

import javax.swing.DropMode;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.UIManager;

public class PanelCenterSpectacleClient extends PanelCenter {
	private JPanel panel_listeRepresentation;
	
	public PanelCenterSpectacleClient(String nom, String description, String theme) {
		this.init();
		JLabel lblTitreSpectacle = new JLabel(nom);
		lblTitreSpectacle.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_titre.add(lblTitreSpectacle);
		
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
		
		JLabel lblDrame = new JLabel(theme);
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
		txtpnl_description.setText(description);
		panel_description_content.add(txtpnl_description);
		
		panel_listeRepresentation = new JPanel();
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
	}
	
	public Map<String, JButton> ajoutElmtRepresentation(Date date,int heure) {
		JPanel panel_representation = new JPanel();
		GridBagConstraints gbc_panel_representation = new GridBagConstraints();
		gbc_panel_representation.insets = new Insets(0, 0, 5, 0);
		gbc_panel_representation.fill = GridBagConstraints.BOTH;
		gbc_panel_representation.gridx = 0;
		gbc_panel_representation.gridy = 0;
		panel_listeRepresentation.add(panel_representation, gbc_panel_representation);
		panel_representation.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblDateHeure = new JLabel(date + " - " + heure);
		panel_representation.add(lblDateHeure);
		
		JButton btnAcheter = new JButton("Acheter");
		panel_representation.add(btnAcheter);
		
		JButton btnReserver = new JButton("R\u00E9server");
		panel_representation.add(btnReserver);
		
		Map<String, JButton> toReturn = new HashMap<String, JButton>();
		toReturn.put("btnAcheter", btnAcheter);
		toReturn.put("btnReserver", btnReserver);
		
		return toReturn;
	}
}
