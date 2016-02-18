package com.crawl.jpa.dao;

import java.util.List;

import com.crawl.jpa.data.Propiedad;
import com.crawl.jpa.data.Repositorio;

public interface PropiedadService {
	
	public List<Propiedad> findByRepository(Repositorio repositorio);

}
