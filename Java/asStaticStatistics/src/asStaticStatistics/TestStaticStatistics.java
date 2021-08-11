package asStaticStatistics;

import java.text.DecimalFormat;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

public class TestStaticStatistics {
	
public static void main(String[] args) {
		
		String in, out;
		int dnum;
		
		in = JOptionPane.showInputDialog("Enter Data <separated by commas/spaces>:");
		
		StringTokenizer st = new StringTokenizer(in, ", ");
		
		double[] data = new double[st.countTokens()];

		for(int i = 0; st.hasMoreTokens(); i++) {
			data[i] = Double.parseDouble(st.nextToken());
			
		}
		
		
		double[] sdata = new double[data.length];
		double[] sdata2 = new double[data.length];
		
		StaticStatistics d = new StaticStatistics(data);	
		System.arraycopy(d.getSortedData(), 0, sdata, 0, data.length);	
		System.arraycopy(StaticStatistics.computeSortedData(data), 0, sdata2, 0, data.length);
		
		String dec = "0.0";
		
		in = JOptionPane.showInputDialog("Enter the Number of Decimal Places to Display:");
		dnum = Integer.parseInt(in);
		
		for(int i = 0; i < dnum - 1; i++) {
			dec += "0";
		}
		
		DecimalFormat df = new DecimalFormat(dec);
		
		out = "Original Data: ";
		for(int i = 0; i < data.length; i++) {
			out = out + data[i] + " ";
		}
		
		//Instance
		out += "\n\nComputed Values Displayed To " + dnum + " Decimal Places:\n\nResults Using Instance Methods:\n\nSorted Data: ";
		for(int i = 0; i < sdata.length; i++) {
			out = out + sdata[i] + " ";
		}
		out += "\n\nMin Value: " + df.format(d.findMin()) + "\nMax Value: " + df.format(d.findMax()) 
			+ "\nMean Value: " + df.format(d.getMean()) + "\nMedian Value: " + df.format(d.getMedian());
		
		//Static
		out += "\n\n\nResults Using Static Methods:\n\nSorted Data: ";
		for(int i = 0; i < sdata2.length; i++) {
			out = out + sdata2[i] + " ";
		}
		out += "\n\nMin Value: " + df.format(StaticStatistics.computeMin(sdata2)) + "\nMax Value: " + df.format(StaticStatistics.computeMax(sdata2)) 
			+ "\nMean Value: " + df.format(StaticStatistics.computeMean(sdata2)) + "\nMedian Value: " + df.format(StaticStatistics.computeMedian(sdata2));
		
		out += "\n\nThe Total Number of Statistics objects created during execution:\n" + StaticStatistics.count;
		
		JOptionPane.showMessageDialog(null, out);
		
		System.exit(0);
		
	}

}
