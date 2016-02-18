package com.crawl.command;

public interface ICommand<K> {

	public void execute (K in);
	
}
