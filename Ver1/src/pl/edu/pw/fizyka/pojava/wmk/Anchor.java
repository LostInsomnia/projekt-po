package pl.edu.pw.fizyka.pojava.wmk;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
//Author: Adam Pempkowiak
public class Anchor {
	AnchorPoint stAnchorPoint, ndAnchorPoint, masterPoint;
	String material, anchorType;
	float brakingStrength, forceOnAnchor, parameterK, length;
	
	double F1, F2;
	String anchorFailed = "";
	AnchorPointList anchorPointList;
	
	public float getBrakingStrength() {
		return brakingStrength;
	}

	AnchorMaterial anchorMaterial;
	enum AnchorMaterial{
		cordelette7mm,
		sling
	}
	
	
	public Anchor(AnchorPoint stAnchorPoint, AnchorPoint ndAnchorPoint, String material, String anchorType, AnchorPointList anchorPointList) {
		// TODO Auto-generated constructor stub
		this.stAnchorPoint = stAnchorPoint;
		this.ndAnchorPoint = ndAnchorPoint;
		this.material = material;
		this.anchorType = anchorType;
		//stAnchorPoint.setIsMaster(false);
		//ndAnchorPoint.setIsMaster(false);
		stAnchorPoint.setDegree(Math.max(stAnchorPoint.getDegree(), ndAnchorPoint.getDegree()));
		ndAnchorPoint.setDegree(Math.max(stAnchorPoint.getDegree(), ndAnchorPoint.getDegree()));
		
		this.anchorPointList = anchorPointList;
		setMaterialParameters(material);
		setMasterPointParameters(Math.max(stAnchorPoint.getDegree(), ndAnchorPoint.getDegree()));
		AnchorList.getInstance().getAnchorList().add(this);	
		}
	void setMaterialParameters(String material) {
		if (material.equals("linka 7mm wed\u0142ug normy EN 564:2014")|| material.equals("Standard EN 564:2014 7 mm cordelette") || material.equals("linka 7mm wed\\u0142ug normy EN 564:2014")) {
			anchorMaterial = AnchorMaterial.cordelette7mm;
		}
		if (material.equals("ta\\u015Bma wed\\u0142ug normy EN 566:2017")|| material.equals("Standard EN 566:2017 sling") || material.equals("taśma według normy EN 566:2017")) {
			anchorMaterial = AnchorMaterial.sling;
		}
		FileInputStream file = null;
		 try {
			String basePath = new File("").getAbsolutePath();
			file = new FileInputStream(basePath+"/pl/edu/pw/fizyka/pojava/wmk/config/AnchorMaterialParameters"+anchorMaterial.name()+".properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Properties properties = new Properties();
		try {
			properties.load(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		brakingStrength = Float.parseFloat(properties.getProperty("brakingStrength")) ;
		parameterK =  Float.parseFloat(properties.getProperty("parameterK"));
		System.out.print(brakingStrength);
	}
	public AnchorMaterial getAnchorMaterial() {
		return anchorMaterial;
	}
	void checkIfAnchorFailed() {
		forceOnAnchor = Math.max(stAnchorPoint.getForceOnPoint(), ndAnchorPoint.getForceOnPoint());
		if (brakingStrength<= stAnchorPoint.getForceOnPoint() && brakingStrength<=ndAnchorPoint.getForceOnPoint())
			anchorFailed = "+";
		if (brakingStrength<= stAnchorPoint.getForceOnPoint() || brakingStrength<=ndAnchorPoint.getForceOnPoint()) {
			if (anchorType.equals("selfEqWithMX"))
				anchorFailed = "+/-";
			if (anchorType.equals("selfEqWithoutMX"))
				anchorFailed = "+";
		}
			 
		if (!(brakingStrength<= stAnchorPoint.getForceOnPoint() && brakingStrength<=ndAnchorPoint.getForceOnPoint()))
			anchorFailed = "-"; 
		
	}
	public float getForceOnAnchor() {
		return forceOnAnchor;
	}
	public String getAnchorFailed() {
		return anchorFailed;
	}
	void setMasterPointParameters(int degree) {
		masterPoint = new AnchorPoint(0, 0, anchorPointList.getAnchorPointList().size());
		masterPoint.setX((int)(0.5*(stAnchorPoint.getX()+ndAnchorPoint.getX())));
		masterPoint.setY(Math.max((int)(0.5*(stAnchorPoint.getY()+ndAnchorPoint.getY())+200), (int)(0.5*(stAnchorPoint.getY()+ndAnchorPoint.getY()))));
		masterPoint.setIsMaster(true);
		anchorPointList.addAnchorPointToAnchorPointList(masterPoint);
		masterPoint.setDegree(degree+1);
	}
	
	public void calculateResults(double F) {
		int x1 = this.getStAnchorPoint().getX();
		int y1 = this.getStAnchorPoint().getY();
		int x2 = this.getNdAnchorPoint().getX();
		int y2 = this.getNdAnchorPoint().getY();
		int xc = this.getMasterPoint().getX();
		int yc = this.getMasterPoint().getY();
		
		double r13 = Math.sqrt((xc - x1) * (xc - x1) + (yc - y1) * (yc - y1));
        double r23 = Math.sqrt((xc - x2) * (xc - x2) + (yc - y2) * (yc - y2));

        double ux13 = (xc - x1) / r13;
        double uy13 = (yc - y1) / r13;
        double ux23 = (xc - x2) / r23;
        double uy23 = (yc - y2) / r23;

        double denominator = uy13 - ((ux13 * uy23 * r23) / (ux23 * r13));
        F1 = F / denominator;

        F2 = -F1 * (ux13 * r23) / (ux23 * r13);
        stAnchorPoint.setForceOnPoint((float) F1);
        ndAnchorPoint.setForceOnPoint((float) F2);
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
	
	public void saveData() {
		
	}
	
	
}
