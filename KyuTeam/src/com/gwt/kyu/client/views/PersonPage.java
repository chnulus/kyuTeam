package com.gwt.kyu.client.views;

import java.util.ArrayList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Widget;
import com.gwt.kyu.client.presenters.PersonPresenter;
import com.gwt.kyu.shared.Person;

public class PersonPage extends Composite implements PersonPresenter.Display{

	private static PersonPageUiBinder uiBinder = GWT
			.create(PersonPageUiBinder.class);

	interface PersonPageUiBinder extends UiBinder<Widget, PersonPage> {
	}
	PersonPresenter presenter;
	public PersonPage() {
		initWidget(uiBinder.createAndBindUi(this));
		
	}
	
	@UiField
	ListBox cityBox;
	
	@UiField
	CellTable<Person> cellTablePerson;
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		cellTablePerson.setRowCount(0);
	}

	@Override
	public void setPresenter(PersonPresenter personPresenter) {
		// TODO Auto-generated method stub
		this.presenter=personPresenter;
	}

	@Override
	public void fillTable(ArrayList<Person> personList) {
		// TODO Auto-generated method stub
		TextColumn<Person> nameColumn = new TextColumn<Person>() {
			@Override
			public String getValue(Person object) {
				return object.getPersonName();
			}
		};

		TextColumn<Person> surnameColumn = new TextColumn<Person>() {
			@Override
			public String getValue(Person object) {
				return object.getPersonSurname();
			}
		};

		TextColumn<Person> phoneColumn = new TextColumn<Person>() {
			@Override
			public String getValue(Person object) {
				return object.getPersonMail();
			}
		};
		cellTablePerson.addColumn(nameColumn, "Name");
		cellTablePerson.addColumn(surnameColumn, "Surname");
		cellTablePerson.addColumn(phoneColumn, "Phone Number");
		cellTablePerson.setRowCount(personList.size(), true);
		cellTablePerson.setRowData(0, personList);
	}

	@Override
	public ListBox getCityBox() {
		// TODO Auto-generated method stub
		return cityBox;
	}

	@UiField
	Label city;
	
	@Override
	public Label getlbl() {
		// TODO Auto-generated method stub
		return city;
	}

	@Override
	public HasClickHandlers getDetail() {
		// TODO Auto-generated method stub
		return detailBtn;
	}

	@UiField
	Button detailBtn;
	@Override
	public CellTable<Person> getSelectedObject() {
		// TODO Auto-generated method stub
		return cellTablePerson;
	}
	
}