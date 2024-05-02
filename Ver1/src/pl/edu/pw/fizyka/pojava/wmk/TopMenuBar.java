package pl.edu.pw.fizyka.pojava.wmk;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

//Made by: Adam Pempkowiak, Kacper Szymczak
public class TopMenuBar extends JMenuBar{
	JMenu menu;
	JMenuItem importData;
	JMenuItem exportData;
	JMenuItem authorInfo;
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
		
		authorInfo.setBackground(ColorScheme.getColorScheme()[3]);
		authorInfo.setForeground(ColorScheme.getColorScheme()[2]);
		
		revalidate();
	}
	public TopMenuBar(){
		 menu = new JMenu("Options");
		this.add(menu);
		importData = new JMenuItem("import data");
		exportData = new JMenuItem("save data");
		authorInfo = new JMenuItem("author info");
		ActionListener authorInfoListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new AuthorInfoWindow().setVisible(true);
			}
			
		};
		authorInfo.addActionListener(authorInfoListener);
		menu.add(importData);
		menu.addSeparator();
		menu.add(exportData);
		menu.addSeparator();
		menu.add(authorInfo);
	}
}
