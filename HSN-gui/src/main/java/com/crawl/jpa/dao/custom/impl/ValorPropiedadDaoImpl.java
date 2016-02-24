package com.crawl.jpa.dao.custom.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import com.crawl.jpa.dao.custom.IValorPropiedadDaoCustom;
@Service
public class ValorPropiedadDaoImpl implements IValorPropiedadDaoCustom{

	@PersistenceContext
	private EntityManager em;
	
}
