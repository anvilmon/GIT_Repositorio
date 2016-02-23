package com.crawl.command.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.crawl.command.crud.IValorPropiedadCRUDManager;
import com.crawl.jpa.dao.IValorPropiedadDao;
import com.crawl.jpa.data.ValorPropiedad;

@Component("valpropCRUD")
public class ValorPropiedadCRUDManagerImpl implements IValorPropiedadCRUDManager {
	
	@Autowired
	private IValorPropiedadDao dao;

	@Override
	public void eliminar(ValorPropiedad af) {
		dao.delete(af);
	}

	@Override
	public ValorPropiedad guardar(ValorPropiedad af) {
		return dao.save(af);
	}

	@Override
	public List<ValorPropiedad> listarTodos() {
		return dao.findAll();
	}

	@Override
	public ValorPropiedad buscarPorId(Long id) {
		return dao.findOne(id);
	}

}
