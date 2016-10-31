package vue.Header;

import javax.swing.JButton;

public class PanelHeaderResponsable extends PanelHeaderUser {
	private JButton btnAjoutSpectacle;
	public PanelHeaderResponsable() {
		super();
		btnAjoutSpectacle = new JButton("Ajout spectacle");
		panel_user.add(btnAjoutSpectacle);
	}
}
