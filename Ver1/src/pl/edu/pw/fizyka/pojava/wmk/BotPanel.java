package pl.edu.pw.fizyka.pojava.wmk;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

//Made by: Kacper Szymczak

public class BotPanel extends JPanel {
	JButton addPoint;
	JButton addAnchor;
	JButton startSim;
	JButton clear;
	
public void changeBotColor() {
		
	/*
	 0 - Main Color
	 1 - Secondary Color
	 2 - Text Color
	 3 - Button Color
	 */

		this.setBackground(ColorScheme.getColorScheme()[0]);
		
		addPoint.setBackground(ColorScheme.getColorScheme()[3]);
		addPoint.setForeground(ColorScheme.getColorScheme()[2]);
		
		addAnchor.setBackground(ColorScheme.getColorScheme()[3]);
		addAnchor.setForeground(ColorScheme.getColorScheme()[2]);
		
		startSim.setBackground(ColorScheme.getColorScheme()[3]);
		startSim.setForeground(ColorScheme.getColorScheme()[2]);
		
		clear.setBackground(ColorScheme.getColorScheme()[3]);
		clear.setForeground(ColorScheme.getColorScheme()[2]);
		revalidate();
	}
	
	public BotPanel() {
		this.setLayout(new FlowLayout());
		addPoint = new JButton("add point");
		this.add(addPoint);
		addAnchor = new JButton("add Anchor");
		this.add(addAnchor);
		startSim = new JButton("Simulate");
		this.add(startSim);
	}
	public BotPanel(DrawspacePanel drawspace) {
		this.setLayout(new FlowLayout());
		addPoint = new JButton("add point");
		this.add(addPoint);
		addAnchor = new JButton("add Anchor");
		this.add(addAnchor);
		clear = new JButton("Clear screen");
		this.add(clear);
		startSim = new JButton("Simulate");
		this.add(startSim);
		
		ActionListener addPointPressed = new ActionListener() {
			@Override
			public void actionPerformed (ActionEvent e) {
				drawspace.setAddAnchorPointSelected(true);
			}
		};
		addPoint.addActionListener(addPointPressed);
		
	}


}
