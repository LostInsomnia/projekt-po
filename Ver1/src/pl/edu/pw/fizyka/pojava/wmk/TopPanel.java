package pl.edu.pw.fizyka.pojava.wmk;

import java.awt.FlowLayout;

import javax.swing.JPanel;

//Made by: Adam Pempkowiak
//Small changes: Kacper Szymczak
public class TopPanel extends JPanel {
	LanguageChange languageChange;
	LanguageButton languageChangeButton;
public void changeTopPanelColor() {
	/*
	 0 - Main Color
	 1 - Secondary Color
	 2 - Text Color
	 3 - Button Color
	 */

		this.setBackground(ColorScheme.getColorScheme()[0]);
		revalidate();
	}
	TopPanel(){
		this.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		//JButton language = new JButton("change language");
		languageChangeButton = new LanguageButton();
		
		this.add(languageChangeButton);
	}
	public void setLanguageChange(LanguageChange languageChange) {
		languageChangeButton.setLanguageChange(languageChange);
	}
	
}
