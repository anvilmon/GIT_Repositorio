package com.crawl.command.crud;

import java.util.List;

import com.crawl.jpa.data.AsociacionFotos;
import com.crawl.jpa.data.Categoria;
import com.crawl.jpa.data.Foto;
import com.crawl.jpa.data.Producto;
import com.crawl.jpa.data.Repositorio;
import com.crawl.jpa.data.ValorPropiedad;

public interface IAsociacionFotoCRUDManager {
	
	public void eliminar(AsociacionFotos af);
	
	public AsociacionFotos guardar (AsociacionFotos af);
	
	public List<AsociacionFotos> listarTodos ();
	
	public AsociacionFotos buscarPorId (Long id);

	public void generarParaRepositorio 	(Foto f, Repositorio r);
	
	public void generarParaCategoria  	(Foto f, Categoria c);
	
	public void generarParaProducto  	(Foto f, Categoria c, Producto p);
	
	public void generarParaValorPropiedad(Foto f, Categoria c, ValorPropiedad vp);

}
