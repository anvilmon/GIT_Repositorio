package com.crawl.command.crud;

import java.util.List;

import com.crawl.jpa.data.Categoria;
import com.crawl.jpa.data.Repositorio;

public interface ICategoriaCRUDManager {
	
	public void eliminar(Categoria af);
	
	public Categoria guardar (Categoria af);
	
	public List<Categoria> listarTodos ();
	
	public Categoria buscarPorId (Long id);
	
	public Categoria buscarUltimo();
	
	public List<Categoria> buscarCategoriasPadre(Repositorio r);

}
