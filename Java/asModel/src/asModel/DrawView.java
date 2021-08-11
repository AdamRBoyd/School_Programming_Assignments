package asModel;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;
import java.awt.Color;

public class DrawView extends JPanel implements MyPropertyChangeListener, MouseListener, MouseMotionListener {

	private Model model;
	private int xSaved = 50;
	private int ySaved = 50;

	public DrawView() {
		setBackground(Color.YELLOW);
	}

	public void setModel(Model model) {
		this.model = model;
		model.addMyPropertyChangeListener(this);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
	}

	public void mousePressed(MouseEvent e) {
		xSaved = e.getX();
		ySaved = e.getY();
		repaint();
	}

	public void mouseDragged(MouseEvent e) {
		// This is the controller method
		model.setRecLength(e.getX() - xSaved);
		model.setRecWidth(e.getY() - ySaved);
	}

	public void myPropertyChange(MyPropertyChangeEvent ev) {
		repaint();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawRect(Math.min(xSaved, model.getRecLength() + xSaved), Math.min(ySaved, model.getRecWidth() + ySaved),
				Math.abs(model.getRecLength()), Math.abs(model.getRecWidth()));
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
}
