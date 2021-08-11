package asTickerSimple;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class JFrameExt extends JFrame {

	private JPanel contentPane;

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

	public JFrameExt() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		Ticker ticker = new Ticker();
		ticker.setBackground(Color.CYAN);
		contentPane.add(ticker, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.RED);
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JButton jbStart = new JButton("Start");
		jbStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.print("Start");
				ticker.setMoving(true);
			}
		});
		panel.add(jbStart);
		
		JButton jbStop = new JButton("Stop");
		jbStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.print("Stop");
				ticker.setMoving(false);
			}
		});
		panel.add(jbStop);
	}

}
