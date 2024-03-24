package pl.edu.pw.fizyka.pojava.wmk;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

//Made by: Adam Pempkowiak
//Small changes: Kacper Szymczak
public class TopPanel extends JPanel {
	TopPanel(){
		this.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		JButton colorMode = new JButton("dark/light");
		this.add(colorMode);
		//JButton language = new JButton("change language");
		LanguageButton languageChangeButton = new LanguageButton();
		this.add(languageChangeButton);
	}
	
}
