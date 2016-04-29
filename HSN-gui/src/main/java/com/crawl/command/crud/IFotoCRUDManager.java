package com.crawl.command.crud;

import java.util.List;

import com.crawl.jpa.data.Foto;

public interface IFotoCRUDManager {
	
	public void eliminar(Foto af);
	
	public Foto guardar (Foto af);
	
	public List<Foto> listarTodos ();
	
	public Foto buscarPorId (Long id);
	
	public Foto generateNewFoto ();

}
