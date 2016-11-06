package vue;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;

import vue.Center.PanelCenter;

public class Fenetre {
	protected PanelCenter center;
	protected JFrame frame;
	
	/**
	 * Create the application.
	 */
	public Fenetre(PanelCenter center) {
		this.frame = new JFrame();
		//frame.getContentPane().setLayout(new BorderLayout(0, 0));
		this.center = center;
		
	}
	
	public void show(){
		this.frame.setVisible(true);
	}
	
	public JFrame getFrame() {
		return frame;
	}

	public PanelCenter getCenter() {
		return center;
	}

	public void setCenter(PanelCenter center) {
		frame.getContentPane().remove(this.center.getPanel());
		this.center = center;
		frame.getContentPane().add(this.center.getPanel(), BorderLayout.CENTER);
		this.show();
	}

}
