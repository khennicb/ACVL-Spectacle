package vue;

import javax.swing.JPanel;

public abstract class AbstractPanel {
	protected JPanel panel;
	
	public AbstractPanel() {
		this.panel = new JPanel();
	}
	
	public JPanel getPanel() {
		return this.panel;
	}
}
