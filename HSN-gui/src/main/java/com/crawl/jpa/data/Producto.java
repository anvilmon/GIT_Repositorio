package com.crawl.jpa.data;

import java.util.ArrayList;
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
@Table(name="PRODUCTO")
public class Producto extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id")
	private long id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_repositorio")
	private Repositorio repositorio;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_categoria")
	private Categoria categoria;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="producto", fetch=FetchType.LAZY, orphanRemoval=true)
	private List<AsociacionFotos> asociacionFotos = new ArrayList<AsociacionFotos>();
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="producto", fetch=FetchType.LAZY)
	private List<ValorPropiedad> valores = new ArrayList<ValorPropiedad>();
	
	@Column(name="name")
	private String name;
	
	@Column(name="url")
	private String url;
	
	@Column(name="imagen")
	private String image;
	
	@Column(name="descripcion")
	private String description;
	
	@Column(name="activo")
	private boolean active;

	@Override
	public String toString() {
		return "Producto [id=" + id + ", repositorio=" + repositorio + ", categoria=" + categoria + ", asociacionFotos="
				+ asociacionFotos + ", valores=" + valores + ", name=" + name + ", url=" + url + ", image=" + image
				+ ", description=" + description + ", active=" + active + "]";
	}

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

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<ValorPropiedad> getValores() {
		return valores;
	}

	public void setValores(List<ValorPropiedad> valores) {
		this.valores = valores;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<AsociacionFotos> getAsociacionFotos() {
		return asociacionFotos;
	}

	public void setAsociacionFotos(List<AsociacionFotos> asociacionFotos) {
		this.asociacionFotos = asociacionFotos;
	}
	
	
}
