package asException;

public class NotAlphabeticException extends RuntimeException {
	public NotAlphabeticException() {
		super("Not alphabetic");
	}
}
