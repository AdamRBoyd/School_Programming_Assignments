package asException;

import javax.swing.*;

public class Main {

	public static void main(String[] args) {
		do {
			try {
				String id = JOptionPane.showInputDialog("Enter Id");
				validateId(id);
				JOptionPane.showMessageDialog(null, "Validated id: " + id + "\n");
				break;
			} catch (IdNotAWholeNumberException e) {
				System.out.println(e.getMessage());
				// e.printStackTrace();
			} catch (IdOutOfRangeException e) {
				System.out.println(e.getMessage());
				// e.printStackTrace();
			}
		} while (true);

		do {
			try {
				String name = JOptionPane.showInputDialog("Enter name");
				validateName(name);
				JOptionPane.showMessageDialog(null, "Validated Name: " + name + "\n");
				break;
			} catch (NotAlphabeticException e) {
				System.out.println(e.getMessage());
				// e.printStackTrace();
			} catch (NotSpecifiedException e) {
				System.out.println(e.getMessage());
				// e.printStackTrace();
			}
		} while (true);
	}

	private static void validateId(String id) throws IdOutOfRangeException, IdNotAWholeNumberException {
		try {
			int num = Integer.parseInt(id);
			// is an integer!
			if (num < 1 || num > 999) {
				throw new IdOutOfRangeException();
			}
		} catch (NumberFormatException e) {
			// not an integer!
			throw new IdNotAWholeNumberException();
		}
	}

	public static void validateName(String name) {
		if (name == null || name.equals("")) {
			throw new NotSpecifiedException();
		} else if (!(name.matches("[a-zA-Z]+"))) {
			throw new NotAlphabeticException();
		}
	}
}
