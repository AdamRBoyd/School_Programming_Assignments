package asMultithreadMessages;

import javax.swing.*;

public class Main {

	public static void main(String[] args) {
		String sx, sy, sz;
		int nx,ny,nz;
		
		sx = JOptionPane.showInputDialog("Enter Message: ");
		nx = Integer.parseInt(JOptionPane.showInputDialog("Enter Count"));
		sy = JOptionPane.showInputDialog("Enter Message: ");
		ny = Integer.parseInt(JOptionPane.showInputDialog("Enter Count"));
		sz = JOptionPane.showInputDialog("Enter Message: ");
		nz = Integer.parseInt(JOptionPane.showInputDialog("Enter Count"));
		
		Message r1 = new Message(sx,nx);
        Message r2 = new Message(sy,ny); 
        Message r3 = new Message(sz,nz);
        
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        Thread t3 = new Thread(r3);
        
        t1.start();
        t2.start();
        t3.start();
	}
}
