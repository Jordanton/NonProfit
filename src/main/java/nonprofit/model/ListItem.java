package nonprofit.model;

public class ListItem implements Comparable<ListItem> {
	private String label;
	private String value;
	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}
	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}
	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
	
	public int compareTo(ListItem o) {
		// TODO Auto-generated method stub
		return this.getLabel().compareTo(o.getLabel());
	}

}
