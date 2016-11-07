package vue;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JDialog;
import javax.swing.JFrame;

import vue.Center.PanelCenter;

public class Dialogue {
	protected PanelCenter center;
	protected JDialog frame;
	
	/**
	 * Create the application.
	 */
	public Dialogue(PanelCenter center) {
		this.frame = new JDialog();
		this.frame.setModalityType(JDialog.DEFAULT_MODALITY_TYPE);
		//frame.getContentPane().setLayout(new BorderLayout(0, 0));
		this.center = center;
		
	}
	
	public void show(){
		this.frame.setVisible(true);
	}
	
	public void close(){
		this.frame.dispose();
	}
	
	public JDialog getFrame() {
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