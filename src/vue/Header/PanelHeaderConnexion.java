package vue.Header;

import java.awt.Font;

import javax.swing.JLabel;

public class PanelHeaderConnexion extends PanelHeader {
	public PanelHeaderConnexion () {
		super();
		JLabel lblTitre = new JLabel("ResaSpectacle");
		lblTitre.setFont(new Font("Arial", Font.PLAIN, 24));
		this.panel.add(lblTitre);
	}
}
