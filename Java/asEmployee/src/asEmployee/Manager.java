package asEmployee;

public class Manager extends Employee{
	private double pctBonus, travelExpense;
	
	public Manager(String n, double s, double b, double t) {
		super(n,s);
		pctBonus = b;
		travelExpense = t;
	}

	public double getPctBonus() {
		return pctBonus;
	}

	public double getTravelExpense() {
		return travelExpense;
	}
	
	public double computeBonus() {
		return (salary * pctBonus) + 500.00;
	}
}
