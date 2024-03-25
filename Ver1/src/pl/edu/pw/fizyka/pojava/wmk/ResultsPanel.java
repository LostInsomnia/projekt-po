package pl.edu.pw.fizyka.pojava.wmk;

import javax.swing.JButton;
import javax.swing.JPanel;

//Made by: Adam Pempkowiak

public class ResultsPanel extends JPanel{
	JButton calculateResultsButton;
public void changeResultColor() {
	/*
	 0 - Main Color
	 1 - Secondary Color
	 2 - Text Color
	 3 - Button Color
	 */
		this.setBackground(ColorScheme.getColorScheme()[0]);
		calculateResultsButton.setBackground(ColorScheme.getColorScheme()[3]);
		calculateResultsButton.setForeground(ColorScheme.getColorScheme()[2]);
		revalidate();
	}
	public ResultsPanel(){
		calculateResultsButton = new JButton("calculate");
		this.add(calculateResultsButton);
	}
}
