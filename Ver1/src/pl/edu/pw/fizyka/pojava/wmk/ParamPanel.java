package pl.edu.pw.fizyka.pojava.wmk;

import javax.swing.JPanel;

public class ParamPanel extends JPanel{
public void changeParamColor() {
		

		this.setBackground(ColorScheme.getColorScheme()[0]);
		revalidate();
	}
	public ParamPanel(){
		
	}
}
