package com.gwt.kyu.client.presenters;

import java.util.ArrayList;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;
import com.google.gwt.view.client.SelectionChangeEvent.Handler;
import com.gwt.kyu.client.views.DetailView;
import com.gwt.kyu.shared.Person;

public class PersonPresenter implements Presenter {
	Display view;
	ArrayList<Person> personList;
	
	Presenter presenter;
	
	Person selectedObject;
	
	public final SingleSelectionModel<Person> ssm = new SingleSelectionModel<Person>();

	
	public interface Display{
		public void clear();
		public Widget asWidget();
		public void setPresenter(PersonPresenter personPresenter);
		public void fillTable(ArrayList<Person> personList);
		public ListBox getCityBox();
		public Label getlbl();
		public CellTable<Person> getSelectedObject();
		public HasClickHandlers getDetail();
	}
	 public PersonPresenter(ArrayList<Person> personList,Display view) {
		this.view=view;
		this.personList=personList;
		bind();
	}
	@Override
	public void bind() {
		// TODO Auto-generated method stub
	view.setPresenter(this);
	view.clear();
	view.fillTable(personList);	
	view.getSelectedObject().setSelectionModel(ssm);
	fillList();
	getSelectItem();
	
	ssm.addSelectionChangeHandler(new Handler() {

		@Override
		public void onSelectionChange(final SelectionChangeEvent event)

		{

			selectedObject = ssm.getSelectedObject();
		}

	});
	
	view.getDetail().addClickHandler(new ClickHandler() {
		
		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			try{
			
			 presenter = new DetailPresenter(selectedObject,new DetailView());
			 presenter.go(RootPanel.get());
			 
			}catch(Exception ex){
				Window.alert("Satir Sec!!!");
				
			}
			 }
	});
	
	}
	
	public void fillList(){
		
		ArrayList<String> city = new ArrayList<String>();
		
		city.add("Istanbul");
		city.add("Ankara");
		city.add("Izmir");
		city.add("Antalya");
		
		for(String cities: city){
			view.getCityBox().addItem(cities);
		}
		
	}

	
	public void getSelectItem(){
		
		view.getCityBox().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				view.getlbl().setText("City : "+view.getCityBox().getItemText(view.getCityBox().getSelectedIndex()));
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
