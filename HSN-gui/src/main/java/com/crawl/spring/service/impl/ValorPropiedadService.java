package com.crawl.spring.service.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crawl.jpa.data.Repositorio;
import com.crawl.jpa.data.ValorPropiedad;
import com.crawl.spring.service.AbstractService;

@Component("valorPropiedadService")
@Service
public class ValorPropiedadService  extends AbstractService<ValorPropiedad>{

	@Override
	@SuppressWarnings("unchecked")
	@Transactional
	public List<ValorPropiedad> findAll() {
		StringBuffer sb = new StringBuffer();
		sb.append("select c from ValorPropiedad c");
		Query q = getEm().createQuery(sb.toString());
		return q.getResultList();
	}

	@Override
	@Transactional
	public void delete(ValorPropiedad k) {
		StringBuffer sb = new StringBuffer();
		sb.append("delete from ValorPropiedad where id=:id");
		Query q = getEm().createQuery(sb.toString());
		q.setParameter("id", k.getId());
		q.executeUpdate();
	}

//	@SuppressWarnings("unchecked")
//	@Transactional
//	@Override
//	public List<ValorPropiedad> findByRepository(Repositorio repositorio) {
//		StringBuffer sb = new StringBuffer();
//		sb.append("select c from ValorPropiedad c where c.propiedad.repositorio.id=:id");
//		Query q = getEm().createQuery(sb.toString());
//		q.setParameter("id", repositorio.getId());
//		return q.getResultList();
//	}

	@Override
	public ValorPropiedad findOne(Long id) {
		StringBuffer sb = new StringBuffer();
		sb.append("select c from ValorPropiedad c where c.id=:id");
		Query q = getEm().createQuery(sb.toString());
		q.setParameter("id", id);
		return (ValorPropiedad) q.getSingleResult();
	}
	
}
