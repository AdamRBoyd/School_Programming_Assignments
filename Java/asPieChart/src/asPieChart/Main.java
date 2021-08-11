package asPieChart;

import java.awt.Color;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		double n,s,e,w,mw;
		String in;
		in = JOptionPane.showInputDialog("Enter the sales totals (N,S,E,W,MW): ");
		StringTokenizer tok = new StringTokenizer(in, ",");
		n = Double.parseDouble(tok.nextToken().trim());
		s = Double.parseDouble(tok.nextToken().trim());
		e = Double.parseDouble(tok.nextToken().trim());
		w = Double.parseDouble(tok.nextToken().trim());
		mw = Double.parseDouble(tok.nextToken().trim());
		
		JFrameExt f = new JFrameExt(n,s,e,w,mw);
		f.setSize(500,650);
		f.setVisible(true);
		f.getContentPane().setBackground(Color.black);

	}

}
