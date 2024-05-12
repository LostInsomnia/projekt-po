package pl.edu.pw.fizyka.pojava.wmk;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
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
	Anchor anchor;
	ResultsPanel resultPanel;
	public void setResultPanel(ResultsPanel resultPanel) {
		this.resultPanel = resultPanel;
	}
	int n = 0;
	public void setParamPanel(ParamPanel paramPanel) {
		this.paramPanel = paramPanel;
	}
	Boolean addAnchorPointSelected = false;
	AnchorPointList anchorPointList; 
	public AnchorPointList getAnchorPointList() {
		return anchorPointList;
	}

	public DrawspacePanel() {
		this.setLayout(null);
		this.setPreferredSize(new Dimension(400,300));
		this.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK), BorderFactory.createEmptyBorder(5, 10, 5, 10)));
		this.addMouseListener(this);
	}
	
	public DrawspacePanel(AnchorPointList anchorPointList) {
		this.setPreferredSize(new Dimension(400,300));
		this.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK), BorderFactory.createEmptyBorder(5, 10, 5, 10)));
		this.setLayout(null);				
		this.addMouseListener(this);
		this.anchorPointList = anchorPointList;
	}
	
	void addAnchorPoint(int x, int y) {
		if(anchorPointList.getAnchorPointList().size()>0)
			n = anchorPointList.getAnchorPointList().size();
		
		AnchorPoint tmpAnchorPoint = new AnchorPoint(x, y, n);
		//n++;
		tmpAnchorPoint.setParamPanel(paramPanel);
		tmpAnchorPoint.setBounds(x, y, 16, 16);
		this.add(tmpAnchorPoint);
		anchorPointList.addAnchorPointToAnchorPointList(tmpAnchorPoint);	
	}
	void addAnchor(Anchor anchor) {
		this.anchor = anchor;
		anchor.getMasterPoint().setBounds(anchor.getMasterPoint().getX(), anchor.getMasterPoint().getY(), 16, 16);
		this.add(anchor.getMasterPoint());
		revalidate();
		repaint();
		resultPanel.setAnchor(anchor);
	}

	public void paint(Graphics g) {
	 	super.paint(g);
		this.add(new JLabel(" "));
		for (int i=0; i<anchorPointList.getAnchorPointList().size();i++) {
			AnchorPoint tmp = anchorPointList.getAnchorPointList().get(i);
			tmp.setBounds(tmp.getX(), tmp.getY(), 16, 16);
			this.add(tmp);
		} 
		if(AnchorList.getInstance().getAnchorList().size()>0) {
			for(Anchor anchor : AnchorList.getInstance().getAnchorList()) {
				if(anchor != null) {
					g.drawLine(anchor.stAnchorPoint.getX()+(int)(0.5*anchor.stAnchorPoint.getWidth()), anchor.stAnchorPoint.getY()+anchor.stAnchorPoint.getHeight()
							, anchor.masterPoint.getX() + (int)(0.5*anchor.masterPoint.getWidth()), anchor.masterPoint.getY()); 
					g.drawLine(anchor.ndAnchorPoint.getX()+(int)(0.5*anchor.ndAnchorPoint.getWidth()), anchor.ndAnchorPoint.getY()+anchor.ndAnchorPoint.getHeight()
					, anchor.masterPoint.getX() + (int)(0.5*anchor.masterPoint.getWidth()), anchor.masterPoint.getY());
				}
			}
		}
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
