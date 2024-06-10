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
import javax.swing.SwingConstants;

import pl.edu.pw.fizyka.pojava.wmk.Anchor.AnchorMaterial;
//Author: Adam Pempkowiak
public class AddAnchorWindow extends JFrame implements Runnable {
     private TopPanel topPanel;
     private CenterPanel centerPanel;
     private BottomPanel bottomPanel;
     JPanel topCenterPanel;
     JPanel bottomCenterPanel;
     JLabel message;
     JLabel infoLabel;
     JButton addAnchor;
     JButton cancel;
     JLabel errorMessageLabel;
     JLabel anchorMaterialLabel;
     JLabel chosenTypeLabel;

     LanguageChange languageChange;
     Locale locale;
     ResourceBundle messages;
     AnchorPointList anchorPointList;
     String chosenMaterial, chosenType = null;
     DrawspacePanel drawspace;
     ArrayList<Integer> chosenPoints = new ArrayList<>();
     AnchorMaterial anchorMaterial;

    public AddAnchorWindow(Locale locale, DrawspacePanel drawspace) {
        this.locale = locale;
        this.drawspace = drawspace;
        this.anchorPointList = drawspace.getAnchorPointList();
        messages = ResourceBundle.getBundle("pl/edu/pw/fizyka/pojava/lang/messages", locale);
    }

  
    @Override
    public void run() {
        this.setAlwaysOnTop(true);
        
        this.setSize(480, 360);
        this.setBackground(ColorScheme.getColorScheme()[0]);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLayout(new GridLayout(3, 1));
        topPanel = new TopPanel();
        bottomPanel = new BottomPanel();
        centerPanel = new CenterPanel();
        
        this.add(topPanel);        
        this.add(centerPanel);       
        this.add(bottomPanel);
        
        this.setVisible(true);
    }

