package com.crawl.jpa.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.crawl.jpa.dao.CatPropiedadDaoCustom;
public class CatPropiedadDaoImpl implements CatPropiedadDaoCustom{
	
	@PersistenceContext
	private EntityManager em;
	
}
