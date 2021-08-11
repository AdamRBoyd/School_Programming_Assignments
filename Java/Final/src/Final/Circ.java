package Final;

import javax.swing.*;
import java.awt.*;

public class Circ extends JPanel {
	private int myXStart = 20;
	private int myYStart = 20;
	private boolean myFill = true;
	private int myWidth = 50;
	private int myHeight = 50;
	private String myForeColor = "Green";
	private String myBackColor = "Blue";

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (myBackColor.equalsIgnoreCase("Green")) {
			this.setBackground(Color.green);
		} else if (myBackColor.equalsIgnoreCase("Blue")) {
			this.setBackground(Color.blue);
		} else if (myBackColor.equalsIgnoreCase("Yellow")) {
			this.setBackground(Color.yellow);
		} else if (myBackColor.equalsIgnoreCase("Red")) {
			this.setBackground(Color.red);
		}

		if (myForeColor.equalsIgnoreCase("Green")) {
			g.setColor(Color.green);
		} else if (myForeColor.equalsIgnoreCase("Blue")) {
			g.setColor(Color.blue);
		} else if (myForeColor.equalsIgnoreCase("Yellow")) {
			g.setColor(Color.yellow);
		} else if (myForeColor.equalsIgnoreCase("Red")) {
			g.setColor(Color.red);
		}

		if (myFill) {
			g.fillOval(myXStart, myYStart, myWidth, myHeight);
		} else {
			g.drawOval(myXStart, myYStart, myWidth, myHeight);
		}
	}

	public int getMyXStart() {
		return myXStart;
	}

	public void setMyXStart(int myXStart) {
		this.myXStart = myXStart;
		repaint();
	}

	public void setMyYStart(int myYStart) {
		this.myYStart = myYStart;
		repaint();
	}

	public int getMyYStart() {
		return myYStart;
	}

	public void setMyFill(boolean myFill) {
		this.myFill = myFill;
		repaint();
	}

	public boolean getMyFill() {
		return myFill;
	}

	public void setMyWidth(int myWidth) {
		this.myWidth = myWidth;
		repaint();
	}

	public int getMyWidth() {
		return myWidth;
	}

	public void setMyHeight(int myHeight) {
		this.myHeight = myHeight;
		repaint();
	}

	public int getMyHeight() {
		return myHeight;
	}

	public void setMyForeColor(String myForeColor) {
		this.myForeColor = myForeColor;
		repaint();
	}

	public String getMyForeColor() {
		return myForeColor;
	}

	public void setMyBackColor(String myBackColor) {
		this.myBackColor = myBackColor;
		repaint();
	}

	public String getMyBackColor() {
		return myBackColor;
	}
}


