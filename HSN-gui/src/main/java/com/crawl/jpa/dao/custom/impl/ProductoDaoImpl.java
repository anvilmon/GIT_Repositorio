package com.crawl.jpa.dao.custom.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.crawl.jpa.dao.custom.IProductoDaoCustom;
public class ProductoDaoImpl implements IProductoDaoCustom{

	@PersistenceContext
	private EntityManager em;
	
}
