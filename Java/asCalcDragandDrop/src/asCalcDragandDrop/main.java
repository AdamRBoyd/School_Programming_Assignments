package asCalcDragandDrop;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class main extends JFrame {

	private JPanel contentPane;
	private JTextField jtfNum1;
	private JTextField jtfNum2;
	private JTextField jtfSum;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main frame = new main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 322, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(4, 1, 0, 0));
		
		JPanel panel_0 = new JPanel();
		panel_0.setBackground(Color.CYAN);
		contentPane.add(panel_0);
		
		JLabel lblNum = new JLabel("First Number: ");
		panel_0.add(lblNum);
		
		jtfNum1 = new JTextField();
		panel_0.add(jtfNum1);
		jtfNum1.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.CYAN);
		contentPane.add(panel_1);
		
		JLabel lblNum_1 = new JLabel("Second Number: ");
		panel_1.add(lblNum_1);
		
		jtfNum2 = new JTextField();
		panel_1.add(jtfNum2);
		jtfNum2.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.GREEN);
		contentPane.add(panel_2);
		
		JLabel lblSum = new JLabel("Results: ");
		panel_2.add(lblSum);
		
		jtfSum = new JTextField();
		panel_2.add(jtfSum);
		jtfSum.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		panel_3.setBackground(Color.RED);
		contentPane.add(panel_3);
		
		JButton jtfAdd = new JButton("+");
		jtfAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sNum1 = jtfNum1.getText().trim();
				String sNum2 = jtfNum2.getText().trim();
				Double dNum1 = Double.parseDouble(sNum1);
				Double dNum2 = Double.parseDouble(sNum2);
				Double dSum = dNum1 + dNum2;
				jtfSum.setText("" + dSum);
			}
		});
		panel_3.add(jtfAdd);
		
		JButton jtfSub = new JButton("-");
		jtfSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sNum1 = jtfNum1.getText().trim();
				String sNum2 = jtfNum2.getText().trim();
				Double dNum1 = Double.parseDouble(sNum1);
				Double dNum2 = Double.parseDouble(sNum2);
				Double dSum = dNum1 - dNum2;
				jtfSum.setText("" + dSum);
			}
		});
		panel_3.add(jtfSub);
		
		JButton jtfMul = new JButton("*");
		jtfMul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sNum1 = jtfNum1.getText().trim();
				String sNum2 = jtfNum2.getText().trim();
				Double dNum1 = Double.parseDouble(sNum1);
				Double dNum2 = Double.parseDouble(sNum2);
				Double dSum = dNum1 * dNum2;
				jtfSum.setText("" + dSum);
			}
		});
		panel_3.add(jtfMul);
		
		JButton jtfDiv = new JButton("/");
		jtfDiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sNum1 = jtfNum1.getText().trim();
				String sNum2 = jtfNum2.getText().trim();
				Double dNum1 = Double.parseDouble(sNum1);
				Double dNum2 = Double.parseDouble(sNum2);
				Double dSum = dNum1 /+ dNum2;
				jtfSum.setText("" + dSum);
			}
		});
		panel_3.add(jtfDiv);
		
		JButton jtfClr = new JButton("Clear");
		jtfClr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jtfNum1.setText("");
				jtfNum2.setText("");
				jtfSum.setText("");
			}
		});
		panel_3.add(jtfClr);
	}

}
