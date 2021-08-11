package asRectangle;

import javax.swing.JOptionPane;


public class TestRectangle {

	public static void main(String[] args) {
		String in, out;
		double len, wid;
		
		in = JOptionPane.showInputDialog(null, "Enter the Length of the first rectangle");
		len = Double.parseDouble(in);
		in = JOptionPane.showInputDialog(null, "Enter the Width of the first rectangle");
		wid = Double.parseDouble(in);
		
		Rectangle r1 = new Rectangle(len, wid);
		
		in = JOptionPane.showInputDialog(null, "Enter the Length of the second rectangle");
		len = Double.parseDouble(in);
		in = JOptionPane.showInputDialog(null, "Enter the Width of the first rectangle");
		wid = Double.parseDouble(in);
		
		Rectangle r2 = new Rectangle(len, wid);
		
		out = "First Rectangle:\nLength: " + r1.getLength() + "\nWidth: " + r1.getWidth() + "\nArea: " + r1.computeArea() + "\nPerimeter: " + r1.computePerim();
		out = out + "\n\nSecond Rectangle:\nLength: " + r2.getLength() + "\nWidth: " + r2.getWidth() + "\nArea: " + r2.computeArea() + "\nPerimeter: " + r2.computePerim();
		
		JOptionPane.showMessageDialog(null, out);
		
		System.exit(0);
	}

}
