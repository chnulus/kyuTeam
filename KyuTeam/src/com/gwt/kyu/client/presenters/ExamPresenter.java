package com.gwt.kyu.client.presenters;

import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

public class ExamPresenter implements Presenter{

	
	public interface Display{
		
		public void setPresenter(ExamPresenter exam_presenter);
		public Widget asWidget();
		public void showQuestion();
		
	}
	
//	public ExamPresenter(Student student)
	
	@Override
	public void bind() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void go(HasWidgets container) {
		// TODO Auto-generated method stub
		
	}

	
	
}
