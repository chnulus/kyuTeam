package com.gwt.kyu.client.views;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.gwt.kyu.client.presenters.DetailPresenter;
import com.gwt.kyu.shared.Person;

public class DetailView extends Composite implements DetailPresenter.Display{

	DetailPresenter detail_presenter;
	
	private static DetailViewUiBinder uiBinder = GWT
			.create(DetailViewUiBinder.class);

	interface DetailViewUiBinder extends UiBinder<Widget, DetailView> {
	}

	public DetailView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setDetailPresenter(DetailPresenter detail_presenter) {
		// TODO Auto-generated method stub
		
		this.detail_presenter = detail_presenter;
		
	}

	@UiField
	Label userLbl;
	
	@UiField
	Button login;

	@Override
	public Button getExit() {
		// TODO Auto-generated method stub
		return exitBtn;
	}

	@Override
	public Label getLbl() {
		// TODO Auto-generated method stub
		return userLbl;
	}
	
	@UiField 
	Button exitBtn;

}
