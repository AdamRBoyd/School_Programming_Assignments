package asTextSource;

public class NewTextEvent{
	private String newText;

	public NewTextEvent(String newText) {
		this.newText = newText;
	}

	public String getNewText() {
		return newText;
	}

	public void setNewText(String newText) {
		this.newText = newText;
	}
}
