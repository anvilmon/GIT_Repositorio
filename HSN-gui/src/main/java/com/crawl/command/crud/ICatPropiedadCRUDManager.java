package com.crawl.command.crud;

import java.util.List;

import com.crawl.jpa.data.CatPropiedad;

public interface ICatPropiedadCRUDManager {
	
	public void eliminar(CatPropiedad af);
	
	public CatPropiedad guardar (CatPropiedad af);
	
	public List<CatPropiedad> listarTodos ();
	
	public CatPropiedad buscarPorId (Long id);

}
