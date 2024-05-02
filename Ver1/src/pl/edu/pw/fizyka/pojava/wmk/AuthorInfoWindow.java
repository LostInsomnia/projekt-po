package pl.edu.pw.fizyka.pojava.wmk;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class AuthorInfoWindow extends JFrame{
	public AuthorInfoWindow() {
		this.setSize(480,360);
		JLabel authorInfo = new JLabel();
		authorInfo.setText("Authors: Adam Pempkowiak & Kacper Szymczak");
		this.add(authorInfo);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		// TODO Auto-generated constructor stub
	}
}
