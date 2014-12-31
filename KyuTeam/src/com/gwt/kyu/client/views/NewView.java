package com.gwt.kyu.client.views;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.Widget;
import com.gwt.kyu.client.presenters.NewPresenter;

public class NewView extends Composite implements NewPresenter.Display{

	private static NewViewUiBinder uiBinder = GWT.create(NewViewUiBinder.class);

	interface NewViewUiBinder extends UiBinder<Widget, NewView> {
	}

	public NewView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	NewPresenter new_presenter;
	
	@UiField
	MenuItem fileBtn;
	
	@UiField
	MenuItem newBtn;
	
	@UiField
	MenuItem openBtn;
	
	@UiField
	MenuItem exitBtn;
	
	@UiField
	Button clickBtn;
	
	
	
	
	@Override
	public void setPresenter(NewPresenter new_presenter) {
		// TODO Auto-generated method stub
		this.new_presenter = new_presenter;
	}



	@Override
	public MenuItem getFile() {
		// TODO Auto-generated method stub
		return fileBtn;
	}



	@Override
	public MenuItem getNew() {
		// TODO Auto-generated method stub
		return newBtn;
	}



	@Override
	public MenuItem getOpen() {
		// TODO Auto-generated method stub
		return openBtn;
	}



	@Override
	public MenuItem getExit() {
		// TODO Auto-generated method stub
		return exitBtn;
	}



	@Override
	public Button getClick() {
		// TODO Auto-generated method stub
		return clickBtn;
	}

}
