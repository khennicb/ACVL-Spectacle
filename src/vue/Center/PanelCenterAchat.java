package vue.Center;

import java.util.ArrayList;
import java.util.Map;

import javafx.scene.control.ComboBox;
import net.miginfocom.swing.MigLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import vue.ComboBoxElement;

public class PanelCenterAchat extends PanelCenter {
	private ArrayList<PlaceObject> listePlace;
	private JTextField textField_numeroCB;
	private JTextField textField_Code;
	private JTextField textField_DateExpi;
	private JSpinner spinner;
	private JButton btnValider;
	private JLabel lblTotal;
	private JLabel lblReglement;
	private JLabel lblCode;
	private JLabel lblDateDexpiration;
	private JComboBox<ComboBoxElement> comboBox_cat;
	
	public PanelCenterAchat(ComboBoxElement[] cat) {
		//TODO : le mig layout est cassé
		//panel.setLayout(new MigLayout("", "[][grow][grow][][grow]", "[][][][][grow][]"));
		panel.add(new JLabel("Nombre de place:"), "cell 0 0");
		
		spinner = new JSpinner();
		panel.add(spinner, "cell 1 0");
	
		panel.add(new JLabel("Prix total:"), "cell 3 0");
		lblTotal = new JLabel("0");
		panel.add(lblTotal, "cell 4 0");
		
		JLabel lblCatgoriePlace = new JLabel("Cat\u00E9gorie places:");
		panel.add(lblCatgoriePlace, "cell 0 1,alignx trailing");
		
		comboBox_cat = new JComboBox<ComboBoxElement>();
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
		
		listePlace = new ArrayList<PlaceObject>();
	}
	
	public class PlaceObject{
		JLabel lblPlace;
		JLabel lblRang;
		JLabel lblNumero;
		JComboBox<Integer> comboBox_1;
		JComboBox<Integer> comboBox_2;
		public PlaceObject(){
			lblPlace = new JLabel("Place " + (listePlace.size() + 1) +":");
			int row = listePlace.size() + 2;
		
			panel.add(lblPlace, "cell 1 " + row);
			lblRang = new JLabel("Rang:");
			panel.add(lblRang, "cell 3 " + row + ",alignx trailing");
			comboBox_1 = new JComboBox<Integer>();
			panel.add(comboBox_1, "flowx,cell 4 " + row + ",growx");
			lblNumero = new JLabel("Num\u00E9ro place:");
			panel.add(lblNumero, "cell 4 "+ row);
			comboBox_2 = new JComboBox<Integer>();
			panel.add(comboBox_2, "cell 4 " + row );	
		}
		
		public void remove(){
			panel.remove(lblPlace);
			panel.remove(lblRang);
			panel.remove(lblNumero);
			panel.remove(comboBox_1);
			panel.remove(comboBox_2);
		}
		
		public JComboBox<Integer> getRangComboBox(){
			return comboBox_1;
		}
		
		public JComboBox<Integer> getNumeroComboBox(){
			return comboBox_2;
		}
	}
	
	public PlaceObject ajoutPlace() {
		//remove paimement + validation		
		panel.remove(lblReglement);
		panel.remove(textField_numeroCB);
		panel.remove(lblCode);
		panel.remove(textField_Code);
		panel.remove(lblDateDexpiration);
		panel.remove(textField_DateExpi);
		panel.remove(btnValider);

		int row = listePlace.size() + 2;
		PlaceObject place = new PlaceObject();
		this.listePlace.add(place);
		//placement paiement + validation
		panel.add(lblReglement, "cell 0 "+ (row + 1) +",alignx trailing");
		panel.add(textField_numeroCB, "cell 1 " + (row + 1) + " 3 1,growx");
		panel.add(lblCode, "cell 1 " + (row + 1) + ",alignx trailing");
		panel.add(textField_Code, "cell 2 " + (row + 1) + ",growx");
		panel.add(lblDateDexpiration, "cell 3 " + (row + 1) + ",alignx trailing");
		panel.add(textField_DateExpi, "cell 4 " + (row + 1) + ",growx");
		panel.add(btnValider, "cell 4 " + (row + 2));
		return place;
	}
	
	public void enleverPlace(){
		if(this.listePlace.size()==0){
			return;
		}
		panel.remove(lblReglement);
		panel.remove(textField_numeroCB);
		panel.remove(lblCode);
		panel.remove(textField_Code);
		panel.remove(lblDateDexpiration);
		panel.remove(textField_DateExpi);
		panel.remove(btnValider);
		PlaceObject place = this.listePlace.get(this.listePlace.size()-1);
		place.remove();
		this.listePlace.remove(place);
		int row = listePlace.size() + 2;
		panel.add(lblReglement, "cell 0 "+ (row + 1) +",alignx trailing");
		panel.add(textField_numeroCB, "cell 1 " + (row + 1) + " 3 1,growx");
		panel.add(lblCode, "cell 1 " + (row + 2) + ",alignx trailing");
		panel.add(textField_Code, "cell 2 " + (row + 1) + ",growx");
		panel.add(lblDateDexpiration, "cell 3 " + (row + 1) + ",alignx trailing");
		panel.add(textField_DateExpi, "cell 4 " + (row + 1) + ",growx");
		panel.add(btnValider, "cell 4 " + (row + 2));
	}

	public JLabel getLblTotal() {
		return lblTotal;
	}

	public void setLblTotal(JLabel lblTotal) {
		this.lblTotal = lblTotal;
	}
	
	public int getNombrePlaces(){
		return listePlace.size();
	}
	
	public JSpinner getSpinner(){
		return spinner;
	}
	
	public JComboBox<ComboBoxElement> getComboBoxCategory(){
		return comboBox_cat;
	};
	
	public ArrayList<PlaceObject> getListePlace(){
		return listePlace;
	}
	public JButton getBtnValider(){
		return btnValider;
	}
	public JTextField getNumeroCBField(){
		return textField_numeroCB;
	}
	public JTextField getCodeField(){
		return textField_Code;
	}
	public JTextField getDateExpField(){
		return textField_DateExpi;
	}
}
