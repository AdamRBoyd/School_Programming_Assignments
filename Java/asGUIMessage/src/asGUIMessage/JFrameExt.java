package asGUIMessage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JFrameExt extends JFrame implements ActionListener{
	private JTextField jtfMessage = new JTextField (10);
	private JButton jbtClickMe = new JButton ("Click Me");
	private JButton jbtClickMeToo = new JButton ("Click Me Too");
	private JPanel jpMain = new JPanel( );
	private int count = 0;
	
	public JFrameExt(){
		super ( );
	
		FlowLayout fl = new FlowLayout();
		jpMain.setLayout(fl);
		this.setContentPane (jpMain);
	
		jpMain.add(jbtClickMe);
		jpMain.add(jtfMessage);
		jpMain.add(jbtClickMeToo);
	
		jtfMessage.setEditable (false);
	
		jbtClickMe.addActionListener(this);
		jbtClickMeToo.addActionListener(this);
	}
	
	 public void actionPerformed (ActionEvent e){
		 if (e.getSource ( ) == jbtClickMe){
			 count++;
			 jtfMessage.setText("Hello " + count);
		 }
		 else if(e.getSource ( ) == jbtClickMeToo) {
			 count--;
			 jtfMessage.setText("Hello " + count);
		 }
	 }
}
