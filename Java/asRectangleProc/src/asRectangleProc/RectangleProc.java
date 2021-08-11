package asRectangleProc;

import javax.swing.JOptionPane;

public class RectangleProc {

	public static void main(String[] args) {
		//Call static methods computeArea and computePerim to calculate area and perimeter.
		//Display the complete output in a single message dialog box.
		String in, out;
		double len, wid;
		
		in = JOptionPane.showInputDialog(null, "Enter the length");
		len = Double.parseDouble(in);
		in = JOptionPane.showInputDialog(null, "Enter the width");
		wid = Double.parseDouble(in);
		
		out = "Length: " + len + "\nWidth: " + wid + "\nPerimeter: " + computePerim(len, wid) + "\nArea: " + computeArea(len, wid) ;
		
		JOptionPane.showMessageDialog(null, out);
		
		System.exit(0);
	}

	public static double computeArea (double len, double wid) {
		double area;
		area = len * wid;
		return area;
	}
	
	public static double computePerim (double len, double wid) {
		double perim;
		perim = (len * 2) + (wid * 2);
		return perim;
	}
}
