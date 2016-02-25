package com.crawl.jpa.dao.custom.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.crawl.jpa.dao.custom.IPropiedadDaoCustom;
public class PropiedadDaoImpl implements IPropiedadDaoCustom{

	@PersistenceContext
	private EntityManager em;
	
}
