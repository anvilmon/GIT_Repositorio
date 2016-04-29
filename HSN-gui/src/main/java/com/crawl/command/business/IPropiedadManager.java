package com.crawl.command.business;

import java.util.List;

import com.crawl.jpa.data.Propiedad;

public interface IPropiedadManager {
	
	public List<Propiedad> listarPropiedadesDeCategoria (Long repId);
	public List<Propiedad> listarPropiedadesDeProducto (Long repId);
	public List<Propiedad> listarPropiedadesDeSistema (Long repId);
	public List<Propiedad> listarPropiedadesSoloSistema(Long repId);

}
