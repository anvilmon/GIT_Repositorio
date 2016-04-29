package com.crawl.command.business;

import java.io.IOException;

import com.crawl.jpa.data.Foto;
import com.crawl.jpa.data.Repositorio;

public interface IScannerManager {

	public void escanearTodosRepositorios () throws IOException;
	
	public void escanearRepositorio (final Repositorio r, Foto foto) throws IOException;
	
}
