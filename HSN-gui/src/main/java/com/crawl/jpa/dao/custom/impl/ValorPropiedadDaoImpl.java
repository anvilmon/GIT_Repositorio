package com.crawl.jpa.dao.custom.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.crawl.jpa.dao.custom.IValorPropiedadDaoCustom;
public class ValorPropiedadDaoImpl implements IValorPropiedadDaoCustom{

	@PersistenceContext
	private EntityManager em;
	
}
