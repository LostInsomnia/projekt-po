package pl.edu.pw.fizyka.pojava.wmk;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class AuthorInfoWindow extends JFrame{
	public AuthorInfoWindow(Locale locale) {
		this.setSize(480,360);
		JLabel authorInfo = new JLabel();
		
		ResourceBundle messages = ResourceBundle.getBundle("pl/edu/pw/fizyka/pojava/lang/messages", locale);
		authorInfo.setText(messages.getString("authorInfo"));
		
		this.add(authorInfo);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		// TODO Auto-generated constructor stub
	}
}
