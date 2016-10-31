package vue.Center;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import vue.AbstractPanel;

public class PanelCenter extends AbstractPanel {
	protected JPanel panel_titre;
	protected JPanel panel_content;
	
	public PanelCenter(){
		panel_content = new JPanel();
		this.panel.add(panel_content, BorderLayout.CENTER);
		panel_content.setLayout(new BorderLayout(0, 0));
	}
	
}
