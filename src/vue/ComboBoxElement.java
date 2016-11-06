package vue;

public class ComboBoxElement{
	private int index;
	private String value;
	
	public ComboBoxElement(int index, String value) {
		this.index = index;
		this.value = value;
	}
	
	public int getIndex(){
		return index;
	}
	
	public String getValue(){
		return value;
	}
	
	public String toString(){
		return this.value;
	}
}
