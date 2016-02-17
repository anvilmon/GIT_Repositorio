package com.crawl.spring.service.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crawl.jpa.data.Repositorio;
import com.crawl.jpa.data.Sustitucion;
import com.crawl.spring.service.AbstractService;

@Component("sustitucionService")
@Service
public class SustitucionService extends AbstractService<Sustitucion>{

	@Override
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Sustitucion> findAll() {
		StringBuffer sb = new StringBuffer();
		sb.append("select c from Sustitucion c");
		Query q = getEm().createQuery(sb.toString());
		return q.getResultList();
	}

	@Override
	@Transactional
	public void delete(Sustitucion k) {
		StringBuffer sb = new StringBuffer();
		sb.append("delete from Sustitucion where id=:id");
		Query q = getEm().createQuery(sb.toString());
		q.setParameter("id", k.getId());
		q.executeUpdate();
	}

//	@SuppressWarnings("unchecked")
//	@Transactional
//	@Override
//	public List<Sustitucion> findByRepository(Repositorio repositorio) {
//		StringBuffer sb = new StringBuffer();
//		sb.append("select c from Sustitucion c where c.repositorio.id=:id");
//		Query q = getEm().createQuery(sb.toString());
//		q.setParameter("id", repositorio.getId());
//		return q.getResultList();
//	}

	@Override
	public Sustitucion findOne(Long id) {
		StringBuffer sb = new StringBuffer();
		sb.append("select c from Sustitucion c where c.id=:id");
		Query q = getEm().createQuery(sb.toString());
		q.setParameter("id", id);
		return (Sustitucion) q.getSingleResult();
	}
	
}
