package vue.Center;

import java.util.ArrayList;
import java.util.Map;

import javafx.scene.control.ComboBox;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import vue.ComboBoxElement;

public class PanelCenterAchat extends PanelCenter {
	private ArrayList<ArrayList<JComboBox<Integer>>> listePlace;
	private JTextField textField_numeroCB;
	private JTextField textField_Code;
	private JTextField textField_DateExpi;
	private JButton btnValider;
	private JLabel lblTotal;
	private JLabel lblReglement;
	private JLabel lblCode;
	private JLabel lblDateDexpiration;
	private JComboBox comboBox_cat;
	
	public PanelCenterAchat(ComboBoxElement[] cat) {
		panel.add(new JLabel("Nombre de place:"), "cell 0 0");
		
		JSpinner spinner = new JSpinner();
		panel.add(spinner, "cell 1 0");
	
		panel.add(new JLabel("Prix total:"), "cell 3 0");
		lblTotal = new JLabel("0");
		panel.add(lblTotal, "cell 4 0");
		
		JLabel lblCatgoriePlace = new JLabel("Cat\u00E9gorie places:");
		panel.add(lblCatgoriePlace, "cell 0 1,alignx trailing");
		
		JComboBox comboBox_cat = new JComboBox();
		comboBox_cat.setModel(new DefaultComboBoxModel<ComboBoxElement>(cat));
		panel.add(comboBox_cat, "cell 1 1,growx");
		
		lblReglement = new JLabel("R\u00E9glement par CB:");
		panel.add(lblReglement, "cell 0 3,alignx trailing");
		
		textField_numeroCB = new JTextField();
		panel.add(textField_numeroCB, "cell 1 3 3 1,growx");
		textField_numeroCB.setColumns(10);
		
		lblCode = new JLabel("Code:");
		panel.add(lblCode, "cell 1 4,alignx trailing");
		
		textField_Code = new JTextField();
		panel.add(textField_Code, "cell 2 4,growx");
		textField_Code.setColumns(10);
		
		lblDateDexpiration = new JLabel("Date d'expiration:");
		panel.add(lblDateDexpiration, "cell 3 4,alignx trailing");
		
		textField_DateExpi = new JTextField();
		panel.add(textField_DateExpi, "cell 4 4,growx");
		textField_DateExpi.setColumns(10);
		
		btnValider = new JButton("Valider");
		panel.add(btnValider, "cell 4 5");
		
		listePlace = new ArrayList<ArrayList<JComboBox<Integer>>>();
	}
	
	public void ajoutPlace() {
		ArrayList<JComboBox<Integer>> placeData = new ArrayList<JComboBox<Integer>>();
		JLabel lblPlace = new JLabel("Place " + (listePlace.size() + 1) +":");
		int row = listePlace.size() + 2;
		//remove paimement + validation
		panel.remove(lblReglement);
		panel.remove(textField_numeroCB);
		panel.remove(lblCode);
		panel.remove(textField_Code);
		panel.remove(lblDateDexpiration);
		panel.remove(textField_DateExpi);
		panel.remove(btnValider);
		
		panel.add(lblPlace, "cell 1 " + row);
		
		panel.add(new JLabel("Rang:"), "cell 3 " + row + ",alignx trailing");
		panel.add(new JLabel("Num\u00E9ro place:"), "cell 4 2");
		
		JComboBox<Integer> comboBox_1 = new JComboBox<Integer>();
		panel.add(comboBox_1, "flowx,cell 4 " + row + ",growx");
		placeData.add(comboBox_1);
		
		
		JComboBox<Integer> comboBox_2 = new JComboBox<Integer>();
		panel.add(comboBox_2, "cell 4 " + row );
		placeData.add(comboBox_2);
		
		this.listePlace.add(placeData);
		
		//placement paiement + validation
		panel.add(lblReglement, "cell 0 "+ (row + 2) +",alignx trailing");
		panel.add(textField_numeroCB, "cell 1 " + (row + 2) + " 3 1,growx");
		panel.add(lblCode, "cell 1 " + (row + 2) + ",alignx trailing");
		panel.add(textField_Code, "cell 2 " + (row + 2) + ",growx");
		panel.add(lblDateDexpiration, "cell 3 " + (row + 2) + ",alignx trailing");
		panel.add(textField_DateExpi, "cell 4 " + (row + 2) + ",growx");
		panel.add(btnValider, "cell 4 " + (row + 3));
	}

	public JLabel getLblTotal() {
		return lblTotal;
	}

	public void setLblTotal(JLabel lblTotal) {
		this.lblTotal = lblTotal;
	}
	
	
	
	
}
