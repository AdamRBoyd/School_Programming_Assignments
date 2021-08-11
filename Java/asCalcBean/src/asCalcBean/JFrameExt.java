package asCalcBean;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFrameExt extends JFrame {

	private JPanel contentPane;
	private JPanelExt panelExtLeft;
	private JPanelExt panelExtRight;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameExt frame = new JFrameExt();
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
	public JFrameExt() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel southPanel = new JPanel();
		southPanel.setBackground(Color.RED);
		contentPane.add(southPanel, BorderLayout.SOUTH);
		
		JButton calcLeft = new JButton("Calulate Left");
		calcLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double num1 = panelExtLeft.getNum1();
				double num2 = panelExtLeft.getNum2();
				String opp = panelExtLeft.getOperation();
				double result = 0;
				
				if(opp.equals("add")) {
					result = num1 + num2;
				}
				else if(opp.equals("sub")) {
					result = num1 - num2;
				}
				else if(opp.equals("mult")) {
					result = num1 *+ num2;
				}
				else if(opp.equals("div")) {
					result = num1 / num2;
				}
				else if(opp.equals("clear")) {
					panelExtLeft.setClear();
				}
				
				if(!opp.equals("clear")) {
					panelExtLeft.setResult(result);
				}
				
			}
		});
		southPanel.add(calcLeft);
		
		JButton calcClear = new JButton("Clear All");
		calcClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelExtLeft.setClear();
				panelExtRight.setClear();
			}
		});
		southPanel.add(calcClear);
		
		JButton calcRight = new JButton("Calculate Right");
		calcRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double num1 = panelExtRight.getNum1();
				double num2 = panelExtRight.getNum2();
				String opp = panelExtRight.getOperation();
				double result = 0;
				
				if(opp.equals("add")) {
					result = num1 + num2;
				}
				else if(opp.equals("sub")) {
					result = num1 - num2;
				}
				else if(opp.equals("mult")) {
					result = num1 *+ num2;
				}
				else if(opp.equals("div")) {
					result = num1 / num2;
				}
				else if(opp.equals("clear")) {
					panelExtRight.setClear();
				}
				
				if(!opp.equals("clear")) {
				panelExtRight.setResult(result);
				}
			}
		});
		southPanel.add(calcRight);
		
		JPanel centerPanel = new JPanel();
		contentPane.add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new GridLayout(1, 2, 0, 0));
		
		panelExtLeft = new JPanelExt();
		centerPanel.add(panelExtLeft);
		
		panelExtRight = new JPanelExt();
		centerPanel.add(panelExtRight);
	}

}
