package asSibling;

import javax.swing.JOptionPane;

public class TestSibling {

	public static void main(String[] args) {
		
		int age, weight;
		String name, in, out;
		
		name = JOptionPane.showInputDialog(null, "Enter the first persons name");
		in = JOptionPane.showInputDialog(null, "Enter " + name + "'s age");
		age = Integer.parseInt(in);
		in = JOptionPane.showInputDialog(null, "Enter " + name + "'s weight");
		weight = Integer.parseInt(in);
		
		Sibling s1 = new Sibling(name, age, weight);
		
		name = JOptionPane.showInputDialog(null, "Enter the second persons name");
		in = JOptionPane.showInputDialog(null, "Enter " + name + "'s age");
		age = Integer.parseInt(in);
		in = JOptionPane.showInputDialog(null, "Enter " + name + "'s weight");
		weight = Integer.parseInt(in);
		
		Sibling s2 = new Sibling(name, age, weight);
		
		name = JOptionPane.showInputDialog(null, "Enter the third persons name");
		in = JOptionPane.showInputDialog(null, "Enter " + name + "'s age");
		age = Integer.parseInt(in);
		in = JOptionPane.showInputDialog(null, "Enter " + name + "'s weight");
		weight = Integer.parseInt(in);
		
		Sibling s3 = new Sibling(name, age, weight);
		
		out = "The youngest sibling: " + getYoungest(s1, s2, s3) + "\nThe Lightest sibling: " + getLightest(s1, s2, s3);
		
		JOptionPane.showMessageDialog(null, out);
		System.exit(0);
		
	}
	
	public static String getYoungest(Sibling s1, Sibling s2, Sibling s3) {
		String name;
		int age;
		
		name = s1.getName();
		age = s1.getAge();
		
		if (s2.getAge() < age) {
			age = s2.getAge();
			name = s2.getName();
		}
		if (s3.getAge() < age) {
			age = s3.getAge();
			name = s3.getName();
		}
		
		String youngest = name + " at " + age + " years old";
		return youngest;
	}
	
	public static String getLightest(Sibling s1, Sibling s2, Sibling s3) {
		String name;
		int weight;
		
		name = s1.getName();
		weight = s1.getWeight();
		
		if (s2.getWeight() < weight) {
			weight = s2.getWeight();
			name = s2.getName();
		}
		if (s3.getWeight() < weight) {
			weight = s3.getWeight();
			name = s3.getName();
		}
		
		String lightest = name + " at " + weight + "lbs.";
		return lightest;
	}

}
