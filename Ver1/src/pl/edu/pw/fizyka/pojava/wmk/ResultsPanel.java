package pl.edu.pw.fizyka.pojava.wmk;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JPanel;

//Made by: Adam Pempkowiak

public class ResultsPanel extends JPanel{
	JButton calculateResultsButton;
	LanguageChange languageChange;
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
	public ResultsPanel(){
		
		calculateResultsButton = new JButton("calculate");
		Locale locale = new Locale("pl", "PL");
		Locale.setDefault(locale);
		//FileInputStream file = null;
		//calculateResultsButton.setText(messages.getString("calculateButtonMessage"));
		/* try {
			file = new FileInputStream("/home/adasus/eclipse-workspace/poprojekt/pl/edu/pw/fizyka/pojava/wmk/config/messages_pl_PL.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Properties properties = new Properties();
		try {
			properties.load(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	*/
		//System.out.println(properties.getProperty("calculateButtonMessage"));
		this.add(calculateResultsButton);
		il8n();
	}
	public void updateLanguageChoice(Locale locale) {
		ResourceBundle messages = ResourceBundle.getBundle("pl/edu/pw/fizyka/pojava/lang/messages", locale);
		calculateResultsButton.setText(messages.getString("calculateButtonMessage"));
	}
	
	
	private  void il8n() {
		Locale polishLocale = new Locale("pl", "PL");
		Locale.setDefault(polishLocale);
		//ResourceBundle bundle = ResourceBundle.getBundle("messages", polishLocale);
		ResourceBundle messages = ResourceBundle.getBundle("pl/edu/pw/fizyka/pojava/lang/messages");
		System.out.println(messages.getString("calculateButtonMessage"));
	}
}
