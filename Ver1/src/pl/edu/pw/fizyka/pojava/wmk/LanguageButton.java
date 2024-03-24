package pl.edu.pw.fizyka.pojava.wmk;

import java.awt.Color;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

//Made by: Adam Pempkowiak, 
//Small changes: Kacper Szymczak

public class LanguageButton extends JButton implements ActionListener{
	boolean state = true;
	LanguageButton(){
		 this.addActionListener(this);
		 this.setMargin(new Insets(0, 0, 0, 0));
		 this.setBorder(BorderFactory.createLineBorder(Color.black));

		 try {
			    Image img = ImageIO.read(getClass().getResource("images/poland_icon.jpeg"));
			    this.setIcon(new ImageIcon(img));
			  } catch (Exception ex) {
			    System.out.println(ex);
			  }
	}
	
	public void actionPerformed(ActionEvent e) { 
	     if(state) {
	    	 try {
				    Image img = ImageIO.read(getClass().getResource("images/greatbrittain_icon.jpeg"));
				    this.setIcon(new ImageIcon(img));
				    state = false;
				    
				  } catch (Exception ex) {
				    System.out.println(ex);
				  }
	     }
	     else {
	    	 try {
				    Image img = ImageIO.read(getClass().getResource("images/poland_icon.jpeg"));
				    this.setIcon(new ImageIcon(img));
				    state = true;
				    
				  } catch (Exception ex) {
				    System.out.println(ex);
				  }
	     }
	   
	}
}
