package com.crawl.jpa.data;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="DAT_PROPIEDAD")
public class Propiedad implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id")
	private Long id;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="fk_repositorio")
	private Repositorio repositorio;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="fk_cat_propiedad")
	private CatPropiedad tipoPropiedad;
	
	@Column(name="selector")
	private String selector;

	public Repositorio getRepositorio() {
		return repositorio;
	}

	public void setRepositorio(Repositorio repositorio) {
		this.repositorio = repositorio;
	}

	public CatPropiedad getTipoPropiedad() {
		return tipoPropiedad;
	}

	public void setTipoPropiedad(CatPropiedad tipoPropiedad) {
		this.tipoPropiedad = tipoPropiedad;
	}

	public String getSelector() {
		return selector;
	}

	public void setSelector(String selector) {
		this.selector = selector;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Propiedad [id=" + id + ", repositorio=" + repositorio + ", tipoPropiedad=" + tipoPropiedad
				+ ", selector=" + selector + "]";
	}

}
