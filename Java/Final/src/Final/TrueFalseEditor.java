package Final;

import java.beans.PropertyEditorSupport;

public class TrueFalseEditor extends PropertyEditorSupport {
	private boolean propertyValue = true;
	private String[] tags = {"True", "False"};

	public TrueFalseEditor() {

	}

	public String[] getTags() {
		//return null;
		return (String[]) tags.clone();
	}

	public void setAsText(String value) {
		propertyValue = new Boolean(value).booleanValue();
	}

	public String getAsText() {
		return new Boolean(propertyValue).toString();
	}

}
