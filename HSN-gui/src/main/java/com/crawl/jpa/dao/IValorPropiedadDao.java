package com.crawl.jpa.dao;

import java.util.List;

import com.crawl.jpa.data.ValorPropiedad;

public interface IValorPropiedadDao extends IDao<ValorPropiedad>{
	
	public List<ValorPropiedad> findByRepository(Long id);

}
