package asStatus;

import java.util.StringTokenizer;

import javax.swing.JOptionPane;

public class TestStatus {

	public static void main(String[] args) {

		Status[] stat = new Status[6];

		double len, wid;
		int h, w, id, sc;
		String n, in, out = "";
		
		//input 3 Rectangle data
		for(int i = 0; i < 3; i++) {
			in = JOptionPane.showInputDialog("Enter Data for a Rectangle");
			StringTokenizer rTok = new StringTokenizer(in, " ");
			len = Double.parseDouble(rTok.nextToken());
			wid = Double.parseDouble(rTok.nextToken());
			stat[i] = new Rectangle(len, wid);
		}
		
		//input 2 Sibling data
		for(int i = 0; i < 2; i++) {
			in = JOptionPane.showInputDialog("Enter Data for a Sibling");
			StringTokenizer sTok = new StringTokenizer(in, " ");
			n = sTok.nextToken();
			h = Integer.parseInt(sTok.nextToken());
			w = Integer.parseInt(sTok.nextToken());
			stat[i+3] = new Sibling(n,h,w);
		}
		

		//input Student data
		in = JOptionPane.showInputDialog("Enter Data for a Student");
		StringTokenizer stTok = new StringTokenizer(in, ",");
		
		id = Integer.parseInt(stTok.nextToken());
		n = stTok.nextToken();
		sc = Integer.parseInt(stTok.nextToken());
		
		int[] scores = new int[sc];
		for(int j = 0; j < sc; j++) {
			scores[j] = Integer.parseInt(stTok.nextToken());
		}
		stat[5] = new Student(id,n,scores);
		
		for (int i = 0; i < stat.length; i++){
		     stat[i].displayStatus();
		}
		
		for (int i = 0; i < stat.length; i++){
		     out += stat[i].getStatus() + "\n\n";
		}

		JOptionPane.showMessageDialog (null, out);
		
		System.exit(0);
	}


}
