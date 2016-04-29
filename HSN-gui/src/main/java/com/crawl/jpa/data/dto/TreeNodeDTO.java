package com.crawl.jpa.data.dto;

import java.io.Serializable;
import java.text.DateFormat;

import com.crawl.jpa.data.Categoria;
import com.crawl.jpa.data.Foto;
import com.crawl.jpa.data.Producto;
import com.crawl.jpa.data.Repositorio;
import com.crawl.utils.Constants;

public class TreeNodeDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private Foto foto;
	private Repositorio repositorio;
	private Categoria categoria;
	private Producto producto;
	private int codigo = -1;
	
	public TreeNodeDTO (Foto foto){
		this.foto = foto;
		this.codigo = Constants.TreeNodeType.FOTO_CODE;
	}
	
	public TreeNodeDTO (Foto foto, Repositorio repo){
		this.foto = foto;
		this.repositorio = repo;
		this.codigo = Constants.TreeNodeType.REPOSITORIO_CODE;
	}
	
	public TreeNodeDTO (Foto foto, Repositorio repo, Categoria cate){
		this.foto = foto;
		this.repositorio = repo;
		this.categoria = cate;
		this.codigo = Constants.TreeNodeType.CATEGORIA_CODE;
	}
	
	public TreeNodeDTO (Foto foto, Repositorio repo, Categoria cate, Producto prod){
		this.foto = foto;
		this.repositorio = repo;
		this.categoria = cate;
		this.producto = prod;
		this.codigo = Constants.TreeNodeType.PRODUCTO_CODE;
	}
	
	public Foto getFoto() {
		return foto;
	}
	public void setFoto(Foto foto) {
		this.foto = foto;
	}
	public Repositorio getRepositorio() {
		return repositorio;
	}
	public void setRepositorio(Repositorio repositorio) {
		this.repositorio = repositorio;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer ();
		switch (codigo){
		case Constants.TreeNodeType.FOTO_CODE:
			sb.append( DateFormat.getDateInstance().format(foto.getDtFoto())).append(":").append(foto.getId());
			break;
		case Constants.TreeNodeType.REPOSITORIO_CODE:
			sb.append(repositorio.getName());
			break;
		case Constants.TreeNodeType.CATEGORIA_CODE:
			sb.append(categoria.getName());
			break;
		case Constants.TreeNodeType.PRODUCTO_CODE:
			sb.append(producto.getName());
			break;
		default :
			sb.append("No identificable");
			break;
		}
		return sb.toString();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getNodeName(){return toString();}
	public void setNodeName(){};
}
