package com.crawl.command.crud;

import java.util.List;

import com.crawl.jpa.data.AsociacionFotos;

public interface IAsociacionFotoCRUDManager {
	
	public void eliminar(AsociacionFotos af);
	
	public AsociacionFotos guardar (AsociacionFotos af);
	
	public List<AsociacionFotos> listarTodos ();
	
	public AsociacionFotos buscarPorId (Long id);

}
