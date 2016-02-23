package com.crawl.command.crud;

import java.util.List;

import com.crawl.jpa.data.Categoria;

public interface ICategoriaCRUDManager {
	
	public void eliminar(Categoria af);
	
	public Categoria guardar (Categoria af);
	
	public List<Categoria> listarTodos ();
	
	public Categoria buscarPorId (Long id);

}
