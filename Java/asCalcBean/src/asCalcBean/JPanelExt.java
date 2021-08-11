package asCalcBean;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.CardLayout;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;

public class JPanelExt extends JPanel {
	private double num1;
	private double num2;
	private String operation;
	private double result;
	private boolean clear;	
	
	private JTextField jtfNum1;
	private JTextField jtfNum2;
	private JTextField jtfRes;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton jrbAdd;
	private JRadioButton jrbSub;
	private JRadioButton jrbMult;
	private JRadioButton jrbDiv;
	private JRadioButton jrbClr;

	public JPanelExt() {
		setLayout(new GridLayout(4, 1, 0, 0));
		
		JPanel panel_0 = new JPanel();
		panel_0.setBackground(Color.CYAN);
		add(panel_0);
		panel_0.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblFirstNumber = new JLabel("Num 1:");
		panel_0.add(lblFirstNumber);
		
		jtfNum1 = new JTextField();
		panel_0.add(jtfNum1);
		jtfNum1.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.CYAN);
		add(panel_1);
		
		JLabel lblSecondNumber = new JLabel("Num 2:");
		panel_1.add(lblSecondNumber);
		
		jtfNum2 = new JTextField();
		panel_1.add(jtfNum2);
		jtfNum2.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.GREEN);
		add(panel_2);
		
		JLabel lblResults = new JLabel("Results: ");
		panel_2.add(lblResults);
		
		jtfRes = new JTextField();
		panel_2.add(jtfRes);
		jtfRes.setColumns(12);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.BLUE);
		add(panel_3);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		jrbAdd = new JRadioButton("+");
		panel_3.add(jrbAdd);
		jrbAdd.setSelected(true);
		buttonGroup.add(jrbAdd);
		jrbAdd.setBackground(Color.BLUE);
		
		jrbSub = new JRadioButton("-");
		panel_3.add(jrbSub);
		buttonGroup.add(jrbSub);
		jrbSub.setBackground(Color.BLUE);
		
		jrbMult = new JRadioButton("*");
		panel_3.add(jrbMult);
		buttonGroup.add(jrbMult);
		jrbMult.setBackground(Color.BLUE);
		
		jrbDiv = new JRadioButton("/");
		panel_3.add(jrbDiv);
		buttonGroup.add(jrbDiv);
		jrbDiv.setBackground(Color.BLUE);
		
		jrbClr = new JRadioButton("Clear");
		jrbClr.setBackground(Color.BLUE);
		buttonGroup.add(jrbClr);
		panel_3.add(jrbClr);	
		
	}

	public double getNum1() {
		String snum1 = jtfNum1.getText().trim();
		num1 = Double.parseDouble(snum1);
		return num1;
	}

	public void setNum1(double num1) {
		this.num1 = num1;
		jtfNum1.setText("" + num1);
	}

	public double getNum2() {
		String snum2 = jtfNum2.getText().trim();
		num2 = Double.parseDouble(snum2);
		return num2;
	}

	public void setNum2(double num2) {
		this.num2 = num2;
		jtfNum2.setText("" + num2);
	}

	public double getResult() {
		return 0;
	}

	public void setResult(double result) {
		this.result = result;
		jtfRes.setText("" + result);
	}

	public String getOperation() {
		if(jrbAdd.isSelected()) {return "add";}
		else if(jrbSub.isSelected()) {return "sub";}
		else if(jrbMult.isSelected()) {return "mult";}
		else if(jrbDiv.isSelected()) {return "div";}
		else if(jrbClr.isSelected()) {return "clear";}
		
		return "Something Went Wrong!";
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public boolean isClear() {
		return false;
	}

	public void setClear() {
		jtfNum1.setText("");
		jtfNum2.setText("");
		jtfRes.setText("");
	}
}
