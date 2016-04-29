package com.crawl.jpa.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.crawl.jpa.dao.ConfigCategoriaDaoCustom;
public class ConfigCategoriaDaoImpl implements ConfigCategoriaDaoCustom{

	@PersistenceContext
	private EntityManager em;

}
