package asDraw;

import java.awt.*;
import java.net.*;
import javax.swing.*;

public class JPanelExt extends JPanel{
	
	private String pictureType = "Happy";
	int img = 0;
	int n = 1;
	
	public JPanelExt() {
		super();
	}
	
	@Override
	
	public void paintComponent(Graphics g){
		//call the parent method to clean the surface
		super.paintComponent (g);
		
		//include the code that does the drawing here.
		
		if (this.pictureType.equalsIgnoreCase("Happy")){
			g.setColor(Color.yellow);
		    g.fillOval(0,0,300,300);
		    g.setColor(Color.black);
		    g.fillOval(80,75,30,30);
		    g.fillOval(190,75,30,30);
		    g.setColor(Color.black);
		    g.fillArc (75,100,150,150,0,-180);
		}
		else if (this.pictureType.equalsIgnoreCase ("Sad")){
			g.setColor(Color.GREEN);
	        g.fillOval(0,0,300,300);
	        g.setColor(Color.black );
	        g.fillOval(80,75,30,30);
	        g.fillOval(190,75,30,30);
	        g.setColor(Color.black);
	        g.drawArc(75,150,150,150,0,180);
		}
		else if (this.pictureType.equalsIgnoreCase ("Picture")){
						
			if(img == 1) n = ((int)(Math.random() * 4)) + 1;
			
			URL url = getClass().getResource(n + ".gif");

			ImageIcon imageIcon = new ImageIcon (url);
			Image image = imageIcon.getImage( );
			g.drawImage (image,0,0,this.getWidth( ), this.getHeight ( ) , this);
			img = 0;
		}
	}
	
	public void setPictureType (String pictureType){
		this.pictureType = pictureType;
		this.repaint( );
	}
	
	public void setImg() {
		img = 1;
	}
}
