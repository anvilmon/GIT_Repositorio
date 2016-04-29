package com.crawl.jpa.dao;

import java.util.List;

import com.crawl.jpa.data.Repositorio;
import com.crawl.jpa.data.Sustitucion;

public interface SustitucionDaoCustom {

	public List<Sustitucion> listarParaRepositorio(Repositorio r);
	
}
