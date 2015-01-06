package com.gwt.kyu.client.presenters;

import java.util.ArrayList;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.UIObject;
import com.google.gwt.user.client.ui.Widget;
import com.gwt.kyu.shared.BolgeMudurlugu;

public class BMDialog implements ClickHandler{

	ArrayList<BolgeMudurlugu> bmList = new ArrayList<BolgeMudurlugu>();
	
	public BMDialog(ArrayList<BolgeMudurlugu>bmList) {
		// TODO Auto-generated constructor stub
		this.bmList = bmList;
	}
	
	
	@Override
	public void onClick(ClickEvent event) {
		// TODO Auto-generated method stub
		
		try{
			DialogBox dialog = new DialogBox(true);
			
			//String text ="Pop Up";
			
			Widget sampleContent = new BolgeMudurluguPopUp(bmList,dialog);
			
			dialog.setWidget(sampleContent);
			
		//	dialog.setText("Dialog Box");
			
			
			UIObject button = (UIObject)event.getSource();
			
			int x = button.getAbsoluteLeft()-200;
			
			int y = button.getAbsoluteTop()-100;
			
			dialog.setPopupPosition(x, y);
			
			dialog.setAnimationEnabled(true);
			
			dialog.setWidth("500px");
			dialog.setHeight("300px");
			
			dialog.show();
			
			}catch(Exception ex){
				Window.alert("HATA!!!");
			}
		
	}

}
