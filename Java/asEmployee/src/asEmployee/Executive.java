package asEmployee;

public class Executive extends Employee{
	private double pctBonus, travelExpense;
	int optionsCount;
	
	public Executive(String n, double s, double b, double t, int opt) {
		super(n,s);
		pctBonus = b;
		travelExpense = t;
		optionsCount = opt;
	}

	public double getPctBonus() {
		return pctBonus;
	}

	public double getTravelExpense() {
		return travelExpense;
	}

	public int getOptionsCount() {
		return optionsCount;
	}
	
	public double computeBonus() {
		return (salary * pctBonus) + 1000.00;
	}
	
}
