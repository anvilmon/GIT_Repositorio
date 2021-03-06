package com.crawl.command.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.crawl.command.crud.ISustitucionCRUDManager;
import com.crawl.jpa.dao.SustitucionDao;
import com.crawl.jpa.data.Repositorio;
import com.crawl.jpa.data.Sustitucion;

@Component("sustitucionCRUD")
@Service
public class SustitucionCRUDManagerImpl implements ISustitucionCRUDManager {
	
	@Autowired
	private SustitucionDao dao;

	@Override
	public void eliminar(Sustitucion af) { dao.delete(af); }
	@Override
	public Sustitucion guardar(Sustitucion af) { return dao.save(af); }
	@Override
	public List<Sustitucion> listarTodos() { return dao.findAll(); }
	@Override
	public Sustitucion buscarPorId(Long id) { return dao.findOne(id); }
	@Override
	public List<Sustitucion> listarParaRepositorio(Repositorio r) { return dao.listarParaRepositorio(r); }

}
