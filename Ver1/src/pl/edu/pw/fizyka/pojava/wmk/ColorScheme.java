package pl.edu.pw.fizyka.pojava.wmk;

import java.awt.Color;

//Made by: Kacper Szymczak

public class ColorScheme {
	//Didn't work through DarkModeButton
	
	 static Color customButtonColor = new Color(80,80,80);

	 static Color mainColor = Color.LIGHT_GRAY;
	 static Color secondaryColor = Color.WHITE;
	 static Color textColor = Color.BLACK;
	 static Color buttonColor = Color.GRAY;
	 
	 public static void setColorScheme(Color[] colorSet) {
		 mainColor = colorSet[0];
		 secondaryColor = colorSet[1];
		 textColor = colorSet[2];
		 buttonColor = colorSet[3];
	 }
	 
	 public static Color[] getColorScheme() {
		 Color[] colorSet = {mainColor, secondaryColor, textColor, buttonColor};
		 return colorSet;
	 }
	public ColorScheme() {
	}

}
