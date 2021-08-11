package asStatus;

import javax.swing.JOptionPane;

public class Rectangle implements Status {
	private double len, wid;
	
	public Rectangle(double l, double w) {
		len = l;
		wid = w;
	}
	
	public double getLength(){
		return len;
	}
	
	public double getWidth() {
		return wid;
	}
	
	public double computeArea() {
		return len * wid;
	}
	
	public double computePerim() {
		return (2 * len) + (2 * wid);
	}
	
	public String getStatus() {
		String out = "Rectangle\n";
		out += "Length = " + len + ", Width = " + wid;
		return out;
	}
	
	public void displayStatus() {
		JOptionPane.showMessageDialog(null, getStatus());
	}
}
