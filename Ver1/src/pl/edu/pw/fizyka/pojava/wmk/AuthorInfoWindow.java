package pl.edu.pw.fizyka.pojava.wmk;

import java.awt.Color;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class AuthorInfoWindow extends JFrame{
	JLabel authorInfo;
	public AuthorInfoWindow(Locale locale) {
		this.setSize(480,360);
		this.setAlwaysOnTop(true);
		
		
		
		this.setBackground(ColorScheme.getColorScheme()[0]);
		this.setForeground(ColorScheme.getColorScheme()[2]);
		
		
		ResourceBundle messages = ResourceBundle.getBundle("pl/edu/pw/fizyka/pojava/lang/messages", locale);
		 authorInfo = new JLabel(messages.getString("authorInfo"), SwingConstants.CENTER);
		
		authorInfo.setBackground(ColorScheme.getColorScheme()[0]);
		authorInfo.setForeground(ColorScheme.getColorScheme()[2]);
		
		//authorInfo.setText();
		
		this.add(authorInfo);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
		// TODO Auto-generated constructor stub
	}
	
	public void changeInfoWindowColor(Color c1, Color c2) {
		this.setBackground(c1);
		this.setForeground(c2);
		authorInfo.setBackground(c1);
		authorInfo.setForeground(c2);
	}
}
