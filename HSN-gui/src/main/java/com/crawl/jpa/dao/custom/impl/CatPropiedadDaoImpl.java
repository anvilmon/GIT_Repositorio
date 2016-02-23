package com.crawl.jpa.dao.custom.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.crawl.jpa.dao.custom.ICatPropiedadDaoCustom;

public class CatPropiedadDaoImpl implements ICatPropiedadDaoCustom{
	
	@PersistenceContext
	private EntityManager em;
	
}
