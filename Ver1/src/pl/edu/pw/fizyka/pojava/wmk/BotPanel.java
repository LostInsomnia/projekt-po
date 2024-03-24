package pl.edu.pw.fizyka.pojava.wmk;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

//Made by: Kacper Szymczak

public class BotPanel extends JPanel {
	
public void changeBotColor() {
		

		this.setBackground(ColorScheme.getColorScheme()[0]);
		revalidate();
	}

	public BotPanel() {
		this.setLayout(new FlowLayout());
		JButton addPoint = new JButton("add point");
		this.add(addPoint);
		JButton addAnchor = new JButton("add Anchor");
		this.add(addAnchor);
		JButton startSim = new JButton("Simulate");
		this.add(startSim);
	}



}
