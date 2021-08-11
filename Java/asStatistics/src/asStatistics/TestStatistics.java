package asStatistics;

import java.text.DecimalFormat;

import javax.swing.JOptionPane;

public class TestStatistics {

	public static void main(String[] args) {
		
		String in, out;
		
		in = JOptionPane.showInputDialog("Enter the Number Of Data Values: ");
		double[] data = new double[Integer.parseInt(in)];
		double[] sdata = new double[Integer.parseInt(in)];
		
		for(int i = 0; i < data.length; i++) {
			in = JOptionPane.showInputDialog("Enter Data Value: ");
			data[i] = Double.parseDouble(in);
		}
		
		Statistics d = new Statistics(data);	
		System.arraycopy(d.getSortedData(), 0, sdata, 0, d.getSortedData().length);


		out = "Original Data:\n";
		for(int i = 0; i < data.length; i++) {
			out = out + data[i] + " ";
		}
		out = out + "\nSorted Data:\n";
		for(int i = 0; i < sdata.length; i++) {
			out = out + sdata[i] + " ";
		}
		out = out + "\nMin Value: " + d.findMin() + "\nMax Value: " + d.findMax() 
			+ "\nMean Value: " + String.format("%.2f", d.getMean()) + "\nMedian Value: " + d.getMedian();
		
		JOptionPane.showMessageDialog(null, out);
		
		System.exit(0);
		
	}

}
