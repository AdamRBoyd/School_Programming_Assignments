package asStudentExtFileIO;

import java.io.*;
import java.util.StringTokenizer;

import asStudentExtFileIO.StudentExt;

public class TestStudentExtFileIO {

	public static void main(String[] args)throws Exception {

		String in, outAll, name, grade, type;
	    int studentCount, id, exams;

	    BufferedReader br = new BufferedReader(new FileReader("in.txt"));

	    PrintWriter pw = new PrintWriter (new FileWriter("out.txt"));

	    in = br.readLine();
	    studentCount = Integer.parseInt(in);
	    
	    StudentExt[] st = new StudentExt[studentCount];

	    outAll = "Student report:\n";

	    for (int i=0; i<studentCount; i++){
	    	in = br.readLine();
	    	
	    	StringTokenizer tok = new StringTokenizer(in, ",");
			
			id = Integer.parseInt(tok.nextToken().trim());
			name = tok.nextToken().trim();
			exams = Integer.parseInt(tok.nextToken().trim());
			
			int[] scores = new int[exams];
			for(int j = 0; j < exams; j++) {
				scores[j] = Integer.parseInt(tok.nextToken().trim());
			}
			
			type = tok.nextToken().trim();
			
			st[i] = new StudentExt(id,name,scores,type);
		}

	    String[] out = new String[] {"","","","","","",""};
		
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
		      else if (grade.equalsIgnoreCase("F")){
		    	out[4] += st[i].getId() + " " + st[i].getName() + " (F)\n";
		      }
		      else if (grade.equalsIgnoreCase("CR")){
		    	out[5] += st[i].getId() + " " + st[i].getName() + " (CR)\n";
		      }
		      else {
		    	out[6] += st[i].getId() + " " + st[i].getName() + " (NCR)\n";
		      }

		    }
		
		for (int i = 0; i < out.length; i++){
		      outAll += out[i];
		    }

	    pw.println(outAll);
	    pw.flush();

	    if (br != null) br.close();
	    if (pw != null) pw.close();
	    System.exit(0);
	  }
}