package pl.edu.pw.fizyka.pojava.wmk;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

//Made by: Adam Pempkowiak, Kacper Szymczak

public class Window extends JFrame {

	public Window() {
		
		this.setMinimumSize(new Dimension(800,600));
		this.setSize(800,600);
		TopPanel topPanel = new TopPanel();
		this.add(topPanel, BorderLayout.PAGE_START);
		
		AnchorPointList anchorPointList = new AnchorPointList();
		
		TopMenuBar menuBar = new TopMenuBar(anchorPointList);
		this.setJMenuBar(menuBar);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		ParamPanel paramPanel = new ParamPanel();
		this.add(paramPanel, BorderLayout.LINE_START);
		ResultsPanel resultsPanel = new ResultsPanel();
		this.add(resultsPanel, BorderLayout.LINE_END);

		
		DrawspacePanel drawspace = new DrawspacePanel(anchorPointList);
		drawspace.setParamPanel(paramPanel);
		drawspace.setResultPanel(resultsPanel);
		this.add(drawspace, BorderLayout.CENTER);
		
		BotPanel buttonPanel = new BotPanel(drawspace);
		this.add(buttonPanel, BorderLayout.PAGE_END);
		
		DarkModeButton colorMode = new DarkModeButton();
		topPanel.add(colorMode);
		colorMode.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(colorMode.darkmode) {
					colorMode.darkmode = false;
					ColorScheme.setColorScheme(new Color[]{Color.LIGHT_GRAY, Color.WHITE, Color.black, Color.GRAY} );
				}
				else {
					colorMode. darkmode = true;
					ColorScheme.setColorScheme(new Color[]{Color.DARK_GRAY, Color.LIGHT_GRAY, Color.WHITE, ColorScheme.customButtonColor});
					 
			}
				drawspace.changeDrawspaceColor();
				topPanel.changeTopPanelColor();
				paramPanel.changeParamColor();
				resultsPanel.changeResultColor();
				buttonPanel.changeBotColor();
				colorMode.setBackground(ColorScheme.getColorScheme()[0]);
				menuBar.changeMenuColor();
				anchorPointList.changeAllPoints();


			}});
		//set initial colors
		drawspace.changeDrawspaceColor();
		topPanel.changeTopPanelColor();
		//paramPanel.changeParamColor();
		resultsPanel.changeResultColor();
		buttonPanel.changeBotColor();
		colorMode.setBackground(ColorScheme.getColorScheme()[0]);
		menuBar.changeMenuColor();
		anchorPointList.changeAllPoints();
		
		LanguageChange languageChange = new LanguageChange();
		resultsPanel.setLanguageChange(languageChange);
		topPanel.setLanguageChange(languageChange);
		buttonPanel.setLanguageChange(languageChange);
		menuBar.setLanguageChange(languageChange);
		paramPanel.setLanguageChange(languageChange);
		}
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater (new Runnable(){
			 public void run() {
				Window window = new Window();	
				window.setVisible(true);
			 }
			 });
		
		
		
	}

}
