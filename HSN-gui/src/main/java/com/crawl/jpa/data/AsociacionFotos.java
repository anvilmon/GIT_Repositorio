package com.crawl.jpa.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.crawl.jpa.AbstractEntity;

@Entity
@Table(name="ASOCIACION_FOTOS")
public class AsociacionFotos extends AbstractEntity{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id")
	@GeneratedValue
	private long id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_repositorio", nullable = true)
	private Repositorio repositorio;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_foto", nullable = false)
	private Foto foto;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_categoria", nullable = true)
	private Categoria categoria;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_producto", nullable = true)
	private Producto producto;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_valor_propiedad", nullable = true)
	private ValorPropiedad valorPropiedad;

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

	public Foto getFoto() {
		return foto;
	}

	public void setFoto(Foto foto) {
		this.foto = foto;
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

	public ValorPropiedad getValorPropiedad() {
		return valorPropiedad;
	}

	public void setValorPropiedad(ValorPropiedad valorPropiedad) {
		this.valorPropiedad = valorPropiedad;
	}

	@Override
	public String toString() {
		return "AsociacionFotos [id=" + id + ", repositorio=" + repositorio + ", foto=" + foto + ", categoria="
				+ categoria + ", producto=" + producto + ", valorPropiedad=" + valorPropiedad + "]";
	}
	
	
	
}
