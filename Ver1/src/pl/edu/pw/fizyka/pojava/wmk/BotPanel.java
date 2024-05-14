package pl.edu.pw.fizyka.pojava.wmk;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JButton;
import javax.swing.JPanel;

//Made by: Kacper Szymczak

public class BotPanel extends JPanel {
	JButton addPoint;
	JButton addAnchor;
	JButton startSim;
	JButton clear;
	AddAnchorWindow addAnchorWindow;
	LanguageChange languageChange;
	Locale locale = new Locale("pl","PL");
	
public void setLanguageChange(LanguageChange languageChange) {
		this.languageChange = languageChange;
		this.languageChange.setBotPanel(this);
	}

public void changeBotColor() {
		
	/*
	 0 - Main Color
	 1 - Secondary Color
	 2 - Text Color
	 3 - Button Color
	 */

		this.setBackground(ColorScheme.getColorScheme()[0]);
		
		addPoint.setBackground(ColorScheme.getColorScheme()[3]);
		addPoint.setForeground(ColorScheme.getColorScheme()[2]);
		
		addAnchor.setBackground(ColorScheme.getColorScheme()[3]);
		addAnchor.setForeground(ColorScheme.getColorScheme()[2]);
		
		startSim.setBackground(ColorScheme.getColorScheme()[3]);
		startSim.setForeground(ColorScheme.getColorScheme()[2]);
		
		clear.setBackground(ColorScheme.getColorScheme()[3]);
		clear.setForeground(ColorScheme.getColorScheme()[2]);
		
		if(addAnchorWindow != null) addAnchorWindow.changeWindowColor();
		revalidate();
	}
	
	public BotPanel() {
		this.setLayout(new FlowLayout());
		addPoint = new JButton("add point");
		this.add(addPoint);
		addAnchor = new JButton("add Anchor");
		this.add(addAnchor);
		startSim = new JButton("Simulate");
		this.add(startSim);
	}
	
	public void updateLanguageChoice(Locale locale) {
		ResourceBundle messages = ResourceBundle.getBundle("pl/edu/pw/fizyka/pojava/lang/messages", locale);
		addPoint.setText(messages.getString("addPointButtonMessage"));
		addAnchor.setText(messages.getString("addAnchorButtonMessage"));
		clear.setText(messages.getString("clearButtonMessage"));
		startSim.setText(messages.getString("startSimButtonMessage"));
		this.locale = locale;
	}
	
	public BotPanel(DrawspacePanel drawspace) {
		this.setLayout(new FlowLayout());
		addPoint = new JButton("add point");
		this.add(addPoint);
		addAnchor = new JButton("add Anchor");
		this.add(addAnchor);
		clear = new JButton("Clear screen");
		this.add(clear);
		startSim = new JButton("Simulate");
		this.add(startSim);
		updateLanguageChoice(new Locale("pl","PL"));
		
		
		ActionListener addPointPressed = new ActionListener() {
			@Override
			public void actionPerformed (ActionEvent e) {
				drawspace.setAddAnchorPointSelected(true);
			}
		};
		addPoint.addActionListener(addPointPressed);
		
		ActionListener clearDrawspace = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				drawspace.getAnchorPointList().clearList();
				drawspace.removeAll();
				drawspace.repaint();
				drawspace.revalidate();
				AnchorList.getInstance().getAnchorList().clear();
			}
		};
		clear.addActionListener(clearDrawspace);
		
		ActionListener addAnchorPressed = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				addAnchorWindow = new AddAnchorWindow(locale, drawspace);
				ExecutorService exec =  Executors.newFixedThreadPool(1);
				exec.execute(addAnchorWindow);
				
				//addAnchorWindow.setBackground(ColorScheme.getColorScheme()[0]);
				//addAnchorWindow.setAnchorPointList(drawspace.getAnchorPointList());
			}
		};
		addAnchor.addActionListener(addAnchorPressed);
		
		ActionListener startSimListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				drawspace.repaint();
				
			}
		};
		startSim.addActionListener(startSimListener);
	}


	
}
