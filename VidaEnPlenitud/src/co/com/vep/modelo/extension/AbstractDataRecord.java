package co.com.vep.modelo.extension;

public abstract class AbstractDataRecord {

	public boolean selected;
	
	/**
	 * @return the selected
	 */
	public boolean isSelected() {
		return selected;
	}
	/**
	 * @param selected the selected to set
	 */
	public void setSelected(boolean selected) {
		this.selected = selected;
	}

}
