package com.crawl.spring.service.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crawl.jpa.data.Categoria;
import com.crawl.jpa.data.Repositorio;
import com.crawl.spring.service.AbstractService;
import com.crawl.spring.service.PropiedadService;

@Component("categoriaService")
@Service
public class CategoriaServiceImpl extends AbstractService<Categoria> {

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<Categoria> findAll() {
		StringBuffer sb = new StringBuffer();
		sb.append("select c from Categoria c");
		Query q = getEm().createQuery(sb.toString());
		return q.getResultList();
	}

	@Override
	@Transactional
	public void delete(Categoria k) {
		StringBuffer sb = new StringBuffer();
		sb.append("delete from Categoria where id=:id");
		Query q = getEm().createQuery(sb.toString());
		q.setParameter("id", k.getId());
		q.executeUpdate();
	}

//	@SuppressWarnings("unchecked")
//	@Transactional
//	@Override
//	public List<Categoria> findByRepository(Repositorio repositorio) {
//		StringBuffer sb = new StringBuffer();
//		sb.append("select c from Categoria c where c.repositorio.id=:id");
//		Query q = getEm().createQuery(sb.toString());
//		q.setParameter("id", repositorio.getId());
//		return q.getResultList();
//	}

	@Override
	public Categoria findOne(Long id) {
		StringBuffer sb = new StringBuffer();
		sb.append("select c from Categoria c where c.id=:id");
		Query q = getEm().createQuery(sb.toString());
		q.setParameter("id", id);
		return (Categoria) q.getSingleResult();
	}
	
}
