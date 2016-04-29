package com.crawl.jpa.dao;

import java.util.List;

import com.crawl.jpa.data.Propiedad;

public interface PropiedadDaoCustom {
	
	public List<Propiedad> listarPropiedadesDeCategoria (Long repId);
	public List<Propiedad> listarPropiedadesDeProducto 	(Long repId);
	public List<Propiedad> listarPropiedadesDeSistema 	(Long repId);
	public List<Propiedad> listarPropiedadesSoloSistema	(Long repId);
	
}
