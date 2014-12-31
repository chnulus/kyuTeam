package com.gwt.kyu.client.presenters;

import java.util.ArrayList;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwt.kyu.shared.Student;

public class NewPresenter implements Presenter {

	Display view;

	Student student;

	ArrayList<Student> studentList;

	public interface Display {

		public void setPresenter(NewPresenter new_presenter);

		public Widget asWidget();

		public MenuItem getFile();

		public MenuItem getNew();

		public MenuItem getOpen();

		public MenuItem getExit();
		
		public Button getClick();

	}

	public NewPresenter(Student student, ArrayList<Student> studentList,
			Display view) {

		this.student = student;

		this.studentList = studentList;

		this.view = view;
		
		bind();

	}

	@Override
	public void bind() {
		// TODO Auto-generated method stub

	
		Command cmdNew = new Command() {
			public void execute() {
				Window.alert("You selected a New item!");
			}
		};
		
		Command cmdOpen = new Command() {
			public void execute() {
				Window.alert("You selected a Open item!");
			}
		};
		
		Command cmdExit = new Command() {
			public void execute() {
				Window.alert("You selected a Exit item!");
			}
		};

		view.getOpen().setCommand(cmdOpen);
		view.getNew().setCommand(cmdNew);
		view.getExit().setCommand(cmdExit);


		view.getClick().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				PopupPanel popup=new PopupPanel(true);
			      popup.getElement().setAttribute("style","background-color:blue;width:200px;height:200px;");
			      popup.setWidget(new Label("OK"));
			      popup.setWidget(new Button("Save"));
			      popup.setStyleName("popup-hint");
			      popup.setPopupPosition(300,500);
			      popup.show();
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
