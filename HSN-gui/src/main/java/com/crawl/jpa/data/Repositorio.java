package com.crawl.jpa.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="DAT_REPOSITORIO")
public class Repositorio implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id")
	private Long id;

	@Column(name="url")
	private String url;
	
	@Column(name="image")
	private String image;
	
	@Column(name="active")
	private boolean active;
	
	@Column(name="root")
	private String root;
	
	@Column(name="name")
	private String name;
	
	@OneToMany(mappedBy="repositorio", fetch=FetchType.LAZY)
	private List<Categoria> categorias = new ArrayList<Categoria>();
	
	@OneToMany( mappedBy="repositorio", fetch=FetchType.LAZY)
	private List<AsociacionFotos> asociacionFotos = new ArrayList<AsociacionFotos>();
	
	@OneToMany( mappedBy="repositorio", fetch=FetchType.LAZY)
	private List<Propiedad> propiedades = new ArrayList<Propiedad>();
	
	@OneToMany( mappedBy="repositorio", fetch=FetchType.LAZY)
	private List<Sustitucion> sustituciones = new ArrayList<Sustitucion>();
	
	@OneToMany( mappedBy="repositorio", fetch=FetchType.LAZY)
	private List<Producto> productos = new ArrayList<Producto>();
	
	@OneToOne(mappedBy="repositorio", fetch=FetchType.LAZY)
	private ConfigRepositorio configRepositorio;
	
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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Repositorio [id=" + id + ", url=" + url + ", image=" + image + ", active=" + active + ", root=" + root
				+ ", name=" + name + ", categorias=" + categorias + ", asociacionFotos=" + asociacionFotos
				+ ", propiedades=" + propiedades + ", sustituciones=" + sustituciones + ", productos=" + productos
				+ ", configRepositorio=" + configRepositorio + "]";
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public String getRoot() {
		return root;
	}

	public void setRoot(String root) {
		this.root = root;
	}

	public List<Propiedad> getPropiedades() {
		return propiedades;
	}

	public void setPropiedades(List<Propiedad> propiedades) {
		this.propiedades = propiedades;
	}

	public List<Sustitucion> getSustituciones() {
		return sustituciones;
	}

	public void setSustituciones(List<Sustitucion> sustituciones) {
		this.sustituciones = sustituciones;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ConfigRepositorio getConfigRepositorio() {
		return configRepositorio;
	}

	public void setConfigRepositorio(ConfigRepositorio configRepositorio) {
		this.configRepositorio = configRepositorio;
	}

	
}
