package asStudentExt;

public class StudentExt extends Student{
		
	private String type;
	
	public StudentExt(int id, String n, int[] ex, String t) {
		super(id,n,ex);
		type = t;
	}
	
	public String findGrade ( ){

	    String grade = super.findGrade();

	    if (type.equalsIgnoreCase ("Credit")){
	    	if ((grade.equalsIgnoreCase("A")) || (grade.equalsIgnoreCase ("B")) || (grade.equalsIgnoreCase ("C"))) grade = "CR";
	    	else grade = "NCR";
	    }
	    
	    return grade;
	}
}
