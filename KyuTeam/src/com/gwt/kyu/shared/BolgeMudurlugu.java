package com.gwt.kyu.shared;

import java.util.ArrayList;

public class BolgeMudurlugu {
	
	
	private String BolgeMudKodu;
	private String BolgeMud;
		
	public String getBolgeMudKodu() {
		return BolgeMudKodu;
	}
	public void setBolgeMudKodu(String bolgeMudKodu) {
		BolgeMudKodu = bolgeMudKodu;
	}
	public String getBolgeMud() {
		return BolgeMud;
	}
	public void setBolgeMud(String bolgeMud) {
		BolgeMud = bolgeMud;
	}
	
	public ArrayList<BolgeMudurlugu> getBolgeMudulurlukList(){
		
		ArrayList<BolgeMudurlugu> bolgeList = new ArrayList<BolgeMudurlugu>();
		
		BolgeMudurlugu bm;
		
		for (int i = 0; i < 20; i++) {
			
			bm = new BolgeMudurlugu();
			
			bm.setBolgeMudKodu("20"+String.valueOf(i));
			bm.setBolgeMud("a"+String.valueOf(i));
			
			bolgeList.add(bm);
		}
		
		return bolgeList;
	}

}
