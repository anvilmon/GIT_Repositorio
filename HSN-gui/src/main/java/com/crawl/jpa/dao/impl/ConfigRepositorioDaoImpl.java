package com.crawl.jpa.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.crawl.jpa.dao.ConfigRepositorioDaoCustom;
import com.crawl.jpa.data.ConfigRepositorio;
import com.crawl.jpa.data.Repositorio;
public class ConfigRepositorioDaoImpl implements ConfigRepositorioDaoCustom{

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public ConfigRepositorio buscarPorRepositorio(Repositorio r) {
		StringBuffer sb = new StringBuffer("select cr from ConfigRepositorio cr where cr.repositorio.id=:repositorioId");
		Query q = em.createQuery(sb.toString());
		q.setParameter("repositorioId", r.getId());
		final List<ConfigRepositorio> results = q.getResultList();
		if (results == null || results.isEmpty()){
			return new ConfigRepositorio();
		}else{
			return results.get(0);
		}
	}

}
