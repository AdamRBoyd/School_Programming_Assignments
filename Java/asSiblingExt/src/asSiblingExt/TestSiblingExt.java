package asSiblingExt;

import java.util.StringTokenizer;

import javax.swing.JOptionPane;

import asSiblingExt.SiblingExt;

public class TestSiblingExt {

public static void main(String[] args) {
		
		int age, weight, height;
		String name, in, out;
		
		in = JOptionPane.showInputDialog(null, "Enter the first persons info (separated by spaces)");
		StringTokenizer tok = new StringTokenizer(in, " ");
		name = tok.nextToken();
		age = Integer.parseInt(tok.nextToken());
		weight = Integer.parseInt(tok.nextToken());
		height = Integer.parseInt(tok.nextToken());
		
		SiblingExt s1 = new SiblingExt(name, age, weight, height);
		
		in = JOptionPane.showInputDialog(null, "Enter the second persons info (separated by spaces)");
		StringTokenizer tok2 = new StringTokenizer(in, " ");
		name = tok2.nextToken();
		age = Integer.parseInt(tok2.nextToken());
		weight = Integer.parseInt(tok2.nextToken());
		height = Integer.parseInt(tok2.nextToken());
		
		SiblingExt s2 = new SiblingExt(name, age, weight, height);
		
		in = JOptionPane.showInputDialog(null, "Enter the third persons info (separated by spaces)");
		StringTokenizer tok3 = new StringTokenizer(in, " ");
		name = tok3.nextToken();
		age = Integer.parseInt(tok3.nextToken());
		weight = Integer.parseInt(tok3.nextToken());
		height = Integer.parseInt(tok3.nextToken());
		
		SiblingExt s3 = new SiblingExt(name, age, weight, height);
		
		out = "The Lightest Sibling: " + getLightest(s1, s2, s3) 
		+ "\nThe Youngest Sibling: " + getYoungest(s1, s2, s3) 
		+ "\nThe Tallest Sibling: " + getTallest(s1, s2, s3);
		
		JOptionPane.showMessageDialog(null, out);
		System.exit(0);
		
	}
	
	public static String getYoungest(SiblingExt s1, SiblingExt s2, SiblingExt s3) {
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
	
	public static String getLightest(SiblingExt s1, SiblingExt s2, SiblingExt s3) {
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
		
		String lightest = name + " at " + weight + " lbs.";
		return lightest;
	}
	
	public static String getTallest(SiblingExt s1, SiblingExt s2, SiblingExt s3) {
		String name;
		int height;
		
		name = s1.getName();
		height = s1.getHeight();
		
		if (s2.getWeight() > height) {
			height = s2.getHeight();
			name = s2.getName();
		}
		if (s3.getWeight() > height) {
			height = s3.getHeight();
			name = s3.getName();
		}
		
		String tallest = name + " at " + height + " inches.";
		return tallest;
	}

}
