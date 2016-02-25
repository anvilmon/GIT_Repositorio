package com.crawl.jpa.dao.custom.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.crawl.jpa.dao.custom.IRepositorioDaoCustom;

public class RepositorioDaoImpl implements IRepositorioDaoCustom {
	
	@PersistenceContext
	private EntityManager em;
	
}
