package as2;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		double n1, n2, n3, sum, avg;
		String in, out;
		
		in = JOptionPane.showInputDialog (null, "Enter the first number");
		n1 = Double.parseDouble (in);
		in = JOptionPane.showInputDialog (null, "Enter the second number");
		n2 = Double.parseDouble (in);
		in = JOptionPane.showInputDialog (null, "Enter the third number");
		n3 = Double.parseDouble (in);
		
		sum = n1 + n2 + n3;
		avg = sum / 3;
		
		out = "You entered: " + n1 + ", " + n2 + ", " + n3 + "\nThe sum is: " + sum + "\n" + "The average is: " + avg;
		JOptionPane.showMessageDialog(null, out);
	
		System.exit(0);
	}

}
