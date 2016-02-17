package com.crawl.spring.service.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crawl.jpa.data.Producto;
import com.crawl.jpa.data.Repositorio;
import com.crawl.spring.service.AbstractService;

@Component("productoService")
@Service
public class ProductoService extends AbstractService<Producto>{

	@Override
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Producto> findAll() {
		StringBuffer sb = new StringBuffer();
		sb.append("select c from Producto c");
		Query q = getEm().createQuery(sb.toString());
		return q.getResultList();
	}

	@Override
	@Transactional
	public void delete(Producto k) {
		StringBuffer sb = new StringBuffer();
		sb.append("delete from Producto where id=:id");
		Query q = getEm().createQuery(sb.toString());
		q.setParameter("id", k.getId());
		q.executeUpdate();
	}
	
//	@SuppressWarnings("unchecked")
//	@Transactional
//	@Override
//	public List<Producto> findByRepository(Repositorio repositorio) {
//		StringBuffer sb = new StringBuffer();
//		sb.append("select c from Producto c where c.categoria.repositorio.id=:id");
//		Query q = getEm().createQuery(sb.toString());
//		q.setParameter("id", repositorio.getId());
//		return q.getResultList();
//	}

	@Override
	public Producto findOne(Long id) {
		StringBuffer sb = new StringBuffer();
		sb.append("select c from Producto c where c.id=:id");
		Query q = getEm().createQuery(sb.toString());
		q.setParameter("id", id);
		return (Producto) q.getSingleResult();
	}
}
