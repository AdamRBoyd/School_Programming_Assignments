package asCalculator;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JFrameExt extends JFrame implements ActionListener{
	private JPanel jpMain = new JPanel();
	private JPanel jpNum1 = new JPanel();
	private JPanel jpNum2 = new JPanel();
	private JPanel jpOut = new JPanel();
	private JPanel jpOption = new JPanel();
	private JLabel jlbNum1 = new JLabel("Num 1:  ");
	private JLabel jlbNum2 = new JLabel("Num 2:  ");
	private JLabel jlbOut = new JLabel ("Total  ");
	private JTextField jtfNum1 = new JTextField(10);
	private JTextField jtfNum2 = new JTextField(10);
	private JTextField jtfOut = new JTextField(10);
	private JButton jbtAdd = new JButton(" + ");
	private JButton jbtSub = new JButton(" - ");
	private JButton jbtMult = new JButton(" * ");
	private JButton jbtDiv = new JButton(" / ");
	private JButton jbtCl = new JButton(" CLR ");
	
	public JFrameExt() {
		setTitle ("Calculator");
		setSize(300, 300);
		setVisible(true);
		
		//set jpMain layout
		GridLayout gl = new GridLayout(4,1);
		jpMain.setLayout(gl);
		
		//add panels to jpMain
		jpMain.add(jpNum1);
		jpMain.add(jpNum2);
		jpMain.add(jpOut);
		jpMain.add(jpOption);
		jpNum1.setBackground(Color.cyan);
		jpNum2.setBackground(Color.cyan);
		jpOut.setBackground(Color.green);
		jpOption.setBackground(Color.red);
		
		//Make jpMain as the content pane
		this.setContentPane(jpMain);
		
		//add objects
		jpNum1.add(jlbNum1);
		jpNum1.add(jtfNum1);
		jpNum2.add(jlbNum2);
		jpNum2.add(jtfNum2);
		jpOut.add(jlbOut);
		jpOut.add(jtfOut);
		jtfOut.setEditable(false);
		jpOption.add(jbtAdd);
		jpOption.add(jbtSub);
		jpOption.add(jbtMult);
		jpOption.add(jbtDiv);
		jpOption.add(jbtCl);
		
		
		//register this object as a listener with buttons
		jbtAdd.addActionListener(this);
		jbtSub.addActionListener(this);
		jbtMult.addActionListener(this);
		jbtDiv.addActionListener(this);
		jbtCl.addActionListener(this);
		
	}
	
	//Listener method
	public void actionPerformed(ActionEvent ev) {
		String sNum1,sNum2, sOut;
		double dNum1, dNum2, dOut;
		sNum1 = jtfNum1.getText().trim();
		sNum2 = jtfNum2.getText().trim();
		dNum1 = Double.parseDouble(sNum1);
		dNum2 = Double.parseDouble(sNum2);
		
		if (ev.getSource()==jbtAdd){
			dOut = dNum1 + dNum2;
			sOut = "" + dOut;
			jtfOut.setText(sOut);
		}
		else if (ev.getSource()==jbtSub){
			dOut = dNum1 - dNum2;
			sOut = "" + dOut;
			jtfOut.setText(sOut);
		}
		else if (ev.getSource()==jbtMult){
			dOut = dNum1 * dNum2;
			sOut = "" + dOut;
			jtfOut.setText(sOut);
		}
		else if (ev.getSource()==jbtDiv){
			dOut = dNum1 / dNum2;
			sOut = "" + dOut;
			jtfOut.setText(sOut);
		}
		else if (ev.getSource()==jbtCl){
			jtfNum1.setText("");
			jtfNum2.setText("");
			jtfOut.setText("");
		}
	 }

}


















