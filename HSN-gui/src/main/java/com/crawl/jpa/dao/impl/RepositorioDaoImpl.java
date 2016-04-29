package com.crawl.jpa.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.crawl.jpa.dao.RepositorioDaoCustom;
import com.crawl.jpa.data.Repositorio;

public class RepositorioDaoImpl implements RepositorioDaoCustom {
	
	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Repositorio> listarRepositoriosActivos() {
		StringBuffer sb = new StringBuffer("select r from Repositorio r where r.active = true");
		Query q = em.createQuery(sb.toString());
		return q.getResultList();
	}
	
}
