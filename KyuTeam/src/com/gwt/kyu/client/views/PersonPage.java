package com.gwt.kyu.client.views;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.gwt.kyu.client.presenters.PersonPresenter;
import com.gwt.kyu.shared.Person;
import com.gwt.kyu.shared.Region;

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
	
	
	ButtonCell PreviewButton;
	
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

	
	@UiField
	Button bolgeMudurlugu;
	@Override
	public Button getbolgeMudurlugu() {
		// TODO Auto-generated method stub
		return bolgeMudurlugu;
	}
	
	
	@UiField
	SimplePager bmPager;
	@Override
	public SimplePager getSimplePager() {
		// TODO Auto-generated method stub
		return bmPager;
	}
	
	@UiField
	Button btnControl;
	@Override
	public Button getControl() {
		// TODO Auto-generated method stub
		return btnControl;
	}
	
	@UiField
	CellTable<Region> cellRegionTable;
	@Override
	public CellTable<Region> getRegionTable() {
		// TODO Auto-generated method stub
		return cellRegionTable;
	}

	@UiField 
	TextBox srchTxt;
	@Override
	public TextBox getSrchTxt() {
		// TODO Auto-generated method stub
		return srchTxt;
	}

	
	@UiField
	Button srchBtn;
	@Override
	public Button getSrchBtn() {
		// TODO Auto-generated method stub
		return srchBtn;
	}

	@UiField
	SimplePager regionPager;
	
	@Override
	public SimplePager getRegionPager() {
		// TODO Auto-generated method stub
		return regionPager;
	}
	


	
}
