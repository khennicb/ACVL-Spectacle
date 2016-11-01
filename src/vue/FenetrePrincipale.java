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
	
	
	public static void main (String [] args) {
		String [] tab = {"test"};
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetrePrincipale window = new FenetrePrincipale(new PanelHeaderConnexion(), new PanelCenterListeSpectacles(tab) );
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
