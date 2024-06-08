package pl.edu.pw.fizyka.pojava.wmk;

import java.awt.BorderLayout;
import java.awt.GridLayout;
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
import javax.swing.JTextField;

//Made by: Adam Pempkowiak

public class ResultsPanel extends JPanel{
	double force;
	JTextField forceField;
	JButton calculateResultsButton;
	ResourceBundle messages = ResourceBundle.getBundle("pl/edu/pw/fizyka/pojava/lang/messages", new Locale("pl","PL"));
	LanguageChange languageChange;
	Anchor anchor;
	JLabel forceLabel;
	JTextArea resultsField = new JTextArea();
	AnchorPointList anchorPointList;
	double F1, F2;
	AnchorList anchorList;
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
		this.setLayout(new BorderLayout());
		forceField = new JTextField(" ");
		
		calculateResultsButton = new JButton("calculate");
		JPanel topPanel = new JPanel(new GridLayout(3,1));
		JPanel bottomPanel = new JPanel();
		forceLabel = new JLabel(messages.getString("forceLabelMessage"));
		topPanel.add(forceLabel);
		topPanel.add(forceField);
		this.add(bottomPanel, BorderLayout.PAGE_END);
		this.add(topPanel, BorderLayout.PAGE_START);
		bottomPanel.add(resultsField);
		ActionListener resultsButtonListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				claculateResult();
				displayResults();
				
			}
		};
		calculateResultsButton.addActionListener(resultsButtonListener);
		updateLanguageChoice(new Locale("pl", "PL"));
		topPanel.add(calculateResultsButton);
		il8n();
	}
	public void updateLanguageChoice(Locale locale) {
		messages = ResourceBundle.getBundle("pl/edu/pw/fizyka/pojava/lang/messages", locale);
		calculateResultsButton.setText(messages.getString("calculateButtonMessage"));
		forceLabel.setText(messages.getString("forceLabelMessage"));
	}
	
	public void claculateResult() {
		force = Double.parseDouble(forceField.getText());
		anchorList = AnchorList.getInstance();
		int size = anchorList.getAnchorList().size();
		int n=0;
		int maxDegree=0;
		if(force >0) {
			for (int i=0;i<size;i++) {
				if (anchorList.getAnchorList().get(i).getMasterPoint().getDegree()>= maxDegree) {
					maxDegree = anchorList.getAnchorList().get(i).getMasterPoint().getDegree();
					n=i;
				}
				
			}
			
				anchorList.getAnchorList().get(n).calculateResults(force);
				anchorList.getAnchorList().get(n).getMasterPoint().setForceOnPoint((float)force);
			for (int i=maxDegree-1; i>0;i--) {
				for (int j=0;j<size;j++) {
					if(anchorList.getAnchorList().get(j).getMasterPoint().getIsMaster()) {
						anchorList.getAnchorList().get(j).calculateResults(anchorList.getAnchorList().get(j).getMasterPoint().getForceOnPoint());
					}
				}
			}
			for (int i=0;i<anchorPointList.getAnchorPointList().size();i++) {
				anchorPointList.getAnchorPointList().get(i).checkIfPointFailed();
			}
			for (int i=0;i<size;i++) {
				anchorList.getAnchorList().get(i).checkIfAnchorFailed();
			}
		}
		else {
			forceField.setText("");
			forceLabel.setText(messages.getString("forceErrorMessage"));
		}
	}
	public void displayResults() {
		resultsField.setText(messages.getString("resultsLabelPoints")+ "\n");
		for (int i=0; i<anchorPointList.getAnchorPointList().size();i++)
			resultsField.append(Integer.toString( anchorPointList.getAnchorPointList().get(i).getDegree())+ " | "+Integer.toString( anchorPointList.getAnchorPointList().get(i).getN()+1)+ " | "+Float.toString(anchorPointList.getAnchorPointList().get(i).getForceOnPoint())
			 +" | "+Float.toString( anchorPointList.getAnchorPointList().get(i).getBreakingStrength()) + " | "+ anchorPointList.getAnchorPointList().get(i).getPointFailed() + "\n");
		resultsField.append(messages.getString("resultsLabelAnchors")+ "\n");
		for (int i=0; i<anchorList.getAnchorList().size();i++)
			resultsField.append(Integer.toString(anchorList.getAnchorList().get(i).getStAnchorPoint().getN()) + ";"+ Integer.toString(anchorList.getAnchorList().get(i).getNdAnchorPoint().getN())+ "|"
				+ messages.getString( anchorList.getAnchorList().get(i).getAnchorMaterial().name())+ "|"+ Float.toString(anchorList.getAnchorList().get(i).getBrakingStrength())+ "|"
					+Float.toString(anchorList.getAnchorList().get(i).getForceOnAnchor())+"|"+ anchorList.getAnchorList().get(i).getAnchorFailed()+"\n");
	}
	
	private  void il8n() {
		Locale polishLocale = new Locale("pl", "PL");
		Locale.setDefault(polishLocale);
		//ResourceBundle bundle = ResourceBundle.getBundle("messages", polishLocale);
		ResourceBundle messages = ResourceBundle.getBundle("pl/edu/pw/fizyka/pojava/lang/messages");
	}
}
