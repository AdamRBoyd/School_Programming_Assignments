package Final;

import java.beans.PropertyEditorSupport;

public class StringEditor extends PropertyEditorSupport {

	private String myString = "Hello";

	public StringEditor() {

	}

	public String[] getTags() {
		return null;
	}

	public void setAsText(String value) {
				myString = value;
	}

	public String getAsText() {
		return myString;
	}
}