    public class TopPanel extends JPanel {
        public TopPanel() {
            message = new JLabel(messages.getString("choosePointsForAnchorMessage"), SwingConstants.CENTER);
            message.setForeground(ColorScheme.getColorScheme()[2]);
            this.add(message);
            this.setLayout(new GridLayout(anchorPointList.getAnchorPointList().size() + 1, 1));
            this.setBackground(ColorScheme.getColorScheme()[0]);
            this.setForeground(ColorScheme.getColorScheme()[3]);
            infoLabel = new JLabel();
            infoLabel.setForeground(ColorScheme.getColorScheme()[2]);
            this.add(infoLabel);

            for (int i = 0; i < anchorPointList.getAnchorPointList().size(); i++) {
                JButton button = new JButton("point number " + Integer.toString(1 + anchorPointList.getAnchorPointList().get(i).getN()));
                int n = i;
                ActionListener listener = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        chosenPoints.add(n);

                        if (chosenPoints.size() > 1)
                            infoLabel.setText(messages.getString("chosenPointsMessage") + Integer.toString(1 + chosenPoints.get(chosenPoints.size() - 1)) + " " + Integer.toString(1 + chosenPoints.get(chosenPoints.size() - 2)));
                    }
                };
                button.addActionListener(listener);
                this.add(button);
            }
        }
    }

    public class CenterPanel extends JPanel {
        public CenterPanel() {
            topCenterPanel = new JPanel(new FlowLayout());
            bottomCenterPanel = new JPanel(new FlowLayout());

            this.setLayout(new BorderLayout());
            this.add(topCenterPanel, BorderLayout.PAGE_START);
            this.add(bottomCenterPanel, BorderLayout.PAGE_END);
            this.setBackground(ColorScheme.getColorScheme()[0]);
            this.setForeground(ColorScheme.getColorScheme()[2]);
            topCenterPanel.setBackground(ColorScheme.getColorScheme()[0]);
            topCenterPanel.setForeground(ColorScheme.getColorScheme()[2]);
            bottomCenterPanel.setBackground(ColorScheme.getColorScheme()[0]);
            bottomCenterPanel.setForeground(ColorScheme.getColorScheme()[2]);
            anchorMaterialLabel = new JLabel(messages.getString("anchorMaterialLabelMessage"));
            anchorMaterialLabel.setForeground(ColorScheme.getColorScheme()[2]);
            topCenterPanel.add(anchorMaterialLabel);
            String anchorMaterials[] = {messages.getString("cordelette7mm"), messages.getString("sling")};
            JComboBox<String> comboBox = new JComboBox<>(anchorMaterials);
            ActionListener chosenMaterialListener = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    chosenMaterial = (String) comboBox.getSelectedItem();
                }
            };
            comboBox.addActionListener(chosenMaterialListener);
            chosenTypeLabel = new JLabel(messages.getString("chosenAnchorTypeMessage"));
            bottomCenterPanel.add(chosenTypeLabel);
            topCenterPanel.add(comboBox);
            String anchorTypes[] = {messages.getString("selfEqWithMX"), messages.getString("selfEGWithoutMX")};
            JComboBox<String> anchorTypeComboBox = new JComboBox<>(anchorTypes);
            ActionListener chosenTypeListener = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    chosenType = (String) anchorTypeComboBox.getSelectedItem();
                }
            };
            anchorTypeComboBox.addActionListener(chosenTypeListener);
            bottomCenterPanel.add(anchorTypeComboBox);
        }
    }

    public class BottomPanel extends JPanel {
        public BottomPanel() {
            this.setLayout(new FlowLayout());
            errorMessageLabel = new JLabel();
            this.setBackground(ColorScheme.getColorScheme()[0]);
            this.setForeground(ColorScheme.getColorScheme()[2]);
            this.add(errorMessageLabel);
            cancel = new JButton(messages.getString("cancelMessage"));
            cancel.setBackground(ColorScheme.getColorScheme()[3]);
            cancel.setForeground(ColorScheme.getColorScheme()[2]);

            cancel.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                }
            });
            this.add(cancel);
            addAnchor = new JButton(messages.getString("addAnchorButtonMessage"));
            addAnchor.setBackground(ColorScheme.getColorScheme()[3]);
            addAnchor.setForeground(ColorScheme.getColorScheme()[2]);
            ActionListener addAnchorListener = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (chosenPoints.size() > 1 && chosenMaterial != null) {
                        drawspace.addAnchor(new Anchor(anchorPointList.getAnchorPointList().get(chosenPoints.get(chosenPoints.size() - 1)),
                                anchorPointList.getAnchorPointList().get(chosenPoints.get(chosenPoints.size() - 2)), chosenMaterial, chosenType, anchorPointList));
                        
                        dispose();
                    } else {
                        errorMessageLabel.setText(messages.getString("errorMessageLabel"));
                    }
                }
            };
            addAnchor.addActionListener(addAnchorListener);
            this.add(addAnchor);
        }
    }

    public void changeWindowColor() {
        if (topPanel != null) {
            topPanel.setBackground(ColorScheme.getColorScheme()[0]);
            topPanel.setForeground(ColorScheme.getColorScheme()[2]);
            addAnchor.setBackground(ColorScheme.getColorScheme()[3]);
            addAnchor.setForeground(ColorScheme.getColorScheme()[2]);
            cancel.setBackground(ColorScheme.getColorScheme()[3]);
            cancel.setForeground(ColorScheme.getColorScheme()[2]);
            message.setForeground(ColorScheme.getColorScheme()[2]);
            message.setForeground(ColorScheme.getColorScheme()[2]);
            infoLabel.setForeground(ColorScheme.getColorScheme()[2]);
            topCenterPanel.setBackground(ColorScheme.getColorScheme()[0]);
            topCenterPanel.setForeground(ColorScheme.getColorScheme()[2]);
            bottomCenterPanel.setBackground(ColorScheme.getColorScheme()[0]);
            bottomCenterPanel.setForeground(ColorScheme.getColorScheme()[2]);
            addAnchor.setBackground(ColorScheme.getColorScheme()[3]);
            addAnchor.setForeground(ColorScheme.getColorScheme()[2]);
            bottomPanel.setBackground(ColorScheme.getColorScheme()[0]);
            centerPanel.setBackground(ColorScheme.getColorScheme()[0]);
            anchorMaterialLabel.setForeground(ColorScheme.getColorScheme()[2]);
            chosenTypeLabel.setForeground(ColorScheme.getColorScheme()[2]);
            repaint();
        }
    }
}