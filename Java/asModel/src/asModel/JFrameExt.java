package asModel;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class JFrameExt extends JFrame {

	private JPanel contentPane;
	private int xStart = 50;
	private int yStart = 50;

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

		TextView textView = new TextView(Integer.toString(xStart),Integer.toString(yStart));
		contentPane.add(textView, BorderLayout.NORTH);
		
		DrawView drawView = new DrawView();
		contentPane.add(drawView, BorderLayout.CENTER);
		
		Model mod = new Model(xStart,yStart);
		mod.addMyPropertyChangeListener(textView);
		textView.setModel(mod);
		drawView.setModel(mod);
	}

}
