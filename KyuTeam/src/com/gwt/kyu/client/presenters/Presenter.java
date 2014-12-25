package com.gwt.kyu.client.presenters;

import com.google.gwt.user.client.ui.HasWidgets;

public interface Presenter {
	public void bind();
	public void go(final HasWidgets container);
}
