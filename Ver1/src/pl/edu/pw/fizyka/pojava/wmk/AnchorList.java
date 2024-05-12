package pl.edu.pw.fizyka.pojava.wmk;

import java.util.ArrayList;

public class AnchorList {
    
    private static AnchorList instance;
    ArrayList<Anchor> anchorList = new ArrayList<>();
    
    private AnchorList() {
        
    }

   
    public static AnchorList getInstance() {
        if (instance == null) {
            instance = new AnchorList();
        }
        return instance;
    }
    
    public ArrayList<Anchor> getAnchorList() {
		return anchorList;
	}

	public void setAnchorList(ArrayList<Anchor> anchorList) {
		this.anchorList = anchorList;
	}

}