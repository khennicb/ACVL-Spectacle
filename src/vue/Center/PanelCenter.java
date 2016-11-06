package vue.Center;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JPanel;

import vue.AbstractPanel;

public class PanelCenter extends AbstractPanel {
	protected JPanel panel_titre;
	protected JPanel panel_content;
	
	
	protected void init(){
		panel.setLayout(new BorderLayout(0, 0));
		panel_titre = new JPanel();
		panel.add(panel_titre, BorderLayout.NORTH);
		
		panel_content = new JPanel();
		this.panel.add(panel_content, BorderLayout.CENTER);
		panel_content.setLayout(new BorderLayout(0, 0));
	}
	
}
