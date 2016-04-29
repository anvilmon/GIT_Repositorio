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
@Table(name="DAT_CONFIG_CATEGORIA")
public class ConfigCategoria implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id")
	private Long id;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_categoria")
	private Categoria categoria;
	
	@Column(name="selectorSubcategoria")
	private String selectorSubcategoria;
	
	@Column(name="atributoUrlSubcat")
	private String atributoUrlSubcat;
	
	@Column(name="atributoNombreSubcat")
	private String atributoNombreSubcat;
	
	@Column(name="selectorImagenSubcat")
	private String selectorImagenSubcat;
	
	@Column(name="atributoUrlImagenSubcat")
	private String atributoImagenSubcat;
	
	@Column(name="selectorProducto")
	private String selectorProducto;
	
	@Column(name="atributoUrlProd")
	private String atributoUrlProd;
	
	@Column(name="atributoNombreProd")
	private String atributoNombreProd;
	
	@Column(name="selectorImagenProd")
	private String selectorImagenProd;
	
	@Column(name="atributoImagenProd")
	private String atributoImagenProd;
	
	@Column(name="tieneSubcategorias")
	private Boolean tieneSubcategorias;
	
	@Column(name="selectorPaginador")
	private String selectorPaginador;
	
	@Column(name="atributoPaginador")
	private String atributoPaginador;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getSelectorSubcategoria() {
		return selectorSubcategoria;
	}

	public void setSelectorSubcategoria(String selectorSubcategoria) {
		this.selectorSubcategoria = selectorSubcategoria;
	}

	public String getAtributoUrlSubcat() {
		return atributoUrlSubcat;
	}

	public void setAtributoUrlSubcat(String atributoUrlSubcat) {
		this.atributoUrlSubcat = atributoUrlSubcat;
	}

	public String getAtributoNombreSubcat() {
		return atributoNombreSubcat;
	}

	public void setAtributoNombreSubcat(String atributoNombreSubcat) {
		this.atributoNombreSubcat = atributoNombreSubcat;
	}

	public String getSelectorImagenSubcat() {
		return selectorImagenSubcat;
	}

	public void setSelectorImagenSubcat(String selectorImagenSubcat) {
		this.selectorImagenSubcat = selectorImagenSubcat;
	}

	public String getAtributoImagenSubcat() {
		return atributoImagenSubcat;
	}

	public void setAtributoImagenSubcat(String atributoImagenSubcat) {
		this.atributoImagenSubcat = atributoImagenSubcat;
	}

	public String getSelectorProducto() {
		return selectorProducto;
	}

	public void setSelectorProducto(String selectorProducto) {
		this.selectorProducto = selectorProducto;
	}

	public String getAtributoUrlProd() {
		return atributoUrlProd;
	}

	public void setAtributoUrlProd(String atributoUrlProd) {
		this.atributoUrlProd = atributoUrlProd;
	}

	public String getAtributoNombreProd() {
		return atributoNombreProd;
	}

	public void setAtributoNombreProd(String atributoNombreProd) {
		this.atributoNombreProd = atributoNombreProd;
	}

	public String getSelectorImagenProd() {
		return selectorImagenProd;
	}

	public void setSelectorImagenProd(String selectorImagenProd) {
		this.selectorImagenProd = selectorImagenProd;
	}

	public String getAtributoImagenProd() {
		return atributoImagenProd;
	}

	public void setAtributoImagenProd(String atributoImagenProd) {
		this.atributoImagenProd = atributoImagenProd;
	}

	public Boolean getTieneSubcategorias() {
		return tieneSubcategorias;
	}

	public void setTieneSubcategorias(Boolean tieneSubcategorias) {
		this.tieneSubcategorias = tieneSubcategorias;
	}

	@Override
	public String toString() {
		return "ConfigCategoria [id=" + id + ", categoria=" + categoria + ", selectorSubcategoria="
				+ selectorSubcategoria + ", atributoUrlSubcat=" + atributoUrlSubcat + ", atributoNombreSubcat="
				+ atributoNombreSubcat + ", selectorImagenSubcat=" + selectorImagenSubcat + ", atributoImagenSubcat="
				+ atributoImagenSubcat + ", selectorProducto=" + selectorProducto + ", atributoUrlProd="
				+ atributoUrlProd + ", atributoNombreProd=" + atributoNombreProd + ", selectorImagenProd="
				+ selectorImagenProd + ", atributoImagenProd=" + atributoImagenProd + ", tieneSubcategorias="
				+ tieneSubcategorias + "]";
	}

	public String getAtributoPaginador() {
		return atributoPaginador;
	}

	public void setAtributoPaginador(String atributoPaginador) {
		this.atributoPaginador = atributoPaginador;
	}
	
	
}
