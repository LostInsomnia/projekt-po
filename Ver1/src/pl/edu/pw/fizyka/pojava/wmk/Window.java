package pl.edu.pw.fizyka.pojava.wmk;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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
		
		TopMenuBar menuBar = new TopMenuBar();
		this.setJMenuBar(menuBar);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		AnchorPointList anchorPointList = new AnchorPointList();
		
		//this.setLayout(new BorderLayout(10,10));
		/*
		JPanel frame = new JPanel();
		this.add(frame);
		
		frame.setLayout(new BorderLayout());
		frame.setBackground(Color.GRAY);
		
		JPanel screen = new JPanel();
		screen.setBorder(new CompoundBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0), BorderFactory.createLineBorder(Color.BLACK, 1)));
		frame.add(screen, BorderLayout.CENTER);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.GRAY);
		buttonPanel.setLayout(new GridLayout(2,3,15,15));
		
		JButton button1 = new JButton("test");
		button1.setBackground(Color.LIGHT_GRAY);
		JButton button2 = new JButton("test");
		button2.setBackground(Color.LIGHT_GRAY);
		JButton button3 = new JButton("test");
		button3.setBackground(Color.LIGHT_GRAY);
		JButton button4 = new JButton("test");
		button4.setBackground(Color.LIGHT_GRAY);
		JButton button5 = new JButton("test");
		button5.setBackground(Color.LIGHT_GRAY);
		JButton button6 = new JButton("test");
		button6.setBackground(Color.LIGHT_GRAY);
		
		buttonPanel.add(button1);
		buttonPanel.add(button2);
		buttonPanel.add(button3);
		buttonPanel.add(button4);
		buttonPanel.add(button5);
		buttonPanel.add(button6);
		
		
		
		frame.add(buttonPanel, BorderLayout.PAGE_END);
		*/
		ParamPanel paramPanel = new ParamPanel();
		this.add(paramPanel, BorderLayout.LINE_START);
		ResultsPanel resultsPanel = new ResultsPanel();
		this.add(resultsPanel, BorderLayout.LINE_END);
		//JPanel paramPanel = new JPanel();
		//paramPanel.setBackground(Color.GRAY);
		//frame.add(paramPanel, BorderLayout.LINE_END);
		
		DrawspacePanel drawspace = new DrawspacePanel(anchorPointList);
		this.add(drawspace, BorderLayout.CENTER);
		
		BotPanel buttonPanel = new BotPanel(drawspace);
		this.add(buttonPanel, BorderLayout.PAGE_END);
		
		DarkModeButton colorMode = new DarkModeButton();
		topPanel.add(colorMode);
		colorMode.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Color buttonColor = new Color(80,80,80);
				if(colorMode.darkmode) {
					colorMode.darkmode = false;
					ColorScheme.setColorScheme(new Color[]{Color.LIGHT_GRAY, Color.WHITE, Color.black, Color.GRAY} );
				}
				else {
					colorMode. darkmode = true;
					ColorScheme.setColorScheme(new Color[]{Color.DARK_GRAY, Color.LIGHT_GRAY, Color.WHITE, buttonColor});
					 
			}
				drawspace.changeDrawspaceColor();
				topPanel.changeTopPanelColor();
				paramPanel.changeParamColor();
				resultsPanel.changeResultColor();
				buttonPanel.changeBotColor();
				colorMode.setBackground(ColorScheme.getColorScheme()[0]);
				menuBar.changeMenuColor();

			}});
		}
	
	public static void main(String[] args) {
		
		Window window = new Window();	
		window.setVisible(true);
	}

}
