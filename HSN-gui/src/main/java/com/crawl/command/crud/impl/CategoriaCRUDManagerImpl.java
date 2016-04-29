package com.crawl.command.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.crawl.command.crud.ICategoriaCRUDManager;
import com.crawl.jpa.dao.CategoriaDao;
import com.crawl.jpa.data.Categoria;
import com.crawl.jpa.data.Repositorio;

@Component("categoriaCRUD")
@Service
public class CategoriaCRUDManagerImpl implements ICategoriaCRUDManager {
	
	@Autowired
	private CategoriaDao dao;

	@Override
	public void eliminar(Categoria af) { dao.delete(af); }
	@Override
	public Categoria guardar(Categoria af) { return dao.save(af); }
	@Override
	public List<Categoria> listarTodos() { return dao.findAll(); }
	@Override
	public Categoria buscarPorId(Long id) { return dao.findOne(id); }
	@Override
	public Categoria buscarUltimo() {
		return dao.buscarUltimo();
	}
	@Override
	public List<Categoria> buscarCategoriasPadre(Repositorio r) {
		return dao.buscarCategoriasPadre(r);
	}

}
