package asStatistics;

import java.util.Arrays;

public class Statistics {
	
	private double[] data;
	private double[] sdata;
	
	public Statistics(double[] a) {
		data = new double[a.length];
		sdata = new double[a.length];
		System.arraycopy(a, 0, data, 0, a.length);
		System.arraycopy(data, 0, sdata, 0, data.length);
		Arrays.sort(sdata);
	}
	
	public double[] getOrigData() {
		double [ ] dat = new double [ data.length ];
        System.arraycopy ( data, 0, dat, 0, data.length );
        return dat;
	}
	
	public double[] getSortedData() {
		double [ ] dat = new double [ sdata.length ];
        System.arraycopy ( sdata, 0, dat, 0, sdata.length );
        return dat;
	}
	
	public double findMin() {
		return sdata[0];
	}
	
	public double findMax() {
		return sdata[sdata.length - 1];
	}
	
	public double getMean() {
		double mean = data[0];
		for(int i = 1; i < data.length; i++) {
			mean = mean + data[i];
		}
		
		mean = mean / data.length;
		return mean;
	}
	public double getMedian() {
		int index;
		double median;
		
		if((sdata.length %2) != 0) {
			median = sdata[sdata.length / 2];
		}
		else {
			index = sdata.length / 2;
			median = (sdata[index - 1] + sdata[index]) / 2;
		}
		return median;
	}
	
}
