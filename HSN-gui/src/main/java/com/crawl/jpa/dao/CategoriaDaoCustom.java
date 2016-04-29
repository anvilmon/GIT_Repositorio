package com.crawl.jpa.dao;

import java.util.List;

import com.crawl.jpa.data.Categoria;
import com.crawl.jpa.data.Repositorio;

public interface CategoriaDaoCustom {

	public Categoria buscarUltimo();
	public List<Categoria> buscarCategoriasPadre(Repositorio r);
}
