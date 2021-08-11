package asEmployee;

public class Worker extends Employee{
	private double pctBonus;
	
	public Worker(String n, double s, double b) {
		super(n,s);
		pctBonus = b;
	}

	public double getPctBonus() {
		return pctBonus;
	}
	
	public double computeBonus() {
		return salary * pctBonus;
	}
}
