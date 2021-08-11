package Final;

import java.beans.PropertyEditorSupport;

public class ColorEditor extends PropertyEditorSupport {

	private String colorString;
	private String[] tags = { "Red", "Green", "Yellow", "Blue", "Black"};
	private String[] validColors = {"Red", "Green", "Yellow", "Blue"};
	
	/*private String[] tags = { "red", "green", "yellow", "blue"
			, "black", "cyan", "orange", "gray", "magenta" };
	private String[] validColors = { "red", "green", "yellow", "blue" };*/

	public ColorEditor() {
		colorString = "";
	}

	public String[] getTags() {
		return (String[]) tags.clone();
	}

	public void setAsText(String value) {
		boolean validString = false;
		
		for (int i = 0; i < validColors.length; i++) {
			if (value.equals(validColors[i])) {
				colorString = value;
				validString = true;
				break;
			}
		}

		if (!validString) {
			throw new IllegalArgumentException(value);
		}
	}

	public String getAsText() {
		return colorString;
	}
}
