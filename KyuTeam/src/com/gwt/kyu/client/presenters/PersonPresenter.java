package com.gwt.kyu.client.presenters;

import java.util.ArrayList;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.CheckboxCell;
import com.google.gwt.cell.client.ClickableTextCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.cell.client.ImageCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SelectionChangeEvent.Handler;
import com.google.gwt.view.client.SingleSelectionModel;
import com.gwt.kyu.client.views.DetailView;
import com.gwt.kyu.shared.Person;
import com.gwt.kyu.shared.Student;

public class PersonPresenter implements Presenter {
	Display view;
	ArrayList<Person> personList;

	Presenter presenter;

	Person selectedObject;

	Student student;

	public final SingleSelectionModel<Person> ssm = new SingleSelectionModel<Person>();

	public interface Display {
		public void clear();

		public Widget asWidget();

		public void setPresenter(PersonPresenter personPresenter);

		public ListBox getCityBox();

		public Label getlbl();

		public CellTable<Person> getSelectedObject();

		public HasClickHandlers getDetail();

	}

	public PersonPresenter(ArrayList<Person> personList, Display view) {
		this.view = view;
		this.personList = personList;

		String winUrl = GWT.getModuleBaseURL() + "help/";
		String winName = "Testing Window";

		// openNewWindow(winUrl,winName);

		bind();
	}

	ArrayList<Person> personlistInfo;

	@Override
	public void bind() {
		// TODO Auto-generated method stub
		try {
			view.setPresenter(this);
			view.getSelectedObject().setSelectionModel(ssm);
			view.clear();
			fillList();
			fillTable(personList);
			getSelectItem();
			personlistInfo = new ArrayList<Person>();
			ssm.addSelectionChangeHandler(new Handler() {

				@Override
				public void onSelectionChange(SelectionChangeEvent event) {
					// TODO Auto-generated method stub
					personlistInfo.clear();
					selectedObject = new Person();
					selectedObject = ssm.getSelectedObject();
					personlistInfo.add(selectedObject);
				}
			});
			view.getDetail().addClickHandler(new DialogHandler(personlistInfo));

		} catch (Exception ex) {
			Window.alert("HATA");
		}
		// view.getDetail().addClickHandler(new ClickHandler() {
		//
		// @Override
		// public void onClick(ClickEvent event) {
		// // TODO Auto-generated method stub
		// try {
		// student = new Student();
		// presenter = new DetailPresenter(selectedObject, student
		// .getStudentList(), new DetailView());
		// presenter.go(RootPanel.get());
		//
		// } catch (Exception ex) {
		// Window.alert("Satir Sec!!!");
		//
		// }
		// }
		// });

	}

	public void fillList() {

		ArrayList<String> city = new ArrayList<String>();

		city.add("Istanbul");
		city.add("Ankara");
		city.add("Izmir");
		city.add("Antalya");

		for (String cities : city) {
			view.getCityBox().addItem(cities);
		}

	}

	public void getSelectItem() {

		view.getCityBox().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				view.getlbl().setText(
						"City : "
								+ view.getCityBox().getItemText(
										view.getCityBox().getSelectedIndex()));
			}
		});
	}

	public void fillTable(ArrayList<Person> personList) {

		CheckboxCell erk = new CheckboxCell();

		Column<Person, Boolean> checkColumn = new Column<Person, Boolean>(
				new CheckboxCell(true, false)) {
			@Override
			public Boolean getValue(Person object) {
				// Get the value from the selection model.
				return ssm.isSelected(object);
			}
		};

		checkColumn.setFieldUpdater(new FieldUpdater<Person, Boolean>() {
			public void update(int index, Person object, Boolean value) {

				// Window.alert(object.getPersonName());

			}
		});

		TextColumn<Person> nameColumn = new TextColumn<Person>() {
			@Override
			public String getValue(Person object) {
				return object.getPersonName();
			}
		};

		// Add a date column to show the birthday.
		TextColumn<Person> surNameColumn = new TextColumn<Person>() {
			@Override
			public String getValue(Person object) {
				return object.getPersonSurname();
			}
		};

		TextColumn<Person> mailColumn = new TextColumn<Person>() {
			@Override
			public String getValue(Person object) {
				return object.getPersonMail();
			}
		};

		ButtonCell PreviewButton = new ButtonCell();
		Column<Person, String> Preview = new Column<Person, String>(
				PreviewButton) {
			public String getValue(Person object) {
				// TODO Auto-generated method stub

				return "Detail";
			}
		};

		Preview.setFieldUpdater(new FieldUpdater<Person, String>() {
			public void update(int index, Person object, String value) {

				student = new Student();
				presenter = new DetailPresenter(object, student
						.getStudentList(), new DetailView());
				presenter.go(RootPanel.get());

			}
		});

		Column<Person, String> imageColumn = new Column<Person, String>(
				new ImageCell()) {
			@Override
			public String getValue(Person object) {
				return "detail.jpg";
			}
		};

		imageColumn.setFieldUpdater(new FieldUpdater<Person, String>() {
			public void update(int index, Person object, String value) {
				Window.alert("You clicked ");
			}

		});

		Column<Person, String> imageColumn1 = new Column<Person, String>(
				new ButtonImageCell()) {
			@Override
			public String getValue(Person object) {
				return "detail.jpg";
			}
		};

		imageColumn.setFieldUpdater(new FieldUpdater<Person, String>() {
			public void update(int index, Person object, String value) {
				Window.alert("You clicked ");
			}
			
			

		});

		view.getSelectedObject().addColumn(checkColumn, "CheckBox");
		view.getSelectedObject().addColumn(nameColumn, "Name");
		view.getSelectedObject().addColumn(surNameColumn, "Surname");
		view.getSelectedObject().addColumn(mailColumn, "Phone");
		view.getSelectedObject().addColumn(Preview, "Detail");
		view.getSelectedObject().addColumn(imageColumn, "DetailImg");
		view.getSelectedObject().addColumn(imageColumn1, "DetailImg1");


		view.getSelectedObject().setRowCount(personList.size(), true);

		view.getSelectedObject().setRowData(0, personList);

	}

	@Override
	public void go(HasWidgets container) {
		// TODO Auto-generated method stub
		container.clear();
		container.add(view.asWidget());
	}

	public static void openNewWindow(String name, String url) {
		com.google.gwt.user.client.Window.open(url, name.replace(" ", "_"),
				"menubar=no," + "location=false," + "resizable=yes,"
						+ "scrollbars=yes," + "status=no," + "dependent=true");
	}

}
