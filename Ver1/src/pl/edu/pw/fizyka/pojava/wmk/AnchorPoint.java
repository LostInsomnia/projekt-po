package pl.edu.pw.fizyka.pojava.wmk;		

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JButton;

public class AnchorPoint extends JButton{
	protected int x, y;
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
		    g.setColor(Color.lightGray);
		    g.fillOval(0, 0, getSize().width-1, getSize().height-1);
		    super.paintComponent(g);
	  }
}
