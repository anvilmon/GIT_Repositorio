package com.crawl.jpa.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.crawl.jpa.dao.CategoriaDaoCustom;
import com.crawl.jpa.data.Categoria;
import com.crawl.jpa.data.Repositorio;
public class CategoriaDaoImpl implements CategoriaDaoCustom{

	@PersistenceContext
	private EntityManager em;

	@Override
	public Categoria buscarUltimo() {
		StringBuffer sb = new StringBuffer("select c from Categoria c where c.id = (select max(cat.id) from Categoria cat)");
		Query q = em.createQuery(sb.toString());
		return (Categoria) q.getResultList().get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Categoria> buscarCategoriasPadre(Repositorio r) {
		StringBuffer sb = new StringBuffer("select c from Categoria c where c.repositorio.id=:repositorioId and c.parentCategory is null");
		Query q = em.createQuery(sb.toString());
		q.setParameter("repositorioId", r.getId());
		return q.getResultList();
	}
	
}
