package com.crawl.jpa.dao.custom.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.crawl.jpa.dao.custom.ISustitucionDaoCustom;
public class SustitucionDaoImpl implements ISustitucionDaoCustom{

	@PersistenceContext
	private EntityManager em;
	
}
