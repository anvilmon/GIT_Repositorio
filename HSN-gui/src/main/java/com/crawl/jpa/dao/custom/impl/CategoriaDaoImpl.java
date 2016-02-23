package com.crawl.jpa.dao.custom.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.crawl.jpa.dao.custom.ICategoriaDaoCustom;

public class CategoriaDaoImpl implements ICategoriaDaoCustom{

	@PersistenceContext
	private EntityManager em;
	
}
