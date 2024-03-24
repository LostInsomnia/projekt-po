package pl.edu.pw.fizyka.pojava.wmk;

import java.awt.Color;
import java.awt.Image;
import java.awt.Insets;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class DarkModeButton extends JButton {
	
	Color[] colorSet = {Color.DARK_GRAY, Color.LIGHT_GRAY, Color.white};
	boolean darkmode = true;

	public DarkModeButton() {
	this.setMargin(new Insets(0, 0, 0, 0));
	
	try {
	    Image img = ImageIO.read(getClass().getResource("images/Darkmodeicon.png"));
	    Image scaled = img.getScaledInstance(45, 45, 1);
	    this.setIcon(new ImageIcon(scaled));
	  } catch (Exception ex) {
	    System.out.println(ex);
	    
	  }
	this.setBackground(colorSet[1]);
	
	
	}
	/*public void actionPerformed(ActionEvent arg0) {
		if(darkmode) {
			colorSet[0] = Color.LIGHT_GRAY;
			colorSet[1]= Color.WHITE;
			colorSet[2] = Color.black;
			darkmode = false;
			System.out.print("l");
			ColorScheme.setColorScheme(colorSet);
		}
		else {
			colorSet[0] = Color.DARK_GRAY;
			colorSet[1]= Color.LIGHT_GRAY;
			colorSet[2] = Color.WHITE;
			 darkmode = true;
			 ColorScheme.setColorScheme(colorSet);
			 System.out.print("d");
		}
		 	
		
		
	}*/
	
	
	

}
