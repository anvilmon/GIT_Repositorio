package com.crawl.command.crud;

import java.util.List;

import com.crawl.jpa.data.Sustitucion;

public interface ISustitucionCRUDManager {
	
	public void eliminar(Sustitucion af);
	
	public Sustitucion guardar (Sustitucion af);
	
	public List<Sustitucion> listarTodos ();
	
	public Sustitucion buscarPorId (Long id);

}
