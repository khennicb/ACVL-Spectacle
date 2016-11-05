package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;

import vue.Header.*;
import vue.Center.*;

public class FenetrePrincipale {
	private JFrame frame;
	private PanelHeader header;
	private PanelCenter center;
	
	/**
	 * Create the application.
	 */
	public FenetrePrincipale(PanelHeader header, PanelCenter center) {
		this.header = header;
		this.center = center;
		
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() { 
		frame = new JFrame();
		frame.setBounds(100, 100, 680, 566);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.getContentPane().add(this.header.getPanel(), BorderLayout.NORTH);
		frame.getContentPane().add(this.center.getPanel(), BorderLayout.CENTER);
		this.center.getPanel().setLayout(new GridLayout(1, 0, 0, 0));
	}
	
	public void show(){
		this.frame.setVisible(true);
	}
	
	
	
	
	public PanelHeader getHeader() {
		return header;
	}

	public void setHeader(PanelHeader header) {
		frame.getContentPane().remove(this.header.getPanel());
		this.header = header;
		frame.getContentPane().add(this.header.getPanel(), BorderLayout.NORTH);
	}

	public PanelCenter getCenter() {
		return center;
	}

	public void setCenter(PanelCenter center) {
		frame.getContentPane().remove(this.center.getPanel());
		this.center = center;
		frame.getContentPane().add(this.center.getPanel(), BorderLayout.CENTER);
		this.center.getPanel().setLayout(new GridLayout(1, 0, 0, 0));
	}

	public static void main (String [] args) {
		final String [] tab = {"test"};
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetrePrincipale window = new FenetrePrincipale(new PanelHeaderConnexion(), new PanelCenterListeSpectacles(tab) );
					window.show();
					
					PanelCenter test = new PanelCenterConnexion();
					((PanelCenterConnexion)test).setWarningConnexion("Mot de passe ou login incorrecte");
					window.setCenter(test);
					window.setHeader(new PanelHeaderUser());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
