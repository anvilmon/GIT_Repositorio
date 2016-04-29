package com.crawl.jpa.data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="DAT_CONFIG_REPOSITORIO")
public class ConfigRepositorio implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id")
	private Long id;
	
	@Column(name="selectorCategoria")
	private String selectorCategoria;
	
	@Column(name="atributoUrl")
	private String atributoUrl;
	
	@Column(name="atributoNombre")
	private String atributoNombre;
	
	@Column(name="selectorImagen")
	private String selectorImagen;
	
	@Column(name="atributoImagen")
	private String atributoImagen;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_repositorio")
	private Repositorio repositorio;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSelectorCategoria() {
		return selectorCategoria;
	}

	public void setSelectorCategoria(String selectorCategoria) {
		this.selectorCategoria = selectorCategoria;
	}

	public String getAtributoUrl() {
		return atributoUrl;
	}

	public void setAtributoUrl(String atributoUrl) {
		this.atributoUrl = atributoUrl;
	}

	public String getAtributoNombre() {
		return atributoNombre;
	}

	public void setAtributoNombre(String atributoNombre) {
		this.atributoNombre = atributoNombre;
	}

	public String getSelectorImagen() {
		return selectorImagen;
	}

	public void setSelectorImagen(String selectorImagen) {
		this.selectorImagen = selectorImagen;
	}

	public String getAtributoImagen() {
		return atributoImagen;
	}

	public void setAtributoImagen(String atributoImagen) {
		this.atributoImagen = atributoImagen;
	}

	public Repositorio getRepositorio() {
		return repositorio;
	}

	public void setRepositorio(Repositorio repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public String toString() {
		return "ConfigRepositorio [id=" + id + ", selectorCategoria=" + selectorCategoria + ", atributoUrl="
				+ atributoUrl + ", atributoNombre=" + atributoNombre + ", selectorImagen=" + selectorImagen
				+ ", atributoImagen=" + atributoImagen + ", repositorio=" + repositorio + "]";
	}
	
	
}
