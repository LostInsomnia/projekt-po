package pl.edu.pw.fizyka.pojava.wmk;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

//Made by: Adam Pempkowiak

public class ResultsPanel extends JPanel{
	JButton calculateResultsButton;
	LanguageChange languageChange;
	Anchor anchor;
	AnchorPointList anchorPointList;
	double F1, F2;
public void setLanguageChange(LanguageChange languageChange) {
		this.languageChange = languageChange;
		languageChange.setResultsPanel(this);
	}
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
	public ResultsPanel(AnchorPointList anchorPointList){
		this.anchorPointList = anchorPointList;
		calculateResultsButton = new JButton("calculate");
		JLabel resultLabel = new JLabel();
		this.add(resultLabel);
		ActionListener resultsButtonListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				resultLabel.setText("force on st point if force on masterPoint is 1 kN" + Double.toString(F1)+ "kN");
				
			}
		};
		calculateResultsButton.addActionListener(resultsButtonListener);
		updateLanguageChoice(new Locale("pl", "PL"));
		this.add(calculateResultsButton);
		il8n();
	}
	public void updateLanguageChoice(Locale locale) {
		ResourceBundle messages = ResourceBundle.getBundle("pl/edu/pw/fizyka/pojava/lang/messages", locale);
		calculateResultsButton.setText(messages.getString("calculateButtonMessage"));
	}
	
	public void claculateResult(Anchor anchor) {
		int x1 = anchor.getStAnchorPoint().getX();
		int y1 = anchor.getStAnchorPoint().getY();
		int x2 = anchor.getNdAnchorPoint().getX();
		int y2 = anchor.getNdAnchorPoint().getY();
		int xc =  anchor.getMasterPoint().getX();
		int yc =  anchor.getMasterPoint().getY();
		
		F1 = (xc-x2)*Math.sqrt((double)(Math.pow(xc, 2)+Math.pow(y1, 2)))/(-x2*y1+xc*(y1+y2));
		System.out.print(x1+" "+x2+" "+y1+" "+y2+" "+xc+" "+yc+" ");
	}
	public Anchor getAnchor() {
		return anchor;
	}
	public void setAnchor(Anchor anchor) {
		this.anchor = anchor;
		claculateResult(anchor);
	}
	private  void il8n() {
		Locale polishLocale = new Locale("pl", "PL");
		Locale.setDefault(polishLocale);
		//ResourceBundle bundle = ResourceBundle.getBundle("messages", polishLocale);
		ResourceBundle messages = ResourceBundle.getBundle("pl/edu/pw/fizyka/pojava/lang/messages");
	}
}
