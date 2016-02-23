package com.crawl.command.crud;

import java.util.List;

import com.crawl.jpa.data.ValorPropiedad;

public interface IValorPropiedadCRUDManager {
	
	public void eliminar(ValorPropiedad af);
	
	public ValorPropiedad guardar (ValorPropiedad af);
	
	public List<ValorPropiedad> listarTodos ();
	
	public ValorPropiedad buscarPorId (Long id);

}
