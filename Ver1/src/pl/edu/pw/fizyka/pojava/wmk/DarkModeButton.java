package pl.edu.pw.fizyka.pojava.wmk;

import java.awt.Image;
import java.awt.Insets;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

//Made by: Kacper Szymczak 
public class DarkModeButton extends JButton {
	
	boolean darkmode = false;

	public DarkModeButton() {
	this.setMargin(new Insets(0, 0, 0, 0));
	
	try {
	    Image img = ImageIO.read(getClass().getResource("images/Darkmodeicon.png"));
	    Image scaled = img.getScaledInstance(45, 45, 1);
	    this.setIcon(new ImageIcon(scaled));
	  } catch (Exception ex) {
	    System.out.println(ex);
	    
	  }
	
	
	}

	
	

}
