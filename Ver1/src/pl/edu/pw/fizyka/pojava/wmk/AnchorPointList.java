package pl.edu.pw.fizyka.pojava.wmk;

import java.util.ArrayList;
import java.util.List;

//Made by: Adam Pempkowiak, 
//Color change: Kacper Szymczak
public class AnchorPointList {
	List <AnchorPoint> anchorPointList = new ArrayList<AnchorPoint>();
	public AnchorPointList() {
		anchorPointList.clear();
	}
	public List<AnchorPoint> getAnchorPointList() {
		return anchorPointList;
	}
	public void setAnchorPointList(List<AnchorPoint> tempanchorPointList) {
		anchorPointList = tempanchorPointList;
	}
	public void addAnchorPointToAnchorPointList(AnchorPoint anchorPoint) {
		anchorPointList.add(anchorPoint);		
	}
	public void changeAllPoints() {
		for(int i = 0; i<anchorPointList.size(); i++) {
			anchorPointList.get(i).changePointColor();
		}
		
	}
	public void clearList() {
		try {
			anchorPointList.clear();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
