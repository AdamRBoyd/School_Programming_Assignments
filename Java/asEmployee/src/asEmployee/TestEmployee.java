package asEmployee;

import java.text.DecimalFormat;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

public class TestEmployee {
	
	public static void main(String[] args) {
		String in, name, outAll, outW = "", outM = "", outE = "";
		int nw, nm, ne, nt, optionsCount;
		double salary, pctBonus, bonus, travelExpense;
		
		in = JOptionPane.showInputDialog("Enter Number of Workers");
		nw = Integer.parseInt(in);
		
		in = JOptionPane.showInputDialog("Enter Number of Managers");
		nm = Integer.parseInt(in);
		
		in = JOptionPane.showInputDialog("Enter Number of Executives");
		ne = Integer.parseInt(in);
		
		nt = nw + nm + ne;
		Employee[] emp = new Employee[nt];
		
		for(int i = 0; i < nw; i++) {
			in = JOptionPane.showInputDialog("Enter Worker Data");
			StringTokenizer tok = new StringTokenizer(in, ",");
			name = tok.nextToken().trim();
			salary = Double.parseDouble(tok.nextToken().trim());
			pctBonus = Double.parseDouble(tok.nextToken().trim());
			
			emp[i] = new Worker(name,salary,pctBonus);
		}
		
		for(int i = 0; i < nm; i++) {
			in = JOptionPane.showInputDialog("Enter Manager Data");
			StringTokenizer tok = new StringTokenizer(in, ",");
			name = tok.nextToken().trim();
			salary = Double.parseDouble(tok.nextToken().trim());
			pctBonus = Double.parseDouble(tok.nextToken().trim());
			travelExpense = Double.parseDouble(tok.nextToken().trim());
			
			emp[i + nw] = new Manager(name,salary,pctBonus,travelExpense);
		}

		for(int i = 0; i < ne; i++) {
			in = JOptionPane.showInputDialog("Enter Executive Data");
			StringTokenizer tok = new StringTokenizer(in, ",");
			name = tok.nextToken().trim();
			salary = Double.parseDouble(tok.nextToken().trim());
			pctBonus = Double.parseDouble(tok.nextToken().trim());
			travelExpense = Double.parseDouble(tok.nextToken().trim());
			optionsCount = Integer.parseInt(tok.nextToken().trim());
			
			emp[i + nw + nm] = new Executive(name,salary,pctBonus,travelExpense,optionsCount);
		}
		
		DecimalFormat df = new DecimalFormat("0.00");
		
		for(int i = 0; i < nt; i++) {
			name = emp[i].getName();
			salary = emp[i].getSalary();
			bonus = emp[i].computeBonus();
			
			if(emp[i] instanceof Worker) {
				pctBonus = ((Worker) emp[i]).getPctBonus();
				outW += "Name: " + name + "\nSalary: " + df.format(salary) + "\nPercent Bonus: " + df.format(pctBonus) + "\nTotal Bonus: " + df.format(bonus) + "\n\n";
			}
			else if(emp[i] instanceof Manager) {
				pctBonus = ((Manager) emp[i]).getPctBonus();
				travelExpense = ((Manager) emp[i]).getTravelExpense();
				outM += "Name: " + name 
						+ "\nSalary: " + df.format(salary) 
						+ "\nPercent Bonus: " + df.format(pctBonus) 
						+ "\nTotal Bonus: " + df.format(bonus) 
						+ "\nTravel Expense: " + df.format(travelExpense) + "\n\n";
			}
			else if(emp[i] instanceof Executive) {
				pctBonus = ((Executive) emp[i]).getPctBonus();
				travelExpense = ((Executive) emp[i]).getTravelExpense();
				optionsCount = ((Executive) emp[i]).getOptionsCount();
				outE += "Name: " + name 
						+ "\nSalary: " + df.format(salary) 
						+ "\nPercent Bonus: " + df.format(pctBonus) 
						+ "\nTotal Bonus: " + df.format(bonus) 
						+ "\nTravel Expense: " + df.format(travelExpense) 
						+ "\nOptions Count: " + optionsCount + "\n\n";
			}
		}
		outAll = outW + outM + outE;
		
		JOptionPane.showMessageDialog(null, outAll);
		
		System.exit(0);
	}

}
