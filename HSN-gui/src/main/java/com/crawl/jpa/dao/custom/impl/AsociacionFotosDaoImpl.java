package com.crawl.jpa.dao.custom.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.crawl.jpa.dao.custom.IAsociacionFotosDaoCustom;
public class AsociacionFotosDaoImpl implements IAsociacionFotosDaoCustom{

	@PersistenceContext
	private EntityManager em;

}
