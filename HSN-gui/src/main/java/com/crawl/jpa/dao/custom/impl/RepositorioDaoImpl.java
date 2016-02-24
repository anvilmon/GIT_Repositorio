package com.crawl.jpa.dao.custom.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import com.crawl.jpa.dao.custom.IRepositorioDaoCustom;

@Service
public class RepositorioDaoImpl implements IRepositorioDaoCustom {
	
	@PersistenceContext
	private EntityManager em;
	
}
