package asDraw;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JFrameExt extends JFrame implements ActionListener{
	
	private JPanel jpMain = new JPanel();
	private JButton jbtHappy = new JButton ("Happy");
	private JButton jbtSad = new JButton ("Sad");
	private JButton jbtPicture = new JButton ("Picture");
	JPanelExt jpe = new JPanelExt();
	JPanel jp = new JPanel();

	public JFrameExt() {
		super();
		BorderLayout bl = new BorderLayout();
		jpMain.setLayout(bl);
		this.setContentPane (jpMain);
		
		
		jpMain.add(jpe, BorderLayout.CENTER);
		jpMain.add(jp, BorderLayout.SOUTH);
		
		jp.add(jbtHappy);
		jp.add(jbtSad);
		jp.add(jbtPicture);
		
		jbtHappy.addActionListener(this);
		jbtSad.addActionListener(this);
		jbtPicture.addActionListener(this);
		
		jpe.setBackground(Color.BLACK);
		jp.setBackground(Color.BLACK);
		
	}

	public void actionPerformed (ActionEvent e){
		 if (e.getSource ( ) == jbtHappy){
			 jpe.setPictureType("Happy");
		 }
		 else if(e.getSource ( ) == jbtSad){
			 jpe.setPictureType("Sad");
		 }
		 else if(e.getSource ( ) == jbtPicture){
			 jpe.setImg();
			 jpe.setPictureType("Picture");
		 }
	 }


}
