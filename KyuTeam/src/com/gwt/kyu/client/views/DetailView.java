package com.gwt.kyu.client.views;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
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
	
	@UiField
	TextBox stuIDTxt;
	
	@UiField
	PasswordTextBox pwordTxt;
	
	

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
	
	@UiField
	Label errorMsg;

	@Override
	public Button getLogin() {
		// TODO Auto-generated method stub
		return login;
	}

	@Override
	public TextBox getStudentID() {
		// TODO Auto-generated method stub
		return stuIDTxt;
	}

	@Override
	public PasswordTextBox getPassword() {
		// TODO Auto-generated method stub
		return pwordTxt;
	}

	@Override
	public Label getErrorMsg() {
		// TODO Auto-generated method stub
		return errorMsg;
	}

}
