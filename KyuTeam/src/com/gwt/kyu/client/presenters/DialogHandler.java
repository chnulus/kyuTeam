package com.gwt.kyu.client.presenters;

import java.util.ArrayList;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.UIObject;
import com.google.gwt.user.client.ui.Widget;
import com.gwt.kyu.shared.Person;

public class DialogHandler implements ClickHandler{

	
	ArrayList<Person> personList = new ArrayList<Person>();
	
	public DialogHandler(ArrayList<Person>personList) {
		// TODO Auto-generated constructor stub
		this.personList = personList;
	}
	
	@Override
	public void onClick(ClickEvent event) {
		// TODO Auto-generated method stub
		try{
		DialogBox dialog = new DialogBox(true);
		
		String text ="Pop Up";
		
		Widget sampleContent = new PopupSampleContentPanel(personList,text,dialog);
		
		dialog.setWidget(sampleContent);
		
	//	dialog.setText("Dialog Box");
		
		
		UIObject button = (UIObject)event.getSource();
		
		int x = button.getAbsoluteLeft()-200;
		
		int y = button.getAbsoluteTop()+200;
		
		dialog.setPopupPosition(x, y);
		
		dialog.setAnimationEnabled(true);
		
		dialog.setWidth("350px");
		
		dialog.show();
		
		}catch(Exception ex){
			Window.alert("HATA!!!");
		}
	}

}
