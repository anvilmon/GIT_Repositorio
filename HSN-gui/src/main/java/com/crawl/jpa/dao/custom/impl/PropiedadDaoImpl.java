package com.crawl.jpa.dao.custom.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import com.crawl.jpa.dao.custom.IPropiedadDaoCustom;
@Service
public class PropiedadDaoImpl implements IPropiedadDaoCustom{

	@PersistenceContext
	private EntityManager em;
	
}
