package com.crawl.jpa.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.crawl.jpa.dao.ProductoDaoCustom;
public class ProductoDaoImpl implements ProductoDaoCustom{

	@PersistenceContext
	private EntityManager em;
	
}
