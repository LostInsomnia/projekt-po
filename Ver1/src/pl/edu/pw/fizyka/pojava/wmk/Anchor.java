package pl.edu.pw.fizyka.pojava.wmk;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class Anchor {
	AnchorPoint stAnchorPoint, ndAnchorPoint, masterPoint;
	String material;
	AnchorPointList anchorPointList;
	
	public Anchor(AnchorPoint stAnchorPoint, AnchorPoint ndAnchorPoint, String material, AnchorPointList anchorPointList) {
		// TODO Auto-generated constructor stub
		this.stAnchorPoint = stAnchorPoint;
		this.ndAnchorPoint = ndAnchorPoint;
		this.material = material;
		this.anchorPointList = anchorPointList;
	}
	private void setMasterPointParameters() {
		AnchorPoint masterPoint = new AnchorPoint(0, 0, anchorPointList.getAnchorPointList().size());
		masterPoint.setX((int)(0.5*(stAnchorPoint.getX()+ndAnchorPoint.getX())));
		masterPoint.setY(Math.max((int)(0.5*(stAnchorPoint.getY()+ndAnchorPoint.getY())), (int)(0.5*(stAnchorPoint.getY()+ndAnchorPoint.getY()))));
		anchorPointList.addAnchorPointToAnchorPointList(masterPoint);
	}
	public AnchorPoint getStAnchorPoint() {
		return stAnchorPoint;
	}
	public void setStAnchorPoint(AnchorPoint stAnchorPoint) {
		this.stAnchorPoint = stAnchorPoint;
	}
	public AnchorPoint getNdAnchorPoint() {
		return ndAnchorPoint;
	}
	public void setNdAnchorPoint(AnchorPoint ndAnchorPoint) {
		this.ndAnchorPoint = ndAnchorPoint;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public AnchorPoint getMasterPoint() {
		return masterPoint;
	}
	
	
}
