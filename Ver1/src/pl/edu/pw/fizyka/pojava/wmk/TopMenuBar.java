package pl.edu.pw.fizyka.pojava.wmk;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

//Made by: Adam Pempkowiak, Kacper Szymczak
public class TopMenuBar extends JMenuBar{
	JMenu menu;
	JMenuItem importData;
	JMenuItem exportData;
	public void changeMenuColor() {
		/*
		 0 - Main Color
		 1 - Secondary Color
		 2 - Text Color
		 3 - Button Color
		 */
		
		this.setBackground(ColorScheme.getColorScheme()[0]);
		
		menu.setBackground(ColorScheme.getColorScheme()[0]);
		menu.setForeground(ColorScheme.getColorScheme()[2]);
		
		importData.setBackground(ColorScheme.getColorScheme()[3]);
		importData.setForeground(ColorScheme.getColorScheme()[2]);
		
		exportData.setBackground(ColorScheme.getColorScheme()[3]);
		exportData.setForeground(ColorScheme.getColorScheme()[2]);
		
		revalidate();
	}
	public TopMenuBar(){
		 menu = new JMenu("Options");
		this.add(menu);
		importData = new JMenuItem("import data");
		exportData = new JMenuItem("save data");
		
		menu.add(importData);
		menu.addSeparator();
		menu.add(exportData);
	}
}
