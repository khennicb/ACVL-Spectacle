package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import vue.Header.*;
import vue.Center.*;

public class FenetrePrincipale extends Fenetre {
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
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.getContentPane().add(this.header.getPanel(), BorderLayout.NORTH);
		frame.getContentPane().add(this.center.getPanel(), BorderLayout.CENTER);
	}
	
	
	public PanelHeader getHeader() {
		return header;
	}

	public void setHeader(PanelHeader header) {
		frame.getContentPane().remove(this.header.getPanel());
		this.header = header;
		frame.getContentPane().add(this.header.getPanel(), BorderLayout.NORTH);
		this.show();
	}

	
	public static void main (String [] args) {
		final String [] tab = {"test"};
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelCenter test = new PanelCenterConnexion();
					final FenetrePrincipale window = new FenetrePrincipale(new PanelHeaderClient(), test );
					window.show();
					
					PanelCenter t = new PanelCenterListeSpectacles(tab);
					((PanelCenterConnexion)window.getCenter()).getBtnConnexion().addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							window.setCenter(t);
						}
					});
					//window.setHeader(new PanelHeaderUser());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
