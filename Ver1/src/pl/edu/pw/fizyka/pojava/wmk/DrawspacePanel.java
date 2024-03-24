package pl.edu.pw.fizyka.pojava.wmk;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

//Made by: Kacper Szymczak

public class DrawspacePanel extends JPanel {
	

	
	public void changeDrawspaceColor() {
		

		this.setBackground(ColorScheme.getColorScheme()[1]);
		revalidate();
	}
	
	

	public DrawspacePanel() {
		this.setPreferredSize(new Dimension(400,300));
		this.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK), BorderFactory.createEmptyBorder(5, 10, 5, 10)));
		 
			   //this.setBackground(colorSet[0]);
		
		
	}

}
