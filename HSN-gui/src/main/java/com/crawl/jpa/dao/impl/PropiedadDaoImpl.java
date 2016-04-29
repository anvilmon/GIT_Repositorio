package com.crawl.jpa.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.crawl.jpa.dao.PropiedadDaoCustom;
import com.crawl.jpa.data.Propiedad;
public class PropiedadDaoImpl implements PropiedadDaoCustom{

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Propiedad> listarPropiedadesDeCategoria(Long repId) {
		StringBuffer sb = new StringBuffer("select p from Propiedad p where p.tipoPropiedad.forCategory = true and p.repositorio.id:=repId");
		Query q = em.createQuery(sb.toString());
		q.setParameter("repId", repId);
		return q.getResultList();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Propiedad> listarPropiedadesDeProducto(Long repId) {
		StringBuffer sb = new StringBuffer("select p from Propiedad p where p.tipoPropiedad.forProduct = true and p.repositorio.id:=repId");
		Query q = em.createQuery(sb.toString());
		q.setParameter("repId", repId);
		return q.getResultList();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Propiedad> listarPropiedadesDeSistema(Long repId) {
		StringBuffer sb = new StringBuffer("select p from Propiedad p where p.tipoPropiedad.system = true and p.repositorio.id:=repId");
		Query q = em.createQuery(sb.toString());
		q.setParameter("repId", repId);
		return q.getResultList();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Propiedad> listarPropiedadesSoloSistema(Long repId) {
		StringBuffer sb = new StringBuffer("select p from Propiedad p where p.tipoPropiedad.system = true ");
		sb.append(" and p.tipoPropiedad.forCategory = false and p.tipoPropiedad.forProduct = false and p.repositorio.id:=repId");
		Query q = em.createQuery(sb.toString());
		q.setParameter("repId", repId);
		return q.getResultList();
	}
	
}
