package asLeapDay;

import javax.swing.JOptionPane;

public class TestLeapDay {

	public static void main(String[] args) {
		int day, month, year;
		String in, out;
		
		in = JOptionPane.showInputDialog("Enter Day:");
		day = Integer.parseInt(in);
		
		in = JOptionPane.showInputDialog("Enter Month:");
		month = Integer.parseInt(in);
		
		in = JOptionPane.showInputDialog("Enter Year:");
		year = Integer.parseInt(in);
		
		LeapDay d = new LeapDay(day, month, year);
		
		out = "Day Number for " + month + "/" + day + "/" + year + " is " + d.findDayNum();
		JOptionPane.showMessageDialog(null, out);
		
	}

}
