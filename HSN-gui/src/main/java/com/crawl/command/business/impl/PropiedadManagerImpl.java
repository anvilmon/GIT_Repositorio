package com.crawl.command.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.crawl.command.business.IPropiedadManager;
import com.crawl.jpa.dao.PropiedadDao;
import com.crawl.jpa.data.Propiedad;

public class PropiedadManagerImpl implements IPropiedadManager {
	
	@Autowired
	private PropiedadDao dao;

	@Override
	public List<Propiedad> listarPropiedadesDeCategoria(Long repId) { return dao.listarPropiedadesDeCategoria(repId); }
	@Override
	public List<Propiedad> listarPropiedadesDeProducto(Long repId) { return dao.listarPropiedadesDeProducto(repId); }
	@Override
	public List<Propiedad> listarPropiedadesDeSistema(Long repId) { return dao.listarPropiedadesDeSistema(repId); }
	@Override
	public List<Propiedad> listarPropiedadesSoloSistema(Long repId) { return dao.listarPropiedadesSoloSistema(repId); }

}
