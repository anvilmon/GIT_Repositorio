package com.crawl.command.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.crawl.command.crud.ICatPropiedadCRUDManager;
import com.crawl.jpa.dao.CatPropiedadDao;
import com.crawl.jpa.data.CatPropiedad;

@Component("catPropiedadCRUD")
@Service
public class CatPropiedadCRUDManagerImpl implements ICatPropiedadCRUDManager {
	
	@Autowired
	private CatPropiedadDao dao;

	@Override
	public void eliminar(CatPropiedad af) { dao.delete(af); }
	@Override
	public CatPropiedad guardar(CatPropiedad af) { return dao.save(af); }
	@Override
	public List<CatPropiedad> listarTodos() { return dao.findAll(); }
	@Override
	public CatPropiedad buscarPorId(Long id) { return dao.findOne(id); }

}
