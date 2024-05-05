package pl.edu.pw.fizyka.pojava.wmk;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

//Made by: Kacper Szymczak, Adam Pempkowiak

public class DrawspacePanel extends JPanel implements MouseMotionListener, MouseListener{
	
public void changeDrawspaceColor() {
	/*
	 0 - Main Color
	 1 - Secondary Color
	 2 - Text Color
	 3 - Button Color
	 */

		this.setBackground(ColorScheme.getColorScheme()[1]);
		
		revalidate();
	}
	ParamPanel paramPanel;
	int n = 0;
	public void setParamPanel(ParamPanel paramPanel) {
		this.paramPanel = paramPanel;
	}
	Boolean addAnchorPointSelected = false;
	AnchorPointList anchorPointList; 
	public DrawspacePanel() {
		this.setLayout(null);
		this.setPreferredSize(new Dimension(400,300));
		this.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK), BorderFactory.createEmptyBorder(5, 10, 5, 10)));
		this.addMouseListener(this);
	}
	
	public DrawspacePanel(AnchorPointList anchorPointList) {
		this.setPreferredSize(new Dimension(400,300));
		this.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK), BorderFactory.createEmptyBorder(5, 10, 5, 10)));
		this.setLayout(null);				// jak by coś nie działało z punktami stanowiska to pewnie chodzi o tą linijke
		this.addMouseListener(this);
		this.anchorPointList = anchorPointList;
	}
	
	void addAnchorPoint(int x, int y) {
		AnchorPoint tmpAnchorPoint = new AnchorPoint(x, y, n);
		n++;
		tmpAnchorPoint.setParamPanel(paramPanel);
		tmpAnchorPoint.setBounds(x, y, 16, 16);
		this.add(tmpAnchorPoint);
		anchorPointList.addAnchorPointToAnchorPointList(tmpAnchorPoint);	
		//TestButton testbutton = new TestButton();
		//testbutton.setBounds(x, y, 33, 33);
		//this.add(testbutton);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if (addAnchorPointSelected)
			addAnchorPoint(e.getX(), e.getY());
		this.revalidate();
		addAnchorPointSelected = false;
		
	}

	public void setAddAnchorPointSelected(Boolean addAnchorPointSelected) {
		this.addAnchorPointSelected = addAnchorPointSelected;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
