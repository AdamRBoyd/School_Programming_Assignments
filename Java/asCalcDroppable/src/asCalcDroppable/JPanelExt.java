package asCalcDroppable;

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
	private JTextField jtfNum1;
	private JTextField jtfNum2;
	private JTextField jtfSum;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final Action action = new SwingAction();

	public JPanelExt() {
		setLayout(new GridLayout(4, 1, 0, 0));
		
		JPanel panel_0 = new JPanel();
		panel_0.setBackground(Color.CYAN);
		add(panel_0);
		panel_0.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblFirstNumber = new JLabel("1st Number: ");
		panel_0.add(lblFirstNumber);
		
		jtfNum1 = new JTextField();
		panel_0.add(jtfNum1);
		jtfNum1.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.CYAN);
		add(panel_1);
		
		JLabel lblSecondNumber = new JLabel("2nd Number: ");
		panel_1.add(lblSecondNumber);
		
		jtfNum2 = new JTextField();
		panel_1.add(jtfNum2);
		jtfNum2.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.GREEN);
		add(panel_2);
		
		JLabel lblResults = new JLabel("Results: ");
		panel_2.add(lblResults);
		
		jtfSum = new JTextField();
		panel_2.add(jtfSum);
		jtfSum.setColumns(12);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.RED);
		add(panel_3);
		panel_3.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panel_3_0 = new JPanel();
		panel_3_0.setBackground(Color.RED);
		panel_3.add(panel_3_0);
		
		JRadioButton jrbAdd = new JRadioButton("+");
		jrbAdd.setSelected(true);
		buttonGroup.add(jrbAdd);
		jrbAdd.setBackground(Color.RED);
		panel_3_0.add(jrbAdd);
		
		JRadioButton jrbSub = new JRadioButton("-");
		buttonGroup.add(jrbSub);
		jrbSub.setBackground(Color.RED);
		panel_3_0.add(jrbSub);
		
		JRadioButton jrbMul = new JRadioButton("*");
		buttonGroup.add(jrbMul);
		jrbMul.setBackground(Color.RED);
		panel_3_0.add(jrbMul);
		
		JRadioButton jrbDiv = new JRadioButton("/");
		buttonGroup.add(jrbDiv);
		jrbDiv.setBackground(Color.RED);
		panel_3_0.add(jrbDiv);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBackground(Color.BLUE);
		panel_3.add(panel_3_1);
		
		JButton jbCalc = new JButton("Calculate");
		jbCalc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				double num1 = Double.parseDouble(jtfNum1.getText().trim());
				double num2 = Double.parseDouble(jtfNum2.getText().trim());

				if(jrbAdd.isSelected()) {
					jtfSum.setText("" + (num1 + num2));
				}
				else if(jrbSub.isSelected()) {
					jtfSum.setText("" + (num1 - num2));
				}
				else if(jrbMul.isSelected()) {
					jtfSum.setText("" + (num1 * num2));
				}
				else if(jrbDiv.isSelected()) {
					jtfSum.setText("" + (num1 / num2));
				}
			}
		});
		panel_3_1.add(jbCalc);
		
		JButton jbClr = new JButton("Clear");
		jbClr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jtfNum1.setText("");
				jtfNum2.setText("");
				jtfSum.setText("");
			}
		});
		panel_3_1.add(jbClr);

	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
