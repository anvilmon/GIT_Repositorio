package com.crawl.jpa.dao.custom.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import com.crawl.jpa.dao.custom.ISustitucionDaoCustom;
@Service
public class SustitucionDaoImpl implements ISustitucionDaoCustom{

	@PersistenceContext
	private EntityManager em;
	
}
