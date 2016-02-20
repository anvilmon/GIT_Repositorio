package com.crawl.jpa.dao;

import java.util.List;

import com.crawl.jpa.data.AsociacionFotos;

public interface IAsociacionFotosDao extends IDao<AsociacionFotos>{
	
	public List<AsociacionFotos> findByRepository( Long id );

}
