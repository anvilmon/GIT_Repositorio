package com.crawl.jpa.data;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.crawl.jpa.AbstractEntity;

@Entity
@Table(name="CATEGORIA")
public class Categoria  extends AbstractEntity{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id")
	private long id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_repositorio")
	private Repositorio repositorio;
	
	@Column(name="name")
	private String name;
	
	@Column(name="url")
	private String url;
	
	@Column(name="imagen")
	private String image;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_category")
	private Categoria parentCategory;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="categoria", fetch=FetchType.LAZY)
	private List<Producto> productos;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="categoria", fetch=FetchType.LAZY)
	private List<AsociacionFotos> asociacionFotos;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Repositorio getRepositorio() {
		return repositorio;
	}

	public void setRepositorio(Repositorio repositorio) {
		this.repositorio = repositorio;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", repositorio=" + repositorio + ", name=" + name + ", url=" + url + ", image="
				+ image + ", parentCategory=" + parentCategory + ", productos=" + productos + ", asociacionFotos="
				+ asociacionFotos + "]";
	}

	public Categoria getParentCategory() {
		return parentCategory;
	}

	public void setParentCategory(Categoria parentCategory) {
		this.parentCategory = parentCategory;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public List<AsociacionFotos> getAsociacionFotos() {
		return asociacionFotos;
	}

	public void setAsociacionFotos(List<AsociacionFotos> asociacionFotos) {
		this.asociacionFotos = asociacionFotos;
	}
}
