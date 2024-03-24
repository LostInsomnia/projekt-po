package pl.edu.pw.fizyka.pojava.wmk;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

//Made by: Kacper Szymczak

public class BotPanel extends JPanel {
	
	public BotPanel() {
		this.setLayout(new FlowLayout());
		JButton addPoint = new JButton("add point");
		this.add(addPoint);
		JButton addAnchor = new JButton("add Anchor");
		this.add(addAnchor);
		JButton startSim = new JButton("Simulate");
		this.add(startSim);
	}
	public BotPanel(DrawspacePanel drawspace) {
		this.setLayout(new FlowLayout());
		JButton addPoint = new JButton("add point");
		this.add(addPoint);
		JButton addAnchor = new JButton("add Anchor");
		this.add(addAnchor);
		JButton startSim = new JButton("Simulate");
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