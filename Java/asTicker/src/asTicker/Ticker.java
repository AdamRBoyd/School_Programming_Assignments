package asTicker;

import java.awt.*;

import javax.swing.*;

public class Ticker extends JPanel implements Runnable{
	
	private boolean moving = false;
	private String symbol;
	private String stockName;
	private double stockPrice;
	private boolean direction;
	private long sleepTime;
	private int x = 160;
	private int y = 35;
	
	
	public Ticker() {
		Thread t = new Thread(this);
		t.start();
	}
	
	@Override	
	public void run() {
		symbol = stockName + "   " + stockPrice;
		while(true){
			if (moving){
				if(direction) {
					if(x <= this.getWidth()) {
						x += 5;
					}
					else {
						x = -50;
					}
				}
				else{
					if(x >= -50) {
						x += -5;
					}
					else {
						x = this.getWidth();
					}
				}
				repaint();
			}
			try {
				Thread.sleep(sleepTime);
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
	
	public void setMoving (boolean newMoving ){
		moving = newMoving;
	}

	public boolean isMoving ( ){
		return moving;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public double getStockPrice() {
		return stockPrice;
	}

	public void setStockPrice(double stockPrice) {
		this.stockPrice = stockPrice;
	}

	public boolean isDirection() {
		return direction;
	}

	public void setDirection(boolean direction) {
		this.direction = direction;
	}

	public long getSleepTime() {
		return sleepTime;
	}

	public void setSleepTime(long sleepTime) {
		this.sleepTime = sleepTime;
	}
}
