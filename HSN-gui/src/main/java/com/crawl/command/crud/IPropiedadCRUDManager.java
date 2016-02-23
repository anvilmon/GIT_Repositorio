package com.crawl.command.crud;

import java.util.List;

import com.crawl.jpa.data.Propiedad;

public interface IPropiedadCRUDManager {
	
	public void eliminar(Propiedad af);
	
	public Propiedad guardar (Propiedad af);
	
	public List<Propiedad> listarTodos ();
	
	public Propiedad buscarPorId (Long id);

}
