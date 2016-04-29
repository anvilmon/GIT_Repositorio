package com.crawl.jpa.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.crawl.jpa.dao.AsociacionFotosDaoCustom;
public class AsociacionFotosDaoImpl implements AsociacionFotosDaoCustom{

	@PersistenceContext
	private EntityManager em;

}
