package asStudent;

import java.util.StringTokenizer;

import javax.swing.JOptionPane;

public class TestStudent {

	public static void main(String[] args) {

		String in, name, grade;
		int numStudent, id, exams;		
				
		in = JOptionPane.showInputDialog("Enter number of students");
		numStudent = Integer.parseInt(in);
		
		Student[] st = new Student[numStudent];
		
		for(int i = 0; i < st.length; i++) {
			in = JOptionPane.showInputDialog("Enter data for one student");
			StringTokenizer tok = new StringTokenizer(in, ",");
			
			id = Integer.parseInt(tok.nextToken());
			name = tok.nextToken();
			exams = Integer.parseInt(tok.nextToken());
			
			int[] scores = new int[exams];
			for(int j = 0; j < exams; j++) {
				scores[j] = Integer.parseInt(tok.nextToken());
			}
			
			st[i] = new Student(id,name,scores);			
		}
		
		String[] out = new String[] {"","","","",""};
		
		for(int i = 0; i < st.length; i++) {
			grade = st[i].findGrade();
			if (grade.equalsIgnoreCase("A")){
				out[0] += st[i].getId() + " " + st[i].getName() + " (A)\n";
		      }
		      else if (grade.equalsIgnoreCase("B")){
		    	out[1] += st[i].getId() + " " + st[i].getName() + " (B)\n";
		      }
		      else if (grade.equalsIgnoreCase("C")){
		    	out[2] += st[i].getId() + " " + st[i].getName() + " (C)\n";
		      }
		      else if (grade.equalsIgnoreCase("D")){
		    	out[3] += st[i].getId() + " " + st[i].getName() + " (D)\n";
		      }
		      else{
		    	out[4] += st[i].getId() + " " + st[i].getName() + " (F)\n";
		      }

		    }
		
			displayResult(out);
			
			System.exit(0);

	}	
	
	public static void displayResult(String[] s){
		String outAll = "";
		for (int i = 0; i < s.length; i++){
	      outAll = outAll + s[i];
	    }

	    JOptionPane.showMessageDialog(null, outAll);

	}
	
}
