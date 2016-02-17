package com.crawl.spring.service;

import java.util.List;

public interface IService<K> {
	
	public K register(K k);
	
	public List<K> findAll ();
	
	public void delete(K k);
	
	public K findOne(Long id);
}
