package com.crawl.jpa.dao.custom.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import com.crawl.jpa.dao.custom.IAsociacionFotosDaoCustom;
@Service
public class AsociacionFotosDaoImpl implements IAsociacionFotosDaoCustom{

	@PersistenceContext
	private EntityManager em;

}
