package com.crawl.command.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.crawl.command.crud.IPropiedadCRUDManager;
import com.crawl.jpa.dao.IPropiedadDao;
import com.crawl.jpa.data.Propiedad;

@Component("propiedadCRUD")
@Service
public class PropiedadCRUDManagerImpl implements IPropiedadCRUDManager {
	
	@Autowired
	private IPropiedadDao dao;

	@Override
	public void eliminar(Propiedad af) { dao.delete(af); }
	@Override
	public Propiedad guardar(Propiedad af) { return dao.save(af); }
	@Override
	public List<Propiedad> listarTodos() { return dao.findAll(); }
	@Override
	public Propiedad buscarPorId(Long id) { return dao.findOne(id); }

}
