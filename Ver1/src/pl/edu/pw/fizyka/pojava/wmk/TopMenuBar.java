package pl.edu.pw.fizyka.pojava.wmk;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

//Made by: Adam Pempkowiak
public class TopMenuBar extends JMenuBar{
	public TopMenuBar(){
		JMenu menu = new JMenu("Options");
		this.add(menu);
		JMenuItem importData = new JMenuItem("import data");
		JMenuItem exportData = new JMenuItem("save data");
		
		menu.add(importData);
		menu.add(exportData);
	}
}
