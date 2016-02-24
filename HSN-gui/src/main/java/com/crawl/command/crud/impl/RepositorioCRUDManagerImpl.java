package com.crawl.command.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.crawl.command.crud.IRepositorioCRUDManager;
import com.crawl.jpa.dao.IRepositorioDao;
import com.crawl.jpa.data.Repositorio;

@Component("repositorioCRUD")
@Service
public class RepositorioCRUDManagerImpl implements IRepositorioCRUDManager {
	
	@Autowired
	private IRepositorioDao dao;

	@Override
	public void eliminar(Repositorio af) {
		dao.delete(af);
	}

	@Override
	public Repositorio guardar(Repositorio af) {
		return dao.save(af);
	}

	@Override
	public List<Repositorio> listarTodos() {
		return dao.findAll();
	}

	@Override
	public Repositorio buscarPorId(Long id) {
		return dao.findOne(id);
	}

}
