package com.crawl.jpa.dao;

import java.util.List;

import com.crawl.jpa.data.Sustitucion;

public interface ISustitucionDao extends IDao<Sustitucion>{
	
	public List<Sustitucion> findByRepository(Long id);

}
