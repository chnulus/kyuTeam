package com.gwt.kyu.client.presenters;

import java.util.ArrayList;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.CheckboxCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.cell.client.ImageCell;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SelectionChangeEvent.Handler;
import com.google.gwt.view.client.SingleSelectionModel;
import com.gwt.kyu.client.views.DetailView;
import com.gwt.kyu.shared.BolgeMudurlugu;
import com.gwt.kyu.shared.Person;
import com.gwt.kyu.shared.Region;
import com.gwt.kyu.shared.Student;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class PersonPresenter implements Presenter {
	Display view;
	ArrayList<Person> personList;

	ArrayList<Region> regionList;

	Presenter presenter;

	Person selectedObject;

	Student student;

	BolgeMudurlugu bm;

	public final SingleSelectionModel<Person> ssm = new SingleSelectionModel<Person>();

	public final SingleSelectionModel<Region> ssmRegion = new SingleSelectionModel<Region>();

	public interface Display {
		public void clear();

		public Widget asWidget();

		public void setPresenter(PersonPresenter personPresenter);

		public ListBox getCityBox();

		public Label getlbl();

		public CellTable<Person> getSelectedObject();

		public CellTable<Region> getRegionTable();

		public HasClickHandlers getDetail();

		public Button getbolgeMudurlugu();

		public SimplePager getSimplePager();

		public SimplePager getRegionPager();

		public Button getControl();

		public TextBox getSrchTxt();

		public Button getSrchBtn();

	}

	public PersonPresenter(ArrayList<Person> personList,
			ArrayList<Region> regionList, Display view) {
		this.view = view;
		this.personList = personList;
		this.regionList = regionList;
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

			bm = new BolgeMudurlugu();

			view.getDetail().addClickHandler(new DialogHandler(personlistInfo));
			view.getbolgeMudurlugu().addStyleName("bolgebtn");
			view.getbolgeMudurlugu().addClickHandler(
					new BMDialog(bm.getBolgeMudulurlukList()));
			fillSimplePager();
			showHidePager();
			fillRegionTable(regionList);
			regionPager();
			searchRegion();
			// openBolgeMudurluguPage();

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

		imageColumn1.setFieldUpdater(new FieldUpdater<Person, String>() {
			public void update(int index, Person object, String value) {
				// Window.alert("You clicked ");

				int number = view.getSimplePager().getPageStart();

				Window.alert(String.valueOf(number));

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

	public void fillRegionTable(ArrayList<Region> regionList) {

		TextColumn<Region> regionId = new TextColumn<Region>() {
			@Override
			public String getValue(Region object) {
				return object.getRegionID();
			}
		};

		// Add a date column to show the birthday.
		TextColumn<Region> regionName = new TextColumn<Region>() {
			@Override
			public String getValue(Region object) {
				return object.getRegionName();
			}
		};

		Column<Region, String> next = new Column<Region, String>(
				new ButtonImageCell()) {
			@Override
			public String getValue(Region object) {
				return "next.jpg";
			}
		};

		next.setFieldUpdater(new FieldUpdater<Region, String>() {
			public void update(int index, Region object, String value) {
				// Window.alert("You clicked ");

			}

		});

		view.getRegionTable().addColumn(regionId, "Bolge Mudurlugu Kodu");
		view.getRegionTable().addColumn(regionName, "Bolge Mudurlugu");
		view.getRegionTable().addColumn(next, "");

		view.getRegionTable().setRowCount(regionList.size(), true);

		view.getRegionTable().setRowData(0, regionList);
	}

	public void searchRegion() {

		view.getSrchBtn().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub

				String data = view.getSrchTxt().getText().toString().trim();

				if (data.equals("") || data.equals(null) || data.length() == 0) {
					Window.alert("Enter blank field");
				} else {

					if (data.matches("[0-9]*")) {
						regionList = searchRegionId(data);
					} else {
						regionList =searchRegionName(data);

					}

				}

			}
		});

	}

	ArrayList<Region> resultRegion;

	Region region;

	public ArrayList<Region> searchRegionId(String data) {

		resultRegion = new ArrayList<Region>();

		for (int i = 0; i < regionList.size(); i++) {

			if (regionList.get(i).getRegionID().startsWith(data)) {

				region = new Region();

				region.setRegionID(regionList.get(i).getRegionID());
				region.setRegionName(regionList.get(i).getRegionName());

				resultRegion.add(region);

			}

		}

		return resultRegion;

	}

	public ArrayList<Region> searchRegionName(String data) {

		resultRegion = new ArrayList<Region>();

		for (int i = 0; i < regionList.size(); i++) {

			if (regionList.get(i).getRegionName().endsWith(data)) {

				region = new Region();

				region.setRegionID(regionList.get(i).getRegionID());
				region.setRegionName(regionList.get(i).getRegionName());

				resultRegion.add(region);

			}

		}
		
		return resultRegion;

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

		Window.setTitle("New Window");

		com.google.gwt.user.client.Window.addResizeHandler(new ResizeHandler() {

			@Override
			public void onResize(ResizeEvent event) {
				// TODO Auto-generated method stub

				int w = Window.getClientWidth() - 200;
				int h = Window.getClientHeight() - 200;

			}
		});
	}

	public void openBolgeMudurluguPage() {

		// view.getbolgeMudurlugu().addClickHandler(new ClickHandler() {
		//
		// @Override
		// public void onClick(ClickEvent event) {
		// // TODO Auto-generated method stub
		//
		// String winUrl = GWT.getModuleBaseURL() + "help/";
		// String winName = "Testing Window";
		//
		// openNewWindow(winUrl,winName);
		//
		// }
		// });
	}

	public void fillSimplePager() {

		// CellTable table = new CellTable();
		// SimplePager.Resources pagerResources =
		// GWT.create(SimplePager.Resources.class);
		// SimplePager pager = new SimplePager(TextLocation.CENTER,
		// pagerResources, false, 0, true);
		// pager.setDisplay(table);
		// pager.setPageSize(7);
		// table.setPageSize(7);
		// pager.startLoading();
		// ListDataProvider dataProvider = new ListDataProvider();
		// dataProvider.addDataDisplay(table);
		// List list = (List) dataProvider.getList();
		// for (Carrier contact : list) {
		// list.add(contact);
		//
		// }

		// Add a cellList to a data provider.
		ListDataProvider<Person> dataProvider = new ListDataProvider<Person>();
		dataProvider.addDataDisplay(view.getSelectedObject());
		dataProvider.setList(personList);
		view.getSimplePager().setDisplay(view.getSelectedObject());
		view.getSimplePager().setPageSize(5);
		// int number = view.getSimplePager().getPage();

		// view.getSimplePager().startLoading();
		// view.getSimplePager().lastPage();

	}

	public void regionPager() {
		Window.alert(String.valueOf(regionList.size()));
		ListDataProvider<Region> dataProvider = new ListDataProvider<Region>();
		dataProvider.addDataDisplay(view.getRegionTable());
		dataProvider.setList(regionList);
		view.getRegionPager().setDisplay(view.getRegionTable());
		view.getRegionPager().setPageSize(10);

	}

	public void showHidePager() {

		view.getControl().addClickHandler(new ClickHandler() {
			int count = 0;

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				if (count % 2 == 0) {
					view.getSimplePager().setVisible(false);
					view.getControl().setText("Detayi Bir Cok Sayfada Goster");
					view.getSimplePager().setPageSize(personList.size());
					count++;
				} else {
					view.getSimplePager().setPageSize(5);
					view.getSimplePager().setVisible(true);
					view.getControl().setText("Detayi Tek Sayfada Goster");

					count++;
				}
			}
		});
	}

	public void getToolTips() {

		view.getControl().addMouseOverHandler(new MouseOverHandler() {

			@Override
			public void onMouseOver(MouseOverEvent event) {
				// TODO Auto-generated method stub

			}
		});

	}

}
