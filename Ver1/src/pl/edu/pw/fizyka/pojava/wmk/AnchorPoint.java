package pl.edu.pw.fizyka.pojava.wmk;		

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
//Made by: Adam Pempkowiak
//Color change: Kacper Szymczak
public class AnchorPoint extends JButton {

   

	ParamPanel paramPanel;
	protected int x, y, n;
	int degree = 0;
	AnchorPoint an = this;
	float forceOnPoint=0;
	public float getForceOnPoint() {
		return forceOnPoint;
	}

	public void setForceOnPoint(float forceOnPoint) {
		this.forceOnPoint = forceOnPoint;
	}

	float breakingStrength = 20;		// in kN
	protected Boolean isMaster = false;
	ActionListener listener = new ActionListener() {
	@Override
	public void actionPerformed(ActionEvent e) {
		//paramPanel.displayPointData(this);
		paramPanel.setAnchorPoint(an);
		paramPanel.displayPointData( breakingStrength);
	}
	};
	
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
	
	public void setParamPanel(ParamPanel paramPanel) {
		this.paramPanel = paramPanel;
	}
	
	public AnchorPoint(int x, int y, int n) {
		this.x =x;
		this.y =y;
		this.n = n;
		//setContentAreaFilled(false);  
		this.addActionListener(listener);
		this.setMargin(new Insets(0, 0, 0, 0));
		//paramPanel = new ParamPanel(breakingStrength);
		
		 try {
			    Image img = ImageIO.read(getClass().getResource("images/anchor_point_icon.png"));
			    this.setIcon(new ImageIcon(img));
			    this.setVerticalTextPosition(this.CENTER);
			    this.setHorizontalTextPosition(CENTER);
			    this.setForeground(Color.white);
			    this.setText(Integer.toString(n+1));
			   
			  }
		 catch (Exception ex) {
			    System.out.println(ex);
			  }
		
		 
	}
	
	public int getDegree() {
		return degree;
	}

	public void setDegree(int degree) {
		this.degree = degree;
	}

	public Boolean getIsMaster() {
		return isMaster;
	}

	public void setIsMaster(Boolean isMaster) {
		this.isMaster = isMaster;
	}

	public int getN() {
		return n;
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
