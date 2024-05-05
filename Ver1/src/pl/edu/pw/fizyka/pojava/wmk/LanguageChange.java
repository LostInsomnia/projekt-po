package pl.edu.pw.fizyka.pojava.wmk;

import java.util.Locale;
// Author: Adam Pempkowiak
public class LanguageChange {
	Locale locale;
	ResultsPanel resultsPanel;
	BotPanel botPanel;
	TopMenuBar topMenuBar;
	ParamPanel paramPanel;
	
	public void setParamPanel(ParamPanel paramPanel) {
		this.paramPanel = paramPanel;
	}
	public void setBotPanel(BotPanel botPanel) {
		this.botPanel = botPanel;
	}
	public void setTopMenuBar(TopMenuBar topMenuBar) {
		this.topMenuBar = topMenuBar;
	}
	public void setResultsPanel(ResultsPanel resultsPanel) {
		this.resultsPanel = resultsPanel;
	}
	public LanguageChange()  {
		// TODO Auto-generated constructor stub
		
	}
	public void updateLanguageChoice(Locale locale) {
		resultsPanel.updateLanguageChoice(locale);
		botPanel.updateLanguageChoice(locale);
		topMenuBar.updateLanguageChoice(locale);
		paramPanel.updateLanguageChoice(locale);
	}
	public Locale getLocale() {
		return locale;
	}
}
