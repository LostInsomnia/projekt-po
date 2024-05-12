package pl.edu.pw.fizyka.pojava.wmk;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
//Author: Adam Pempkowiak
public class AddAnchorWindow extends JFrame{
	public void setAnchorPointList(AnchorPointList anchorPointList) {
		this.anchorPointList = anchorPointList;
	}

	LanguageChange languageChange;
	Locale locale;
	ResourceBundle messages;
	AnchorPointList anchorPointList;
	String chosenMaterial, chosenType = null;
	DrawspacePanel drawspace;
	ArrayList<Integer> chosenPoints = new ArrayList<>();
	AnchorMaterial anchorMaterial;
	enum AnchorMaterial{
		cordelette7mm,
		sling
	}
	
	public AddAnchorWindow(Locale locale, DrawspacePanel drawspace) {
		// TODO Auto-generated constructor stub
		this.setVisible(true);
		this.setSize(480,360);
		this.locale = locale;
		this.drawspace = drawspace;
		this.anchorPointList = drawspace.getAnchorPointList();
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
			JLabel infoLabel = new JLabel();
			this.add(infoLabel);
			
			for(int i = 0; i<anchorPointList.getAnchorPointList().size(); i++) {
				JButton button = new JButton("point number " + Integer.toString(1+anchorPointList.getAnchorPointList().get(i).getN()));
				int n=i;
				ActionListener listener = new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
							chosenPoints.add(n);			
						
							if(chosenPoints.size()>1)
								infoLabel.setText(messages.getString("chosenPointsMessage") + Integer.toString(1+chosenPoints.get(chosenPoints.size()-1))+" "+Integer.toString(1+chosenPoints.get(chosenPoints.size()-2)));
					}
				};
				button.addActionListener(listener);
				this.add(button);
			}
		}
	}
	
	public class CenterPanel extends JPanel{
		public CenterPanel() {
			// TODO Auto-generated constructor stub
			JPanel topPanel = new JPanel(new FlowLayout());
			JPanel bottomPanel = new JPanel(new FlowLayout());
			
			this.setLayout(new BorderLayout());
			this.add(topPanel, BorderLayout.PAGE_START);
			this.add(bottomPanel, BorderLayout.PAGE_END);
			JLabel anchorMaterialLabel = new JLabel(messages.getString("anchorMaterialLabelMessage"));
			topPanel.add(anchorMaterialLabel);
			String anchorMaterials[]= {messages.getString("cordelette7mm"),messages.getString("sling")};
			JComboBox comboBox = new JComboBox(anchorMaterials);
			ActionListener chosenMaterialListener = new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					chosenMaterial = (String) comboBox.getSelectedItem();
					//anchorMaterialLabel.setText(chosenMaterial);
					
				}
			};
			comboBox.addActionListener(chosenMaterialListener);
			JLabel chosenTypeLabel = new JLabel(messages.getString("chosenAnchorTypeMessage"));
			bottomPanel.add(chosenTypeLabel);
			topPanel.add(comboBox);
			String anchorTypes[] = {messages.getString("selfEqWithMX"), messages.getString("selfEGWithoutMX")};
			JComboBox anchorTypeComboBox = new JComboBox(anchorTypes);
			ActionListener chosenTypeListener = new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					chosenType = (String) anchorTypeComboBox.getSelectedItem();
					
				}
			};
			anchorTypeComboBox.addActionListener(chosenTypeListener);
			bottomPanel.add(anchorTypeComboBox);
			
		}
	}
	
	public class BottomPanel extends JPanel{
		public BottomPanel() {
			// TODO Auto-generated constructor stub
			this.setLayout(new FlowLayout());
			JLabel errorMessageLabel = new JLabel();
			this.add(errorMessageLabel);
			JButton cancel = new JButton(messages.getString("cancelMessage"));
			cancel.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					dispose();
				}
			});
			this.add(cancel);
			JButton addAnchor = new JButton(messages.getString("addAnchorButtonMessage"));
			ActionListener addAnchorListener = new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(chosenPoints.size()>1 && chosenMaterial!=null) {
					drawspace.addAnchor(new Anchor(anchorPointList.getAnchorPointList().get(chosenPoints.get(chosenPoints.size()-1)), 
							anchorPointList.getAnchorPointList().get(chosenPoints.get(chosenPoints.size()-2)), chosenMaterial, anchorPointList));
					dispose();
					}
					else {
						errorMessageLabel.setText(messages.getString("errorMessageLabel"));
					}
				}
			};
			addAnchor.addActionListener(addAnchorListener);
			this.add(addAnchor);
		}
	}
}
