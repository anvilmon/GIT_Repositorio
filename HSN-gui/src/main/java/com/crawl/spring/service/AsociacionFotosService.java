package com.crawl.spring.service;

import java.util.List;

import com.crawl.jpa.data.AsociacionFotos;
import com.crawl.jpa.data.Repositorio;

public interface AsociacionFotosService extends IService<AsociacionFotos>{
	
	public List<AsociacionFotos> findByRepository(Repositorio repositorio);

}
