package com.crawl.jpa.dao;

import java.util.List;

import com.crawl.jpa.data.Propiedad;

public interface IPropiedadDao extends IDao<Propiedad>{
	
	public List<Propiedad> findByRepository(Long id);

}
