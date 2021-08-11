package asRectangle;

public class Rectangle {
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
;}
