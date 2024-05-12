package pl.edu.pw.fizyka.pojava.wmk;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

//Made by: Adam Pempkowiak, Kacper Szymczak
public class TopMenuBar extends JMenuBar{
	JMenu menu;
	Locale locale;
	JMenuItem importData;
	JMenuItem exportData;
	JMenuItem authorInfo;
	LanguageChange languageChange;
	
	public void setLanguageChange(LanguageChange languageChange) {
		this.languageChange = languageChange;
		this.languageChange.setTopMenuBar(this);
	}
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
	
	public void updateLanguageChoice(Locale locale) {
		ResourceBundle messages = ResourceBundle.getBundle("pl/edu/pw/fizyka/pojava/lang/messages", locale);
		this.locale = locale;
		importData.setText(messages.getString("importDataItemMessage"));
		exportData.setText(messages.getString("exportDataItemMessage"));
		authorInfo.setText(messages.getString("authorInfoItemMessage"));
		menu.setText(messages.getString("optionsMenuMessage"));
	}
	
	
	public TopMenuBar(AnchorPointList anchorPointList) {
		// TODO Auto-generated constructor stub
		menu = new JMenu();
		this.add(menu);
		importData = new JMenuItem();
		exportData = new JMenuItem();
		authorInfo = new JMenuItem();
		updateLanguageChoice(new Locale("pl","PL"));
		ActionListener authorInfoListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new AuthorInfoWindow(locale).setVisible(true);
			}
			
		};
		
		authorInfo.addActionListener(authorInfoListener);
		menu.add(importData);
		menu.addSeparator();
		menu.add(exportData);
		menu.addSeparator();
		menu.add(authorInfo);
		
		exportData.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				//File inputFile = new File("savedData.txt");
				try {
					BufferedWriter writer = new BufferedWriter(new FileWriter("savedData.txt"));
					writer.write("Point Number" + "\t" + "Breaking Strength" +"\t"+"X Pos"+ "\t"+ "YPos"+ "\n" );
					for(int i = 0; i<anchorPointList.getAnchorPointList().size(); i++) {
						writer.write(("   " + i + "\t" +Float.toString(anchorPointList.getAnchorPointList().get(i).getBreakingStrength())+"\t"+anchorPointList.getAnchorPointList().get(i).getX()
								+"\t"+anchorPointList.getAnchorPointList().get(i).getY()+"\n"));
						
					}
					writer.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
	}
	
	
	
}
