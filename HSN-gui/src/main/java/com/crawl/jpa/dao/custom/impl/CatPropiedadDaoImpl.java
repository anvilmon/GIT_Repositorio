package com.crawl.jpa.dao.custom.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import com.crawl.jpa.dao.custom.ICatPropiedadDaoCustom;
@Service
public class CatPropiedadDaoImpl implements ICatPropiedadDaoCustom{
	
	@PersistenceContext
	private EntityManager em;
	
}
