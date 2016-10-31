package vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.FlowLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.GridLayout;
import javax.swing.JButton;

public class AjoutSpectacle {

	private JFrame frame;
	private JTextField textField;
	private JTextField txtDate;
	private JTextField txtHeure;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjoutSpectacle window = new AjoutSpectacle();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AjoutSpectacle() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 259);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel_header = new JPanel();
		frame.getContentPane().add(panel_header, BorderLayout.NORTH);
		
		JPanel panel_center = new JPanel();
		frame.getContentPane().add(panel_center, BorderLayout.CENTER);
		panel_center.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_titre = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_titre.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_center.add(panel_titre, BorderLayout.NORTH);
		
		JLabel lblAjoutDunSpectacle = new JLabel("Ajout d'un spectacle");
		lblAjoutDunSpectacle.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_titre.add(lblAjoutDunSpectacle);
		
		JPanel panel_content = new JPanel();
		panel_center.add(panel_content, BorderLayout.CENTER);
		panel_content.setLayout(new MigLayout("", "[][grow]", "[][][grow][grow]"));
		
		JLabel lblNomDuSpectacle = new JLabel("Nom du spectacle:");
		lblNomDuSpectacle.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_content.add(lblNomDuSpectacle, "cell 0 0,alignx trailing");
		
		textField = new JTextField();
		panel_content.add(textField, "cell 1 0,growx");
		textField.setColumns(10);
		
		JLabel lblThme = new JLabel("Th\u00E8me:");
		lblThme.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_content.add(lblThme, "cell 0 1,alignx trailing");
		
		JComboBox comboBox = new JComboBox();
		panel_content.add(comboBox, "cell 1 1,growx");
		
		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_content.add(lblDescription, "cell 0 2,alignx right");
		
		JTextArea textArea = new JTextArea();
		panel_content.add(textArea, "cell 1 2,grow");
		
		JLabel lblAjoutReprsentation = new JLabel("Ajout repr\u00E9sentation :");
		lblAjoutReprsentation.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_content.add(lblAjoutReprsentation, "cell 0 3");
		
		JPanel panel = new JPanel();
		panel_content.add(panel, "cell 1 3,grow");
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblDate = new JLabel("Date:");
		panel.add(lblDate);
		
		txtDate = new JTextField();
		txtDate.setText("JJ/MM/AA");
		panel.add(txtDate);
		txtDate.setColumns(10);
		
		JLabel lblHeure = new JLabel("Heure:");
		panel.add(lblHeure);
		
		txtHeure = new JTextField();
		txtHeure.setText("HH:MM");
		panel.add(txtHeure);
		txtHeure.setColumns(10);
		
		JButton btnAjoutRepresentation = new JButton("+");
		panel.add(btnAjoutRepresentation);
	}

}
