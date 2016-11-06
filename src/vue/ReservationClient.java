package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;

import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;

public class ReservationClient {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReservationClient window = new ReservationClient();
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
	public ReservationClient() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblNomSpectacle = new JLabel("Nom spectacle - date heure");
		lblNomSpectacle.setFont(new Font("Arial", Font.PLAIN, 16));
		panel.add(lblNomSpectacle);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new MigLayout("", "[][grow][][grow]", "[][][][]"));
		
		JLabel lblNombreDePlace = new JLabel("Nombre de place:");
		panel_1.add(lblNombreDePlace, "cell 0 0");
		
		JSpinner spinner = new JSpinner();
		panel_1.add(spinner, "cell 1 0");
		
		JLabel lblTotal = new JLabel("Total:");
		panel_1.add(lblTotal, "cell 2 0");
		
		JLabel label = new JLabel("40");
		panel_1.add(label, "cell 3 0");
		
		JLabel lblCatgoriePlace = new JLabel("Cat\u00E9gorie places:");
		panel_1.add(lblCatgoriePlace, "cell 0 1,alignx trailing");
		
		JComboBox comboBox = new JComboBox();
		panel_1.add(comboBox, "cell 1 1,growx");
		
		JLabel lblPlace = new JLabel("Place1:");
		panel_1.add(lblPlace, "cell 1 2");
		
		JLabel lblRang = new JLabel("Rang:");
		panel_1.add(lblRang, "cell 2 2,alignx trailing");
		
		JComboBox comboBox_1 = new JComboBox();
		panel_1.add(comboBox_1, "flowx,cell 3 2,growx");
		
		JButton btnValider = new JButton("Valider");
		panel_1.add(btnValider, "cell 3 3");
		
		JLabel lblNumroPlace = new JLabel("Num\u00E9ro place:");
		panel_1.add(lblNumroPlace, "cell 3 2");
		
		JComboBox comboBox_2 = new JComboBox();
		panel_1.add(comboBox_2, "cell 3 2");
	}

}
