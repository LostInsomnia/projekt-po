package pl.edu.pw.fizyka.pojava.wmk;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
//Author: Adam Pempkowiak
public class Anchor {
	AnchorPoint stAnchorPoint, ndAnchorPoint, masterPoint;
	String material;
	float brakingStrength,  parameterK, length;
	AnchorPointList anchorPointList;
	AnchorMaterial anchorMaterial;
	enum AnchorMaterial{
		cordelette7mm,
		sling
	}
	
	
	public Anchor(AnchorPoint stAnchorPoint, AnchorPoint ndAnchorPoint, String material, AnchorPointList anchorPointList) {
		// TODO Auto-generated constructor stub
		this.stAnchorPoint = stAnchorPoint;
		this.ndAnchorPoint = ndAnchorPoint;
		this.material = material;
		
		this.anchorPointList = anchorPointList;
		setMaterialParameters(material);
		setMasterPointParameters();
	}
	void setMaterialParameters(String material) {
		System.out.print(material);
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
	}
	void setMasterPointParameters() {
		masterPoint = new AnchorPoint(0, 0, anchorPointList.getAnchorPointList().size());
		masterPoint.setX((int)(0.5*(stAnchorPoint.getX()+ndAnchorPoint.getX())));
		masterPoint.setY(Math.max((int)(0.5*(stAnchorPoint.getY()+ndAnchorPoint.getY())+200), (int)(0.5*(stAnchorPoint.getY()+ndAnchorPoint.getY()))));
		masterPoint.setIsMaster(true);
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
