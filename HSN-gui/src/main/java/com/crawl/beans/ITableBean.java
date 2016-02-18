package com.crawl.beans;

import org.primefaces.event.RowEditEvent;

import com.crawl.jpa.AbstractEntity;

public interface ITableBean {

	public void onRowCreate();
	public void onRowEdit(RowEditEvent event);
	public void onRowCancel(RowEditEvent event);
	public void onRowDelete(AbstractEntity a);
	
}
