package com.crawl.jpa.data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="DAT_VALOR_PROPIEDAD")
public class ValorPropiedad implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id")
	private Long id;
	
	@Column(name="valor")
	private String value;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_propiedad")
	private Propiedad propiedad;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_producto")
	private Producto producto;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Propiedad getPropiedad() {
		return propiedad;
	}

	public void setPropiedad(Propiedad propiedad) {
		this.propiedad = propiedad;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	@Override
	public String toString() {
		return "ValorPropiedad [id=" + id + ", value=" + value + ", propiedad=" + propiedad + ", producto=" + producto
				+ "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
