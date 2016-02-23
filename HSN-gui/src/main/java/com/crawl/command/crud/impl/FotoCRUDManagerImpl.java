package com.crawl.command.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.crawl.command.crud.IFotoCRUDManager;
import com.crawl.jpa.dao.IFotoDao;
import com.crawl.jpa.data.Foto;

@Component("fotoCRUD")
public class FotoCRUDManagerImpl implements IFotoCRUDManager {
	
	@Autowired
	private IFotoDao dao;

	@Override
	public void eliminar(Foto af) {
		dao.delete(af);
	}

	@Override
	public Foto guardar(Foto af) {
		return dao.save(af);
	}

	@Override
	public List<Foto> listarTodos() {
		return dao.findAll();
	}

	@Override
	public Foto buscarPorId(Long id) {
		return dao.findOne(id);
	}

}
