package asLeapDay;

import javax.swing.JOptionPane;

public class TestDay {

	public static void main(String[] args) {
		int day, month;
		String in, out;
		
		in = JOptionPane.showInputDialog("Enter Day:");
		day = Integer.parseInt(in);
		
		in = JOptionPane.showInputDialog("Enter Month:");
		month = Integer.parseInt(in);
		
		Day d = new Day(day, month);
		
		out = "Day Number for " + month + "/" + day + " is " + d.findDayNum();
		JOptionPane.showMessageDialog(null, out);
		
	}

}
