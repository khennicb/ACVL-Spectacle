package vue;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;

import vue.Center.PanelCenter;
import vue.Center.PanelCenterAchat;

public class FenetreAchat extends Dialogue {
	
	public FenetreAchat(ComboBoxElement[] cat) {
		super(new PanelCenterAchat(cat));
		
		// TODO Auto-generated constructor stub
		JPanel panel_header = new JPanel();
		frame.getContentPane().add(panel_header, BorderLayout.NORTH);
		
		JLabel lblNomSpectacle = new JLabel("Nom spectacle - date heure");
		lblNomSpectacle.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_header.add(lblNomSpectacle);
		frame.setBounds(100, 100, 451, 243);		
		frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.getContentPane().add(panel_header, BorderLayout.NORTH);
		frame.getContentPane().add(this.center.getPanel(), BorderLayout.CENTER);
		
	}

	public void ajoutPlace(){
		((PanelCenterAchat)this.center).ajoutPlace();
	}
	
	public void enleverPlace(){
		((PanelCenterAchat)this.center).enleverPlace();
	}
	
	public JLabel getLblTotal() {
		return ((PanelCenterAchat)this.center).getLblTotal();
	}

	public void setLblTotal(JLabel lblTotal) {
		((PanelCenterAchat)this.center).setLblTotal(lblTotal);
	}
	
	public JSpinner getSpinner(){
		return ((PanelCenterAchat)this.center).getSpinner();
	}
	
	public int getNombrePlace(){
		return ((PanelCenterAchat)this.center).getNombrePlaces();
	}
	
	public JComboBox<ComboBoxElement> getComboBoxCategory(){
		return ((PanelCenterAchat)this.center).getComboBoxCategory();
	};
	
	public JButton getBtnValider(){
		return ((PanelCenterAchat)this.center).getBtnValider();
	}
}
