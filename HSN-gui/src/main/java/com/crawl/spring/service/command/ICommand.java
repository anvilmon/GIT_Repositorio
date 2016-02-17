package com.crawl.spring.service.command;

public interface ICommand<K,V> {

	public V execute (K in);
	
}
