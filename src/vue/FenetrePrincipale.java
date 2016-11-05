package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;

import vue.Header.*;
import vue.Center.*;

public class FenetrePrincipale extends Fenetre {
	private JFrame frame;
	private PanelHeader header;
	
	
	/**
	 * Create the application.
	 */
	public FenetrePrincipale(PanelHeader header, PanelCenter center) {
		super(center);
		this.header = header;		
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() { 
		frame.setBounds(100, 100, 680, 566);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(this.header.getPanel(), BorderLayout.NORTH);
		frame.getContentPane().add(this.center.getPanel(), BorderLayout.CENTER);
		this.center.getPanel().setLayout(new GridLayout(1, 0, 0, 0));
	}
	
	
	public PanelHeader getHeader() {
		return header;
	}

	public void setHeader(PanelHeader header) {
		frame.getContentPane().remove(this.header.getPanel());
		this.header = header;
		frame.getContentPane().add(this.header.getPanel(), BorderLayout.NORTH);
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
