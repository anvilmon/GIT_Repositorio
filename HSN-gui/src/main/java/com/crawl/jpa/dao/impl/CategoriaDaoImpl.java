package com.crawl.jpa.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crawl.jpa.dao.AbstractDao;
import com.crawl.jpa.data.Categoria;

@Component("categoriaDao")
@Service
public class CategoriaDaoImpl extends AbstractDao<Categoria> {

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

	@Override
	public Categoria findOne(Long id) {
		StringBuffer sb = new StringBuffer();
		sb.append("select c from Categoria c where c.id=:id");
		Query q = getEm().createQuery(sb.toString());
		q.setParameter("id", id);
		return (Categoria) q.getSingleResult();
	}
	
}
