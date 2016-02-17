package com.crawl.primefaces.beans;

import org.primefaces.event.RowEditEvent;

import com.crawl.jpa.data.EmptyEntity;

public interface ITableBean {

	public void onRowCreate();
	public void onRowEdit(RowEditEvent event);
	public void onRowCancel(RowEditEvent event);
	public void onRowDelete(EmptyEntity r);
	
}
