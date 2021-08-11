package asSibling;

public class Sibling {

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
	
}
