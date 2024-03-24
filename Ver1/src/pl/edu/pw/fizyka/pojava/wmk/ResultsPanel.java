package pl.edu.pw.fizyka.pojava.wmk;

import javax.swing.JButton;
import javax.swing.JPanel;

//Made by: Adam Pempkowiak

public class ResultsPanel extends JPanel{
	JButton calculateResultsButton;
public void changeResultColor() {
		

		this.setBackground(ColorScheme.getColorScheme()[0]);
		calculateResultsButton.setBackground(ColorScheme.getColorScheme()[3]);
		revalidate();
	}
	
	public ResultsPanel(){
		 calculateResultsButton = new JButton("calculate");
		this.add(calculateResultsButton);
	}
}
