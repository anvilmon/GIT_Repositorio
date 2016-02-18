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
@Table(name="VALOR_PROPIEDAD")
public class ValorPropiedad extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id")
	private long id;
	
	@Column(name="valor")
	private String value;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_propiedad")
	private Propiedad propiedad;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="valorPropiedad", fetch=FetchType.LAZY, orphanRemoval=true)
	private List<AsociacionFotos> asociacionFotos = new ArrayList<AsociacionFotos>();
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_producto")
	private Producto producto;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public List<AsociacionFotos> getAsociacionFotos() {
		return asociacionFotos;
	}

	public void setAsociacionFotos(List<AsociacionFotos> asociacionFotos) {
		this.asociacionFotos = asociacionFotos;
	}

	@Override
	public String toString() {
		return "ValorPropiedad [id=" + id + ", value=" + value + ", propiedad=" + propiedad + ", asociacionFotos="
				+ asociacionFotos + ", producto=" + producto + "]";
	}
}
