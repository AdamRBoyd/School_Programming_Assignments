package asStringTokenizerStatistics;

import java.text.DecimalFormat;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

public class TestTokenizerStat {
	
	DecimalFormat df2 = new DecimalFormat("0.000");

public static void main(String[] args) {
		
		String in, out;
		int dnum;
		
		in = JOptionPane.showInputDialog("Enter Data <separated by commas/spaces>:");
		
		StringTokenizer st = new StringTokenizer(in, ", ");
		
		double[] data = new double[st.countTokens()];
		double[] sdata = new double[st.countTokens()];

		for(int i = 0; st.hasMoreTokens(); i++) {
			data[i] = Double.parseDouble(st.nextToken());
			
		}
		
		TokenizerStat d = new TokenizerStat(data);	
		System.arraycopy(d.getSortedData(), 0, sdata, 0, d.getSortedData().length);

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
		out = out + "\nSorted Data: ";
		for(int i = 0; i < sdata.length; i++) {
			out = out + sdata[i] + " ";
		}
		out = out + "\n\nComputed Values Displayed To " + dnum + " Decimal Places:\nMin Value: " + df.format(d.findMin()) + "\nMax Value: " + df.format(d.findMax()) 
			+ "\nMean Value: " + df.format(d.getMean()) + "\nMedian Value: " + df.format(d.getMedian());
		
		JOptionPane.showMessageDialog(null, out);
		
		System.exit(0);
		
	}

}
