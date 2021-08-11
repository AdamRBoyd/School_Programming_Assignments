package asTicker;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Main extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(4, 1, 0, 0));
		
		Ticker ticker_0 = new Ticker();
		ticker_0.setDirection(true);
		ticker_0.setBackground(Color.GREEN);
		ticker_0.setSleepTime(55L);
		ticker_0.setStockPrice(55.0);
		ticker_0.setStockName("WFB");
		contentPane.add(ticker_0);
		
		Ticker ticker_1 = new Ticker();
		ticker_1.setBackground(Color.YELLOW);
		ticker_1.setSleepTime(32L);
		ticker_1.setStockPrice(32.0);
		ticker_1.setStockName("DVC");
		contentPane.add(ticker_1);
		
		Ticker ticker_2 = new Ticker();
		ticker_2.setDirection(true);
		ticker_2.setBackground(Color.CYAN);
		ticker_2.setStockPrice(21.0);
		ticker_2.setSleepTime(21L);
		ticker_2.setStockName("BAC");
		contentPane.add(ticker_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.RED);
		contentPane.add(panel);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ticker_0.setMoving(true);
				ticker_1.setMoving(true);
				ticker_2.setMoving(true);
			}
		});
		panel.add(btnStart);
		
		JButton btnStop = new JButton("Stop");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ticker_0.setMoving(false);
				ticker_1.setMoving(false);
				ticker_2.setMoving(false);
			}
		});
		panel.add(btnStop);
	}

}
