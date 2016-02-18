package com.crawl.jpa.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crawl.jpa.dao.AbstractDao;
import com.crawl.jpa.dao.PropiedadService;
import com.crawl.jpa.data.Propiedad;
import com.crawl.jpa.data.Repositorio;

@Component("propiedadService")
@Service
public class PropiedadServiceImpl extends AbstractDao<Propiedad> implements PropiedadService{

	@Override
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Propiedad> findAll() {
		StringBuffer sb = new StringBuffer();
		sb.append("select c from Propiedad c");
		Query q = getEm().createQuery(sb.toString());
		return q.getResultList();
	}

	@Override
	@Transactional
	public void delete(Propiedad k) {
		StringBuffer sb = new StringBuffer();
		sb.append("delete from Propiedad where id=:id");
		Query q = getEm().createQuery(sb.toString());
		q.setParameter("id", k.getId());
		q.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<Propiedad> findByRepository(Repositorio repositorio) {
		StringBuffer sb = new StringBuffer();
		sb.append("select c from Propiedad c where c.repositorio.id=:id");
		Query q = getEm().createQuery(sb.toString());
		q.setParameter("id", repositorio.getId());
		return q.getResultList();
	}

	@Override
	public Propiedad findOne(Long id) {
		StringBuffer sb = new StringBuffer();
		sb.append("select c from Propiedad c where c.id=:id");
		Query q = getEm().createQuery(sb.toString());
		q.setParameter("id", id);
		return (Propiedad) q.getSingleResult();
	}
}
