package com.crawl.jpa.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.crawl.jpa.dao.FotoDaoCustom;
import com.crawl.jpa.data.Foto;
public class FotoDaoImpl implements FotoDaoCustom{

	@PersistenceContext
	private EntityManager em;

	@Override
	public Foto retrieveLast() {
		StringBuffer sb = new StringBuffer ("select f from Foto f where f.id = (select max(foto.id) from Foto foto)");
		Query q = em.createQuery(sb.toString());
		return (Foto) q.getResultList().get(0);
	}

}
