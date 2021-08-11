package asTickerSimple;

import java.awt.*;

import javax.swing.*;

public class Ticker extends JPanel implements Runnable{
	
	private boolean moving = false;
	private String symbol = "DVC 32.0";
	private int x = 30;
	private int y = 110;
	
	public Ticker() {
		Thread t = new Thread(this);
		t.start();
	}
	
	@Override	
	public void run() {
		while(true){
			if (moving){
				if(x < this.getWidth()) {
					x += 5;
				}
				else {
					x = -50;
				}
				repaint();
			}
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawString(symbol, x, y);
	}
	
	public void setMoving (boolean newMoving ){moving = newMoving;}

	public boolean isMoving ( ){ return moving;}
	
	
}
