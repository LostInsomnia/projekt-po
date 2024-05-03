package pl.edu.pw.fizyka.pojava.wmk;		

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
//Made by: Adam Pempkowiak
//Color change: Kacper Szymczak
public class AnchorPoint extends JButton{
	Color currentColor = ColorScheme.getColorScheme()[3];
	public void changePointColor(){
		/*
		 0 - Main Color
		 1 - Secondary Color
		 2 - Text Color
		 3 - Button Color
		 */
		currentColor = ColorScheme.getColorScheme()[3];
		repaint();
		revalidate();
		
	}
	protected int x, y;
	
	protected float breakingStrength = 20;		// in kN
	public AnchorPoint(int x, int y) {
		this.x =x;
		this.y =y;
		//setContentAreaFilled(false);  
		this.setMargin(new Insets(0, 0, 0, 0));
		 try {
			    Image img = ImageIO.read(getClass().getResource("images/anchor_point_icon.png"));
			    this.setIcon(new ImageIcon(img));
			  }
		 catch (Exception ex) {
			    System.out.println(ex);
			  }
		
	}
	
	protected void paintBorder(Graphics g) {
	    g.setColor(getForeground());
	    g.drawOval(0, 0, 15, 15);
	  }
		
	 protected void paintComponent(Graphics g) {
			 
	  //  g.setColor(currentColor);
	   // g.fillOval(0, 0, 14, 14);
	    super.paintComponent(g);
	  }

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public float getBreakingStrength() {
		return breakingStrength;
	}

	public void setBreakingStrength(float breakingStrength) {
		this.breakingStrength = breakingStrength;
	}
	 
}
