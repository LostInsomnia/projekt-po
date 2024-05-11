package pl.edu.pw.fizyka.pojava.wmk;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

//Made by: Kacper Szymczak
// edited by: Adam Pempkowiak;
public class ParamPanel extends JPanel{
//	JLabel par1, par2, par3;
//	JTextField inputPar1, inputPar2, inputPar3;
	LanguageChange languageChange;
	JSlider slider;
	JLabel breakingStrength;
	JPanel filler1, filler2;
	public void setLanguageChange(LanguageChange languageChange) {
		this.languageChange = languageChange;
		this.languageChange.setParamPanel(this);
	}
	public void displayPointData(float brakingStrengthinkN) {
		this.removeAll();
		this.setLayout(new GridLayout(4, 1));
		
		filler1 = new JPanel();
		filler2 = new JPanel();
		breakingStrength = new JLabel("breaking strength in kN", SwingConstants.CENTER);
		
		
		//filler1 = new JPanel();
		//filler2 = new JPanel();
		filler1.setBackground(ColorScheme.getColorScheme()[0]);
		filler2.setBackground(ColorScheme.getColorScheme()[0]);
		this.add(filler1);
		
		//breakingStrength = new JLabel("braking strength in kN");
		this.add(breakingStrength);
		//ResourceBundle messages = ResourceBundle.getBundle("pl/edu/pw/fizyka/pojava/lang/messages", languageChange.getLocale());
		//brakingStrength.setText(messages.getString("anchorPointBrakingStrengthMessage"));
		slider = new JSlider(0, 20, (int)brakingStrengthinkN);
		slider.setBackground(ColorScheme.getColorScheme()[0]);
		
		slider.setMajorTickSpacing(6);
		slider.setMinorTickSpacing(2);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		
		ChangeListener listener  = new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				
			}
		};
		
		this.add(slider);
		this.add(filler2);
		this.setBackground(ColorScheme.getColorScheme()[0]);
		changeParamColor();
		
		
		revalidate();
		
	}
public void changeParamColor() {
		
	/*
	 0 - Main Color
	 1 - Secondary Color
	 2 - Text Color
	 3 - Button Color
	 */
		this.setBackground(ColorScheme.getColorScheme()[0]);
		this.setForeground(ColorScheme.getColorScheme()[2]);
		if(breakingStrength != null) {
		breakingStrength.setForeground(ColorScheme.getColorScheme()[2]);
		slider.setForeground(ColorScheme.getColorScheme()[2]);
		slider.setBackground(ColorScheme.getColorScheme()[0]);
		filler1.setBackground(ColorScheme.getColorScheme()[0]);
		filler2.setBackground(ColorScheme.getColorScheme()[0]);
		}
		
/*		par1.setForeground(ColorScheme.getColorScheme()[2]);
		par2.setForeground(ColorScheme.getColorScheme()[2]);
		par3.setForeground(ColorScheme.getColorScheme()[2]);
		
		//White is unreadable on light gray, text has to stay black or textfield has to get darker
		inputPar1.setBackground(ColorScheme.getColorScheme()[1]);
		//inputPar1.setForeground(ColorScheme.getColorScheme()[2]);
		
		inputPar2.setBackground(ColorScheme.getColorScheme()[1]);
		//inputPar2.setForeground(ColorScheme.getColorScheme()[2]);
		
		inputPar3.setBackground(ColorScheme.getColorScheme()[1]);
		//inputPar3.setForeground(ColorScheme.getColorScheme()[2]);
		*/
		
		revalidate();
	}
	
	public void updateLanguageChoice(Locale locale) {
		ResourceBundle messages = ResourceBundle.getBundle("pl/edu/pw/fizyka/pojava/lang/messages", locale);
		if(breakingStrength != null)
			breakingStrength.setText(messages.getString("anchorPointBrakingStrengthMessage"));
	}

	public ParamPanel(){
		Dimension element = new Dimension(100,25);
		Dimension spacing = new Dimension(100,50);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS ));
		this.add(Box.createRigidArea(spacing));
		this.setBackground(ColorScheme.getColorScheme()[0]);
		
		
		//this.setBackground(ColorScheme.getColorScheme()[0]);
		
	/*	par1 = new JLabel("Parameter 1");
		par1.setAlignmentX(CENTER_ALIGNMENT);
		par1.setPreferredSize(element);
		this.add(par1);
		inputPar1 = new JTextField();
		this.add(inputPar1);
		inputPar1.setMaximumSize(element);
		this.add(Box.createRigidArea(spacing));
		
		par2 = new JLabel("Parameter 2");
		this.add(par2);
		par2.setPreferredSize(element);
		par2.setAlignmentX(CENTER_ALIGNMENT);
		inputPar2 = new JTextField();
		this.add(inputPar2);
		inputPar2.setMaximumSize(element);
		this.add(Box.createRigidArea(spacing));
		
		par3 = new JLabel("Parameter 3");
		this.add(par3);
		par3.setPreferredSize(element);
		par3.setAlignmentX(CENTER_ALIGNMENT);
		inputPar3 = new JTextField();
		this.add(inputPar3);
		inputPar3.setMaximumSize(element);
		this.add(Box.createRigidArea(spacing));
		*/
	}
}
