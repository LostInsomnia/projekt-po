package pl.edu.pw.fizyka.pojava.wmk;

import java.util.ArrayList;
import java.util.List;

//Made by: Adam Pempkowiak, 
public class AnchorPointList {
	List <AnchorPoint> anchorPointList = new ArrayList<>();
	public AnchorPointList() {
		anchorPointList.clear();
	}
	public List<AnchorPoint> getAnchorPointList() {
		return anchorPointList;
	}
	public void setAnchorPointList(List<AnchorPoint> anchorPointList) {
		this.anchorPointList = anchorPointList;
	}
	public void addAnchorPointToAnchorPointList(AnchorPoint anchorPoint) {
		anchorPointList.add(anchorPoint);		
	}
}
