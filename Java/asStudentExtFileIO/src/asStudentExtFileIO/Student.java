package asStudentExtFileIO;

public class Student {
	
	private String name;
	private int[] exams;
	private int id;
	
	public Student(int id, String n, int[] ex) {
		this.id = id;
		name = n;
		exams = new int[ex.length];
		System.arraycopy(ex, 0, exams, 0, ex.length);
	}

	public String findGrade() {
		int numGrade = exams[0];
		String grade;
		int size = exams.length;
		
		for(int i = 1; i < exams.length; i++) {
			numGrade += exams[i];
		}
		
		numGrade = (numGrade/size);

		if(numGrade >= 90) grade = "A";
		else if (numGrade >= 80) grade = "B";
		else if (numGrade >= 70) grade = "C";
		else if (numGrade >= 60) grade = "D";
		else grade = "F";
		
		return grade;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
}
