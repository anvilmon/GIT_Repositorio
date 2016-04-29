package com.crawl.jpa.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.crawl.jpa.dao.ValorPropiedadDaoCustom;
public class ValorPropiedadDaoImpl implements ValorPropiedadDaoCustom{

	@PersistenceContext
	private EntityManager em;
	
}
