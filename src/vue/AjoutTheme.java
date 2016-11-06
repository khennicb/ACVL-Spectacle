package vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JButton;

public class AjoutTheme {

	private JFrame frmAjoutTheme;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjoutTheme window = new AjoutTheme();
					window.frmAjoutTheme.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AjoutTheme() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAjoutTheme = new JFrame();
		frmAjoutTheme.setTitle("Ajout th\u00E8me");
		frmAjoutTheme.setBounds(100, 100, 424, 80);
		frmAjoutTheme.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmAjoutTheme.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblNom = new JLabel("Nom:");
		panel.add(lblNom);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnOk = new JButton("Ok");
		panel.add(btnOk);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setVgap(10);
		flowLayout.setHgap(10);
		frmAjoutTheme.getContentPane().add(panel_1, BorderLayout.NORTH);
	}

}
