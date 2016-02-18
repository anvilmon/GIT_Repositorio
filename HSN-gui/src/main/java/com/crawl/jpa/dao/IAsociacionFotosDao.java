package com.crawl.jpa.dao;

import java.util.List;

import com.crawl.jpa.data.AsociacionFotos;
import com.crawl.jpa.data.Repositorio;

public interface IAsociacionFotosDao extends IDao<AsociacionFotos>{
	
	public List<AsociacionFotos> findByRepository(Repositorio repositorio);

}
