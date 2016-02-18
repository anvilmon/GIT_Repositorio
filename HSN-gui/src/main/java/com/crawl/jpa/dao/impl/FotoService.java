package com.crawl.jpa.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crawl.jpa.dao.AbstractDao;
import com.crawl.jpa.data.Foto;
import com.crawl.jpa.data.Repositorio;

@Component("fotoService")
@Service
public class FotoService extends AbstractDao<Foto>{

	@Override
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Foto> findAll() {
		StringBuffer sb = new StringBuffer();
		sb.append("select c from Foto c");
		Query q = getEm().createQuery(sb.toString());
		return q.getResultList();
	}

	@Override
	@Transactional
	public void delete(Foto k) {
		StringBuffer sb = new StringBuffer();
		sb.append("delete from Foto where id=:id");
		Query q = getEm().createQuery(sb.toString());
		q.setParameter("id", k.getId());
		q.executeUpdate();
	}
	
//	@SuppressWarnings("unchecked")
//	@Transactional
//	@Override
//	public List<Foto> findByRepository(Repositorio repositorio) {
//		StringBuffer sb = new StringBuffer();
//		sb.append("select c from Foto c where c.repositorio.id=:id");
//		Query q = getEm().createQuery(sb.toString());
//		q.setParameter("id", repositorio.getId());
//		return q.getResultList();
//	}

	@Override
	public Foto findOne(Long id) {
		StringBuffer sb = new StringBuffer();
		sb.append("select c from Foto c where c.id=:id");
		Query q = getEm().createQuery(sb.toString());
		q.setParameter("id", id);
		return (Foto) q.getSingleResult();
	}

}
