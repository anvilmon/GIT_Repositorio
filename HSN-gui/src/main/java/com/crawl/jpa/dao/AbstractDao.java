package com.crawl.jpa.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

public abstract class AbstractDao<K> implements IDao<K>{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional
	public K register(K k) { return getEm().merge(k); }
	public EntityManager getEm() { return em; }
	public void setEm(EntityManager em) { this.em = em; }
	
}
