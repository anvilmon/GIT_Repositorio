package com.crawl.command.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.crawl.command.crud.IAsociacionFotoCRUDManager;
import com.crawl.jpa.dao.AsociacionFotosDao;
import com.crawl.jpa.data.AsociacionFotos;
import com.crawl.jpa.data.Categoria;
import com.crawl.jpa.data.Foto;
import com.crawl.jpa.data.Producto;
import com.crawl.jpa.data.Repositorio;
import com.crawl.jpa.data.ValorPropiedad;

@Component("asocFotoCRUD")
@Service
public class AsociacionFotoCRUDManagerImpl implements IAsociacionFotoCRUDManager {
	
	@Autowired
	private AsociacionFotosDao dao;

	@Override
	public void eliminar(AsociacionFotos af) { dao.delete(af); }
	@Override
	public AsociacionFotos guardar(AsociacionFotos af) { return dao.save(af); }
	@Override
	public List<AsociacionFotos> listarTodos() { return dao.findAll(); }
	@Override
	public AsociacionFotos buscarPorId(Long id) { return dao.findOne(id); }
	@Override
	public void generarParaRepositorio(Foto f, Repositorio r) {
		final AsociacionFotos af = new AsociacionFotos();
		af.setFoto(f);
		af.setRepositorio(r);
		guardar(af);
	}
	@Override
	public void generarParaCategoria(Foto f, Categoria c) {
		final AsociacionFotos af = new AsociacionFotos();
		af.setFoto(f);
		af.setCategoria(c);
		af.setRepositorio(c.getRepositorio());
		guardar(af);
	}
	@Override
	public void generarParaProducto(Foto f, Categoria c, Producto p) {
		final AsociacionFotos af = new AsociacionFotos();
		af.setFoto(f);
		af.setProducto(p);
		af.setCategoria(c);
		af.setRepositorio(c.getRepositorio());
		guardar(af);
	}
	@Override
	public void generarParaValorPropiedad(Foto f, Categoria c, ValorPropiedad vp) {
		final AsociacionFotos af = new AsociacionFotos();
		af.setFoto(f);
		af.setValorPropiedad(vp);
		af.setProducto(vp.getProducto());
		af.setCategoria(c);
		af.setRepositorio(c.getRepositorio());
		guardar(af);
	}

}
