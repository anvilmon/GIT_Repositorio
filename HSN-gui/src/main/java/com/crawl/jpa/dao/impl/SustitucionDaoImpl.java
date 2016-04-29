package com.crawl.jpa.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.crawl.jpa.dao.SustitucionDaoCustom;
import com.crawl.jpa.data.Repositorio;
import com.crawl.jpa.data.Sustitucion;
public class SustitucionDaoImpl implements SustitucionDaoCustom{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Sustitucion> listarParaRepositorio(Repositorio r){
		StringBuffer sb = new StringBuffer("select s from Sustitucion s where s.repositorio.id ="+r.getId());
		Query q = em.createQuery(sb.toString());
		return q.getResultList();
	}
}
