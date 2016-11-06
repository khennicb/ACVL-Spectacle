package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class ConfirmationReservation {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfirmationReservation window = new ConfirmationReservation();
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
	public ConfirmationReservation() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 446, 189);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblNomSpectacle = new JLabel("Nom spectacle - date heure");
		lblNomSpectacle.setFont(new Font("Arial", Font.PLAIN, 16));
		panel.add(lblNomSpectacle);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new MigLayout("", "[][grow][grow][][grow]", "[][][][][grow][]"));
		
		JLabel lblTotal = new JLabel("Total:");
		panel_1.add(lblTotal, "cell 0 0");
		
		JLabel label = new JLabel("40");
		panel_1.add(label, "cell 1 0");
		
		JLabel lblRglementParCb = new JLabel("R\u00E9glement par CB:");
		panel_1.add(lblRglementParCb, "cell 0 1,alignx trailing");
		
		JTextField textField = new JTextField();
		panel_1.add(textField, "cell 1 1 3 1,growx");
		textField.setColumns(10);
		
		JLabel lblCode = new JLabel("Code:");
		panel_1.add(lblCode, "cell 1 2,alignx trailing");
		
		JTextField textField_1 = new JTextField();
		panel_1.add(textField_1, "cell 2 2,growx");
		textField_1.setColumns(10);
		
		JLabel lblDateDexpiration = new JLabel("Date d'expiration:");
		panel_1.add(lblDateDexpiration, "cell 3 2,alignx trailing");
		
		JTextField textField_2 = new JTextField();
		panel_1.add(textField_2, "cell 4 2,growx");
		textField_2.setColumns(10);
		
		JButton btnValider = new JButton("Valider");
		panel_1.add(btnValider, "cell 4 3");
	}

}
