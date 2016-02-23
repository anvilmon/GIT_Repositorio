package com.crawl.jpa.dao.custom.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.crawl.jpa.dao.custom.IFotoDaoCustom;

public class FotoDaoImpl implements IFotoDaoCustom{

	@PersistenceContext
	private EntityManager em;

}
