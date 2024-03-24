package pl.edu.pw.fizyka.pojava.wmk;

import java.awt.BorderLayout;
import java.awt.Dimension;

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
		
		DrawspacePanel drawspace = new DrawspacePanel();
		this.add(drawspace, BorderLayout.CENTER);
		
		BotPanel buttonPanel = new BotPanel();
		this.add(buttonPanel, BorderLayout.PAGE_END);
		}
	
	public static void main(String[] args) {
		
		Window window = new Window();	
		window.setVisible(true);
	}

}
