package vue.Center;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import net.miginfocom.swing.MigLayout;
import vue.ComboBoxElement;

public class PanelCenterListeSpectacles extends PanelCenter {
	private JPanel panel_liste;
	private JComboBox<ComboBoxElement> comboBox_filtres;
	private int col;
	private int lig;
	
	public PanelCenterListeSpectacles(ComboBoxElement[] filtres) {
		this.init();
		
		JLabel lblSpectaclesVenir = new JLabel("Spectacles \u00E0 venir");
		lblSpectaclesVenir.setFont(new Font("Arial", Font.PLAIN, 16));
		lblSpectaclesVenir.setHorizontalAlignment(SwingConstants.LEFT);
		panel_titre.add(lblSpectaclesVenir);
		
		JPanel panel_filtre = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_filtre.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_content.add(panel_filtre, BorderLayout.NORTH);
		
		JLabel lblFiltres = new JLabel("Filtre:");
		lblFiltres.setHorizontalAlignment(SwingConstants.LEFT);
		panel_filtre.add(lblFiltres);
		
		comboBox_filtres = new JComboBox<ComboBoxElement>();
		comboBox_filtres.setModel(new DefaultComboBoxModel<ComboBoxElement>(filtres));
		comboBox_filtres.setToolTipText("Filtre\r\n");
		panel_filtre.add(comboBox_filtres);
		
		panel_liste = new JPanel();
		panel_content.add(panel_liste, BorderLayout.CENTER);
		panel_liste.setLayout(new MigLayout());
		lig=0;
		col=0;
	}
	
	public JButton ajoutElmtListeSpectacle(String nom) {
		JButton btnSpectacle = new JButton(nom);
		System.out.println("cell " + col + " " + lig);
		if(col == 20){
			panel_liste.add(btnSpectacle,"wrap");
		} else {
			panel_liste.add(btnSpectacle);
		}
		if(col < 20) {
			col++;
		} else {
			col = 0;
			lig++;
		}
		
		return btnSpectacle;
	}
	
	public JComboBox<ComboBoxElement> getComboBoxFiltres(){
		return comboBox_filtres;
	}
}
