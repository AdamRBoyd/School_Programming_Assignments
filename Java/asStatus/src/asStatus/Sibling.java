package asStatus;

import javax.swing.JOptionPane;

public class Sibling implements Status{

	private int age, weight;
	private String name;
	
	public Sibling(String n, int a, int w) {
		name = n;
		age = a;
		weight = w;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public String getStatus() {
		String out = "Sibling\n";
		out += "Name = " + name + ", Age = " + age + ", Weight = " + weight;
		return out;
	}
	
	public void displayStatus() {
		JOptionPane.showMessageDialog(null, getStatus());
	}
	
}
