package com.crawl.jpa.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.crawl.jpa.dao.ProductoCategoriaDaoCustom;
public class ProductoCategoriaDaoImpl implements ProductoCategoriaDaoCustom{

	@PersistenceContext
	private EntityManager em;
	
}
