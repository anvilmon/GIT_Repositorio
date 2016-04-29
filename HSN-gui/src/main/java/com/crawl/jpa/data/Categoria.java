package com.crawl.jpa.data;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="DAT_CATEGORIA")
public class Categoria implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id")
	private Long id;
	
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
	
	@OneToMany( mappedBy="categoria", fetch=FetchType.LAZY)
	private List<ProductoCategoria> productoCategoria;
	
	@OneToMany( mappedBy="categoria", fetch=FetchType.LAZY)
	private List<AsociacionFotos> asociacionFotos;
	
	@OneToMany(mappedBy="parentCategory", fetch=FetchType.LAZY)
	private List<Categoria> childCategorias;

	@OneToOne(mappedBy="categoria", fetch=FetchType.LAZY)
	private ConfigCategoria configCategoria;

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
				+ image + ", parentCategory=" + parentCategory + ", productoCategoria=" + productoCategoria
				+ ", asociacionFotos=" + asociacionFotos + ", childCategorias=" + childCategorias + ", configCategoria="
				+ configCategoria + "]";
	}

	public Categoria getParentCategory() {
		return parentCategory;
	}

	public void setParentCategory(Categoria parentCategory) {
		this.parentCategory = parentCategory;
	}

	public List<AsociacionFotos> getAsociacionFotos() {
		return asociacionFotos;
	}

	public void setAsociacionFotos(List<AsociacionFotos> asociacionFotos) {
		this.asociacionFotos = asociacionFotos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<ProductoCategoria> getProductoCategoria() {
		return productoCategoria;
	}

	public void setProductoCategoria(List<ProductoCategoria> productoCategoria) {
		this.productoCategoria = productoCategoria;
	}

	public ConfigCategoria getConfigCategoria() {
		return configCategoria;
	}

	public void setConfigCategoria(ConfigCategoria configCategoria) {
		this.configCategoria = configCategoria;
	}

	public List<Categoria> getChildCategorias() {
		return childCategorias;
	}

	public void setChildCategorias(List<Categoria> childCategorias) {
		this.childCategorias = childCategorias;
	}
}
