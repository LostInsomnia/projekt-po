package pl.edu.pw.fizyka.pojava.wmk;

import java.util.Locale;

public class LanguageChange {
	Locale locale;
	ResultsPanel resultsPanel;
	public void setResultsPanel(ResultsPanel resultsPanel) {
		this.resultsPanel = resultsPanel;
	}
	public LanguageChange()  {
		// TODO Auto-generated constructor stub
		
	}
	public void updateLanguageChoice(Locale locale) {
		resultsPanel.updateLanguageChoice(locale);
	}
}
