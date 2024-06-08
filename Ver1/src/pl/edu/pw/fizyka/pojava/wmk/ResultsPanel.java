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
import javax.swing.JTextArea;

//Made by: Adam Pempkowiak

public class ResultsPanel extends JPanel{
	JButton calculateResultsButton;
	LanguageChange languageChange;
	Anchor anchor;
	JTextArea resultsField = new JTextArea();
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
		
		this.add(resultsField);
		ActionListener resultsButtonListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				claculateResult();
				displayResults();
				
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
	
	public void claculateResult() {
		AnchorList anchorList = AnchorList.getInstance();
		int size = anchorList.getAnchorList().size();
		int n=0;
		int maxDegree=0;
	/*	for (int i=0;i<size;i++) {
			if (anchorPointList.getAnchorPointList().get(i).getDegree()>=size) {
				size = anchorPointList.getAnchorPointList().get(i).getDegree();
				n=anchorPointList.getAnchorPointList().get(i).getN();;
			}
			if (anchorPointList.getAnchorPointList().get(i).getIsMaster()) {
				
			}
		}
		*/
		for (int i=0;i<size;i++) {
			if (anchorList.getAnchorList().get(i).getMasterPoint().getDegree()>= maxDegree) {
				maxDegree = anchorList.getAnchorList().get(i).getMasterPoint().getDegree();
				n=i;
			}
			
		}
		
			anchorList.getAnchorList().get(n).calculateResults(20);
			anchorList.getAnchorList().get(n).getMasterPoint().setForceOnPoint(20);
		for (int i=maxDegree-1; i>0;i--) {
			for (int j=0;j<size;j++) {
				if(anchorList.getAnchorList().get(j).getMasterPoint().getIsMaster()) {
					anchorList.getAnchorList().get(j).calculateResults(anchorList.getAnchorList().get(j).getMasterPoint().getForceOnPoint());
				}
			}
		}
		
	
		
	}
	public void displayResults() {
		resultsField.setText("punkt| siła| czy wytrzymał| wytrzymałość"+ "\n");
		for (int i=0; i<anchorPointList.getAnchorPointList().size();i++)
			resultsField.append(Integer.toString( anchorPointList.getAnchorPointList().get(i).getDegree())+ " | "+Integer.toString( anchorPointList.getAnchorPointList().get(i).getN()+1)+ " | "+Float.toString(anchorPointList.getAnchorPointList().get(i).getForceOnPoint())
			+" | " +" | "+Float.toString( anchorPointList.getAnchorPointList().get(i).getBreakingStrength()) + "\n");
	}
	
	private  void il8n() {
		Locale polishLocale = new Locale("pl", "PL");
		Locale.setDefault(polishLocale);
		//ResourceBundle bundle = ResourceBundle.getBundle("messages", polishLocale);
		ResourceBundle messages = ResourceBundle.getBundle("pl/edu/pw/fizyka/pojava/lang/messages");
	}
}
