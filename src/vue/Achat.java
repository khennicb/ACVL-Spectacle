package vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class Achat {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Achat window = new Achat();
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
	public Achat() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 451, 243);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblNomSpectacle = new JLabel("Spectacle des oisillons chantant - 10/01/2016 - 20H");
		lblNomSpectacle.setFont(new Font("Arial", Font.PLAIN, 16));
		panel.add(lblNomSpectacle);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new MigLayout("", "[][grow][grow][][grow]", "[][][][][grow][]"));
		
		JLabel lblNombreDePlace = new JLabel("Nombre de place:");
		panel_1.add(lblNombreDePlace, "cell 0 0");
		
		JSpinner spinner = new JSpinner();
		panel_1.add(spinner, "cell 1 0");
		
		JLabel lblTotal = new JLabel("Prix total :");
		panel_1.add(lblTotal, "cell 3 0");
		
		JLabel label = new JLabel("40");
		panel_1.add(label, "cell 4 0");
		
		JLabel lblCatgoriePlace = new JLabel("Cat\u00E9gorie places:");
		panel_1.add(lblCatgoriePlace, "cell 0 1,alignx trailing");
		
		JComboBox comboBox = new JComboBox();
		panel_1.add(comboBox, "cell 1 1,growx");
		
		JLabel lblPlace = new JLabel("Place1:");
		panel_1.add(lblPlace, "cell 1 2");
		
		JLabel lblRang = new JLabel("Rang:");
		panel_1.add(lblRang, "cell 3 2,alignx trailing");
		
		JComboBox comboBox_1 = new JComboBox();
		panel_1.add(comboBox_1, "flowx,cell 4 2,growx");
		
		JLabel lblNumroPlace = new JLabel("Num\u00E9ro place:");
		panel_1.add(lblNumroPlace, "cell 4 2");
		
		JComboBox comboBox_2 = new JComboBox();
		panel_1.add(comboBox_2, "cell 4 2");
		
		JLabel lblRglementParCb = new JLabel("R\u00E9glement par CB:");
		panel_1.add(lblRglementParCb, "cell 0 3,alignx trailing");
		
		textField = new JTextField();
		panel_1.add(textField, "cell 1 3 3 1,growx");
		textField.setColumns(10);
		
		JLabel lblCode = new JLabel("Code:");
		panel_1.add(lblCode, "cell 1 4,alignx trailing");
		
		textField_1 = new JTextField();
		panel_1.add(textField_1, "cell 2 4,growx");
		textField_1.setColumns(10);
		
		JLabel lblDateDexpiration = new JLabel("Date d'expiration:");
		panel_1.add(lblDateDexpiration, "cell 3 4,alignx trailing");
		
		textField_2 = new JTextField();
		panel_1.add(textField_2, "cell 4 4,growx");
		textField_2.setColumns(10);
		
		JButton btnValider = new JButton("Valider");
		panel_1.add(btnValider, "cell 4 5");
	}

}
