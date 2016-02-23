package com.crawl.command.crud;

import java.util.List;

import com.crawl.jpa.data.Producto;

public interface IProductoCRUDManager {
	
	public void eliminar(Producto af);
	
	public Producto guardar (Producto af);
	
	public List<Producto> listarTodos ();
	
	public Producto buscarPorId (Long id);

}
