package com.crawl.command;

public interface IOCommand<K,V> {

	public V execute (K in);
	
}
