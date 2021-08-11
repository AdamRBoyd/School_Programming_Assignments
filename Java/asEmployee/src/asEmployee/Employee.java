package asEmployee;

public abstract class Employee {

	private String name;
	protected double salary;
	
	public Employee(String n, double b) {
		name = n;
		salary = b;
	}
	
	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	public abstract double computeBonus();
	
}
