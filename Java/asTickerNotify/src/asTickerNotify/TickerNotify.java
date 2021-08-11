package asTickerNotify;

import java.awt.*;

import javax.swing.*;

public class TickerNotify extends JPanel implements Runnable {

	private boolean moving = false;
	private String symbol = "DVC 32.0";
	private int x = 30;
	private int y = 110;

	public TickerNotify() {
		Thread t = new Thread(this);
		t.start();
	}

	@Override
	public void run() {
		while (true) {
			myRun();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public synchronized void myRun() {
		if (!moving) {
			try {
				wait();
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		} else {
			if (x < this.getWidth()) {
				x += 5;
			} else {
				x = -50;
			}
			this.repaint();
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawString(symbol, x, y);
	}

	public synchronized void setMoving(boolean moving) {
		this.moving = moving;
		notify();
	}

	public boolean isMoving() {
		return moving;
	}

}
