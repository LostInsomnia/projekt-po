package pl.edu.pw.fizyka.pojava.wmk;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AddAnchorWindow extends JFrame{
	public void setAnchorPointList(AnchorPointList anchorPointList) {
		this.anchorPointList = anchorPointList;
	}

	LanguageChange languageChange;
	Locale locale;
	ResourceBundle messages;
	AnchorPointList anchorPointList;
	int stChosenPoint, ndChosenPoint = -1;
	public AddAnchorWindow(Locale locale, AnchorPointList anchorPointList) {
		// TODO Auto-generated constructor stub
		this.setVisible(true);
		this.setSize(480,360);
		this.locale = locale;
		this.anchorPointList = anchorPointList;
		messages = ResourceBundle.getBundle("pl/edu/pw/fizyka/pojava/lang/messages", locale);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(new GridLayout(3, 1));
		TopPanel topPanel = new TopPanel();
		this.add(topPanel);
		
		CenterPanel centerPanel = new CenterPanel();
		this.add(centerPanel);
		BottomPanel bottomPanel = new BottomPanel();
		this.add(bottomPanel);
		}
	
	public class TopPanel extends JPanel{
		public TopPanel() {
			// TODO Auto-generated constructor stub
			this.add(new JLabel(messages.getString("choosePointsForAnchorMessage")));
			this.setLayout(new GridLayout(anchorPointList.getAnchorPointList().size()+1, 1));
			
			
			for(int i = 0; i<anchorPointList.getAnchorPointList().size(); i++) {
				JButton button = new JButton("point number " + Integer.toString(1+anchorPointList.getAnchorPointList().get(i).getN()));
				this.add(button);
			}
		}
	}
	
	public class CenterPanel extends JPanel{
		public CenterPanel() {
			// TODO Auto-generated constructor stub
			this.setLayout(new FlowLayout());
			JLabel anchorMaterialLabel = new JLabel(messages.getString("anchorMaterialLabelMessage"));
			this.add(anchorMaterialLabel);
			
		}
	}
	
	public class BottomPanel extends JPanel{
		public BottomPanel() {
			// TODO Auto-generated constructor stub
			this.setLayout(new FlowLayout());
			JButton cancel = new JButton(messages.getString("cancelMessage"));
			this.add(cancel);
			JButton addAnchor = new JButton(messages.getString("addAnchorButtonMessage"));
			this.add(addAnchor);
		}
	}
}
