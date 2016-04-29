package com.crawl.command.crud;

import java.util.List;

import com.crawl.jpa.data.Repositorio;

public interface IRepositorioCRUDManager {
	
	public void eliminar(Repositorio af);
	
	public Repositorio guardar (Repositorio af);
	
	public List<Repositorio> listarTodos ();
	
	public Repositorio buscarPorId (Long id);

	public List<Repositorio> listarRepositoriosActivos ();
}
