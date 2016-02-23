package com.crawl.command.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.crawl.command.crud.IAsociacionFotoCRUDManager;
import com.crawl.jpa.dao.IAsociacionFotosDao;
import com.crawl.jpa.data.AsociacionFotos;

@Component("asocFotoCRUD")
@Service
public class AsociacionFotoCRUDManagerImpl implements IAsociacionFotoCRUDManager {
	
	@Autowired
	private IAsociacionFotosDao dao;

	@Override
	public void eliminar(AsociacionFotos af) {
		dao.delete(af);
	}

	@Override
	public AsociacionFotos guardar(AsociacionFotos af) {
		return dao.save(af);
	}

	@Override
	public List<AsociacionFotos> listarTodos() {
		return dao.findAll();
	}

	@Override
	public AsociacionFotos buscarPorId(Long id) {
		return dao.findOne(id);
	}

}
