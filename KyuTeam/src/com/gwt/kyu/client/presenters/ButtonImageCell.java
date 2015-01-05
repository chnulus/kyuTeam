package com.gwt.kyu.client.presenters;

import org.eclipse.jetty.server.Connector;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.dom.client.Style.Cursor;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.user.client.ui.Image;

public class ButtonImageCell extends ButtonCell{
	
	 @Override
	    public void render(com.google.gwt.cell.client.Cell.Context context, 
	            String value, SafeHtmlBuilder sb) {
//	        SafeHtml html = SafeHtmlUtils.fromTrustedString(new Image(value).toString());
//	        sb.append(html);
		 
		 String icon = "detail.jpg";
         Image image = new Image(icon);
         //fix the mouse pointer
         
         image.getElement().getStyle().setCursor(Cursor.POINTER);
         //Do something with the DATA
         //image.setTitle("Delete " + data.asString());
         SafeHtml html = SafeHtmlUtils.fromTrustedString(image.toString());
         sb.append(html);
		 
	    }
	

}
