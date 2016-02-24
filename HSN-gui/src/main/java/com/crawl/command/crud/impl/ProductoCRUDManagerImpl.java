package com.crawl.command.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.crawl.command.crud.IProductoCRUDManager;
import com.crawl.jpa.dao.IProductoDao;
import com.crawl.jpa.data.Producto;

@Component("productoCRUD")
@Service
public class ProductoCRUDManagerImpl implements IProductoCRUDManager {
	
	@Autowired
	private IProductoDao dao;

	@Override
	public void eliminar(Producto af) {
		dao.delete(af);
	}

	@Override
	public Producto guardar(Producto af) {
		return dao.save(af);
	}

	@Override
	public List<Producto> listarTodos() {
		return dao.findAll();
	}

	@Override
	public Producto buscarPorId(Long id) {
		return dao.findOne(id);
	}

}
