package com.crawl.jpa.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crawl.jpa.dao.AbstractDao;
import com.crawl.jpa.data.Repositorio;


@Service
public class RepositorioService extends AbstractDao<Repositorio> {
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Repositorio> findAll (){
		StringBuffer sb = new StringBuffer();
		sb.append("select r from Repositorio r");
		Query q = getEm().createQuery(sb.toString());
		return q.getResultList();
	}
	
	@Transactional
	public void delete(Repositorio r){
		StringBuffer sb = new StringBuffer();
		sb.append("delete from Repositorio where id=:id");
		Query q = getEm().createQuery(sb.toString());
		q.setParameter("id", r.getId());
		q.executeUpdate();
	}

//	@Override
//	public List<Repositorio> findByRepository(Repositorio repositorio) {
//		final List<Repositorio> result = new ArrayList<Repositorio>();
//		result.add(findOne(repositorio.getId()));
//		return result;
//	}

	@Override
	public Repositorio findOne(Long id) {
		StringBuffer sb = new StringBuffer();
		sb.append("select r from Repositorio r where r.id=:id");
		Query q = getEm().createQuery(sb.toString());
		q.setParameter("id", id);
		return (Repositorio) q.getSingleResult();
	}
}
