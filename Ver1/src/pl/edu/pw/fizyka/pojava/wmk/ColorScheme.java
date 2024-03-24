package pl.edu.pw.fizyka.pojava.wmk;

import java.awt.Color;

public class ColorScheme {
	//Didn't work through DarkModeButton

	 static Color mainColor = Color.DARK_GRAY;
	 static Color secondaryColor = Color.LIGHT_GRAY;
	 static Color textColor = Color.white;
	 static Color buttonColor = Color.gray;
	 
	 public static void setColorScheme(Color[] colorSet) {
		 mainColor = colorSet[0];
		 secondaryColor = colorSet[1];
		 textColor = colorSet[2];
		 buttonColor = colorSet[3];
		 System.out.println(buttonColor);
	 }
	 
	 public static Color[] getColorScheme() {
		 Color[] colorSet = {mainColor, secondaryColor, textColor, buttonColor};
		 return colorSet;
	 }
	public ColorScheme() {
		// TODO Auto-generated constructor stub
	}

}
