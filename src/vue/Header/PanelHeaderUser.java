/**
 * 
 */
package vue.Header;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

/**
 * @author 42
 *
 */
public class PanelHeaderUser extends PanelHeader {
	protected JButton btnHome;
	protected JButton btnOk;
	protected JButton btnDeconnexion;
	protected JTextField textField_search;
	protected JPanel panel_user;
	
	public PanelHeaderUser() {
		JPanel panel_home = new JPanel();
		panel_home.setLayout(new GridLayout(0, 1, 0, 0));
		
		this.btnHome = new JButton("Home");
		panel_home.add(btnHome);
		
		JPanel panel_search = new JPanel();
		panel_search.setLayout(new GridLayout(0, 2, 0, 0));
		
		textField_search = new JTextField();
		panel_search.add(textField_search);
		textField_search.setColumns(10);
		
		btnOk = new JButton("Ok");
		panel_search.add(btnOk);
		
		panel_user = new JPanel();
		panel_user.setLayout(new GridLayout(1, 0, 0, 0));
				
		panel.setLayout(new MigLayout("", "[59px][147px][206px][grow]", "[23px,grow]"));
		panel.add(panel_home, "cell 0 0,alignx left,aligny top");
		panel.add(panel_search, "cell 1 0,growx,aligny top");
		panel.add(panel_user, "cell 2 0,alignx left,aligny top");
		
		JPanel panel_deconnexion = new JPanel();
		panel.add(panel_deconnexion, "cell 3 0,grow");
		panel_deconnexion.setLayout(new GridLayout(0, 1, 0, 0));
		
		btnDeconnexion = new JButton("D\u00E9connexion");
		panel_deconnexion.add(btnDeconnexion);
		
	}
}
