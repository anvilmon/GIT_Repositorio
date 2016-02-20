package com.crawl.jpa.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crawl.jpa.dao.AbstractDao;
import com.crawl.jpa.data.CatPropiedad;

@Component("catPropiedadDao")
@Service
public class CatPropiedadDaoImpl extends AbstractDao<CatPropiedad>{
	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<CatPropiedad> findAll() {
		StringBuffer sb = new StringBuffer();
		sb.append("select c from CatPropiedad c");
		Query q = getEm().createQuery(sb.toString());
		return q.getResultList();
	}

	@Override
	@Transactional
	public void delete(CatPropiedad k) {
		StringBuffer sb = new StringBuffer();
		sb.append("delete from CatPropiedad where id=:id");
		Query q = getEm().createQuery(sb.toString());
		q.setParameter("id", k.getId());
		q.executeUpdate();
	}

	@Override
	public CatPropiedad findOne(Long id) {
		StringBuffer sb = new StringBuffer();
		sb.append("select c from CatPropiedad c where c.id=:id");
		Query q = getEm().createQuery(sb.toString());
		q.setParameter("id", id);
		return (CatPropiedad) q.getSingleResult();
	}
}
