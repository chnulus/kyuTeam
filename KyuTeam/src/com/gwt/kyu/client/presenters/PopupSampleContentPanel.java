package com.gwt.kyu.client.presenters;

import java.util.ArrayList;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.SingleSelectionModel;
import com.gwt.kyu.shared.Person;

public class PopupSampleContentPanel extends VerticalPanel{
	
	CellTable<Person> personTable;
	
	public PopupSampleContentPanel(ArrayList<Person>personList,String text,final PopupPanel container) {
		// TODO Auto-generated constructor stub
		
		//setSpacing(5);
		setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		
		add(new HTML("<div id='title'>"+"Header"+"</div>"));
		add(new HTML("<div id='title2'>"+text+"</div>"));
			
		//SingleSelectionModel<Person> ssm = new SingleSelectionModel<Person>();

		try{
			
		personTable = new CellTable<Person>();
				
		getPersonInfo(personList);
		
		Button button = new Button("Close");
		
		container.addStyleName("body-dialogbox");
		
		button.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
			
				container.hide();
				
			}
		});
		add(button);
		add(personTable);
		
		}catch(Exception ex){
			Window.alert("Popup Hata");
		}
	}
	
	public void getPersonInfo(ArrayList<Person>personList){
		
		TextColumn<Person> nameColumn = new TextColumn<Person>() {
			@Override
			public String getValue(Person object) {
				return object.getPersonName();
			}
		};

		// Add a date column to show the birthday.
		TextColumn<Person> surNameColumn = new TextColumn<Person>() {
			@Override
			public String getValue(Person object) {
				return object.getPersonSurname();
			}
		};

		TextColumn<Person> mailColumn = new TextColumn<Person>() {
			@Override
			public String getValue(Person object) {
				return object.getPersonMail();
			}
		};

		personTable.addColumn(nameColumn, "Name");
		personTable.addColumn(surNameColumn, "Surname");
		personTable.addColumn(mailColumn,"Phone");

		personTable.setRowCount(personList.size(), true);

		// Push the data into the widget.
		personTable.setRowData(0, personList);
		
	}
	

}
