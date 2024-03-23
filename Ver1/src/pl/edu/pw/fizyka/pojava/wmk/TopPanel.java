package pl.edu.pw.fizyka.pojava.wmk;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class TopPanel extends JPanel {
	TopPanel(){
		this.setLayout(new FlowLayout());
		JButton addPoint = new JButton("add point");
		this.add(addPoint);
		JButton addAnchor = new JButton("add Anchor");
		this.add(addAnchor);
		JButton colorMode = new JButton("dark/light");
		this.add(colorMode);
		JButton language = new JButton("change language");
		this.add(language);
	}
	
}
