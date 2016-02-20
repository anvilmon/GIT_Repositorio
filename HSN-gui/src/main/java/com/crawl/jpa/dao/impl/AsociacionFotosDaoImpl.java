package com.crawl.jpa.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crawl.jpa.dao.AbstractDao;
import com.crawl.jpa.dao.IAsociacionFotosDao;
import com.crawl.jpa.data.AsociacionFotos;

@Component("asociacionFotosDao")
@Service
public class AsociacionFotosDaoImpl extends AbstractDao<AsociacionFotos> implements IAsociacionFotosDao{

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


	@Override
	public AsociacionFotos findOne(Long id) {
		StringBuffer sb = new StringBuffer();
		sb.append("select c from AsociacionFotos c where c.id=:id");
		Query q = getEm().createQuery(sb.toString());
		q.setParameter("id", id);
		return (AsociacionFotos) q.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AsociacionFotos> findByRepository(Long id) {
		StringBuffer sb = new StringBuffer();
		sb.append("select af from AsociacionFotos af where af.repositorio.id:=id");
		Query q = getEm().createQuery(sb.toString());
		q.setParameter("id", id);
		return q.getResultList();
	}


}
