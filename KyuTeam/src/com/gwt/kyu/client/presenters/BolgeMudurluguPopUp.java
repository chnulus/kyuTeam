package com.gwt.kyu.client.presenters;

import java.util.ArrayList;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.gwt.kyu.shared.BolgeMudurlugu;

public class BolgeMudurluguPopUp extends VerticalPanel{

	
	public BolgeMudurluguPopUp(ArrayList<BolgeMudurlugu>bmList,PopupPanel container) {
		// TODO Auto-generated constructor stub
		
		
		add(new HTML("<div id='headerBm'>"+"Bolge Mudurlugu"+"</div>"));
		
		container.addStyleName("BmBody");
		
		TextBox t1 = new TextBox();
		t1.addStyleName("srchTxt");
		add(new HTML("<div id='srchTxt'></div>"));
		
		add(t1);
		
		//RootPanel.get("srchTxt").add(t1);
		
	}
	
}
