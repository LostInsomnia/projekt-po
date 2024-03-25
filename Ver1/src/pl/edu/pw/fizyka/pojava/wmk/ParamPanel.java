package pl.edu.pw.fizyka.pojava.wmk;

import javax.swing.JPanel;

public class ParamPanel extends JPanel{
	
public void changeParamColor() {
		
	/*
	 0 - Main Color
	 1 - Secondary Color
	 2 - Text Color
	 3 - Button Color
	 */
		this.setBackground(ColorScheme.getColorScheme()[0]);
		revalidate();
	}
	public ParamPanel(){
		
	}
}
