package com.crawl.spring.service.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crawl.jpa.data.AsociacionFotos;
import com.crawl.jpa.data.Repositorio;
import com.crawl.spring.service.AbstractService;
import com.crawl.spring.service.AsociacionFotosService;

@Component("asociacionFotosService")
@Service
public class AsociacionFotosServiceImpl extends AbstractService<AsociacionFotos> {

	@Override
	@SuppressWarnings("unchecked")
	@Transactional
	public List<AsociacionFotos> findAll() {
		StringBuffer sb = new StringBuffer();
		sb.append("select c from AsociacionFotos c");
		Query q = getEm().createQuery(sb.toString());
		return q.getResultList();
	}

	@Override
	@Transactional
	public void delete(AsociacionFotos k) {
		StringBuffer sb = new StringBuffer();
		sb.append("delete from AsociacionFotos where id=:id");
		Query q = getEm().createQuery(sb.toString());
		q.setParameter("id", k.getId());
		q.executeUpdate();
	}

//	@Override
//	@SuppressWarnings("unchecked")
//	@Transactional
//	public List<AsociacionFotos> findByRepository(Repositorio repositorio) {
//		StringBuffer sb = new StringBuffer();
//		sb.append("select c from AsociacionFotos c where c.repositorio.id=:id");
//		Query q = getEm().createQuery(sb.toString());
//		q.setParameter("id", repositorio.getId());
//		return q.getResultList();
//	}

	@Override
	public AsociacionFotos findOne(Long id) {
		StringBuffer sb = new StringBuffer();
		sb.append("select c from AsociacionFotos c where c.id=:id");
		Query q = getEm().createQuery(sb.toString());
		q.setParameter("id", id);
		return (AsociacionFotos) q.getSingleResult();
	}

}
