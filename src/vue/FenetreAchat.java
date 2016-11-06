package vue;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import vue.Center.PanelCenter;
import vue.Center.PanelCenterAchat;

public class FenetreAchat extends Fenetre {
	
	public FenetreAchat(ComboBoxElement[] cat) {
		super(new PanelCenterAchat(cat));
		// TODO Auto-generated constructor stub
		JPanel panel_header = new JPanel();
		frame.getContentPane().add(panel_header, BorderLayout.NORTH);
		
		JLabel lblNomSpectacle = new JLabel("Nom spectacle - date heure");
		lblNomSpectacle.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_header.add(lblNomSpectacle);
		frame.setBounds(100, 100, 451, 243);		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.getContentPane().add(panel_header, BorderLayout.NORTH);
		frame.getContentPane().add(this.center.getPanel(), BorderLayout.CENTER);
		
	}

}
