package com.crawl.command.crud;

import java.util.List;

import com.crawl.jpa.data.ConfigRepositorio;
import com.crawl.jpa.data.Repositorio;

public interface IConfigRepositorioCRUDManager {

	public void eliminar(ConfigRepositorio af);
	
	public ConfigRepositorio guardar (ConfigRepositorio af);
	
	public List<ConfigRepositorio> listarTodos ();
	
	public ConfigRepositorio buscarPorId (Long id);

	public ConfigRepositorio buscarPorRepositorio(Repositorio r);	
	
}
