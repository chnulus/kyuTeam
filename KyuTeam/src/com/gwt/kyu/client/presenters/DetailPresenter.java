package com.gwt.kyu.client.presenters;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwt.kyu.client.views.PersonPage;
import com.gwt.kyu.shared.Person;

public class DetailPresenter implements Presenter{

	Display view;
	
	Person person;
	
	
	public interface Display{
		
		public Widget asWidget();
		public void setDetailPresenter(DetailPresenter detail_presenter);
		public HasClickHandlers getExit();
		public Label getLbl();
	
	}
	
	
	public DetailPresenter(Person person,Display view) {
		// TODO Auto-generated constructor stub
		System.out.print("1: "+person.getPersonMail());
		this.person = person;
		this.view = view;
		bind();
	}
	
	
	@Override
	public void bind() {
		// TODO Auto-generated method stub
		
		view.setDetailPresenter(this);
		view.getLbl().setText(person.getPersonName()+" "+person.getPersonSurname()+" "+person.getPersonMail());
		
		view.getExit().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				Presenter presenter = new PersonPresenter(person.addPersonList(),new PersonPage());
				presenter.go(RootPanel.get());
			}
		});
		
	}

	@Override
	public void go(HasWidgets container) {
		// TODO Auto-generated method stub
		container.clear();
		container.add(view.asWidget());
		
	}

}
