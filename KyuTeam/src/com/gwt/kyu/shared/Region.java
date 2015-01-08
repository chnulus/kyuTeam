package com.gwt.kyu.shared;

import java.util.ArrayList;

public class Region {
	
	
	private String RegionID;
	private String RegionName;
	
	ArrayList<Region> regionList;
	
	public String getRegionID() {
		return RegionID;
	}
	public void setRegionID(String regionID) {
		RegionID = regionID;
	}
	public String getRegionName() {
		return RegionName;
	}
	public void setRegionName(String regionName) {
		RegionName = regionName;
	}
	
	public ArrayList<Region> getRegionList(){
		
		regionList = new ArrayList<Region>();
		
		Region region;
		
		for (int i = 0; i < 200; i++) {
			
			region = new Region();
			
			region.setRegionID(String.valueOf(100+i));
			region.setRegionName("Kurumsal"+i);
			
			regionList.add(region);
			
		}
		
		return regionList;
		
	}
	

}
