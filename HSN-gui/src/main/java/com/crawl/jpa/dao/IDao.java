package com.crawl.jpa.dao;

import java.util.List;

public interface IDao<K> {
	
	public K register(K k);
	
	public List<K> findAll ();
	
	public void delete(K k);
	
	public K findOne(Long id);
}
