package pl.edu.pw.fizyka.pojava.wmk;		

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JButton;
//Made by: Adam Pempkowiak
//Color change: Kacper Szymczak
public class AnchorPoint extends JButton{
	Color currentColor = Color.LIGHT_GRAY;
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
		Dimension size = getPreferredSize();
		size.width = size.height = Math.max(size.width, size.height);
		setPreferredSize(size);
		setContentAreaFilled(false);  
	}
	
	protected void paintBorder(Graphics g) {
	    g.setColor(getForeground());
	    g.drawOval(0, 0, getSize().width-1, 
	      getSize().height-1);
	  }
		
	 protected void paintComponent(Graphics g) {
			  /*
		    if (true ||getModel().isArmed()) {
			// You might want to make the highlight color 
		   // a property of the RoundButton class.
		      g.setColor(Color.lightGray);
		    } else {
		      g.setColor(getBackground());
		    }
		    */
		    g.setColor(currentColor);
		    g.fillOval(0, 0, getSize().width-1, getSize().height-1);
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
