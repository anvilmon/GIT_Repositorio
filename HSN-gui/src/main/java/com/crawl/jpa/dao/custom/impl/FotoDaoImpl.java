package com.crawl.jpa.dao.custom.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import com.crawl.jpa.dao.custom.IFotoDaoCustom;
@Service
public class FotoDaoImpl implements IFotoDaoCustom{

	@PersistenceContext
	private EntityManager em;

}
