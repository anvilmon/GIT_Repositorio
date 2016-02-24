package com.crawl.command.business;

import com.crawl.jpa.data.Repositorio;

public interface IScannerManager {

	public void escanearTodosRepositorios ();
	
	public void escanearRepositorio (final Repositorio r);
	
}
