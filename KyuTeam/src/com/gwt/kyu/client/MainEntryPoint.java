package com.gwt.kyu.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.gwt.kyu.client.presenters.PersonPresenter;
import com.gwt.kyu.client.presenters.Presenter;
import com.gwt.kyu.client.views.PersonPage;
import com.gwt.kyu.shared.Person;

public class MainEntryPoint implements EntryPoint {
	@Override
	public void onModuleLoad() {
		// TODO Auto-generated method stub
		Person prsn=new Person();
		Presenter prsntr=new PersonPresenter(prsn.addPersonList(), new PersonPage());
		prsntr.go(RootPanel.get());
	}
}
