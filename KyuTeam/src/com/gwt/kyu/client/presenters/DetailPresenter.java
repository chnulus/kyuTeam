package com.gwt.kyu.client.presenters;

import java.util.ArrayList;

import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.gwt.kyu.client.views.NewView;
import com.gwt.kyu.client.views.PersonPage;
import com.gwt.kyu.shared.Person;
import com.gwt.kyu.shared.Student;

public class DetailPresenter implements Presenter {

	Display view;

	Person person;
	
	Student student;

	ArrayList<Student> studentList = new ArrayList<Student>();

	public interface Display {

		public Widget asWidget();

		public void setDetailPresenter(DetailPresenter detail_presenter);

		public HasClickHandlers getExit();

		public Label getLbl();

		public Button getLogin();

		public TextBox getStudentID();

		public PasswordTextBox getPassword();

		public Label getErrorMsg();
			
	}

	public DetailPresenter(Person person, ArrayList<Student> studentList,
			Display view) {
		// TODO Auto-generated constructor stub
		System.out.print("1: " + person.getPersonMail());
		this.person = person;
		this.studentList = studentList;
		this.view = view;
		bind();
	}

	@Override
	public void bind() {
		// TODO Auto-generated method stub

		view.setDetailPresenter(this);
		view.getLbl().setText(
				person.getPersonName() + " " + person.getPersonSurname() + " "
						+ person.getPersonMail());

		view.getExit().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				Presenter presenter = new PersonPresenter(person
						.addPersonList(), new PersonPage());
				presenter.go(RootPanel.get());
			}
		});

		loginControl();
		controlUserID();
		
	}


	public void controlUserID() {

		// view.getStudentID().addKeyPressHandler(new KeyPressHandler() {
		//
		// @Override
		// public void onKeyPress(KeyPressEvent event) {
		// // TODO Auto-generated method stub
		//
		// String stuID = view.getStudentID().getText();
		//
		// if (!stuID.matches("[0-9]*")) {
		// // show some error
		// view.getStudentID().setText("");
		// // view.getStudentID().cancelKey();
		//
		// }
		//
		//
		// }
		// });

		view.getStudentID().addBlurHandler(new BlurHandler() {

			@Override
			public void onBlur(BlurEvent event) {
				// TODO Auto-generated method stub
				String stuID = view.getStudentID().getText();

				if (!stuID.matches("[0-9]*")) {
					// show some error
					view.getStudentID().setText("");
					view.getStudentID().setFocus(true);
					// view.getStudentID().cancelKey();
					view.getLogin().setEnabled(false);
					view.getPassword().setEnabled(false);
					view.getErrorMsg().setText("Numeric karakter gir...");

				} else {
					view.getLogin().setEnabled(true);
					view.getPassword().setEnabled(true);
					view.getErrorMsg().setText("");
				}

			}
		});

	}

	public void loginControl() {

		view.getLogin().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub

				String userID = view.getStudentID().getText();

				String userPass = view.getPassword().getText();

				int count = 0;

				for (int i = 0; i < studentList.size(); i++) {

					if (userID.equals(studentList.get(i).getStudentID())
							&& userPass.equals(studentList.get(i)
									.getStudentPassword())) {
						count++;
						Window.alert("OK!");

						
						student = new Student();
						
						student.setStudentID(userID);
						student.setStudentName(studentList.get(i).getStudentName());
						student.setStudentPassword(userPass);
						student.setSurname(studentList.get(i).getSurname());
					}
				}

				if(count == 1){
					
					Presenter presenter = new NewPresenter(student,student.getStudentList(),new NewView());
					presenter.go(RootPanel.get());
					
				}
				
				if (count == 0) {
					Window.alert("Olmadi Genncccccccccccccc");
				}
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
