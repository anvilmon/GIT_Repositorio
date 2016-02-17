package com.crawl.jpa.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="FOTO")
public class Foto  extends EmptyEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id")
	private long id;
	
	@Column(name="dt_foto")
	@Temporal(TemporalType.DATE)
	private Date dtFoto;
	
	@Column(name="terminado")
	private boolean terminado;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="foto", fetch=FetchType.LAZY)
	private List<AsociacionFotos> asociacionFotos = new ArrayList<AsociacionFotos>();
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDtFoto() {
		return dtFoto;
	}

	public void setDtFoto(Date dtFoto) {
		this.dtFoto = dtFoto;
	}

	public boolean isTerminado() {
		return terminado;
	}

	public void setTerminado(boolean terminado) {
		this.terminado = terminado;
	}

	public List<AsociacionFotos> getAsociacionFotos() {
		return asociacionFotos;
	}

	public void setAsociacionFotos(List<AsociacionFotos> asociacionFotos) {
		this.asociacionFotos = asociacionFotos;
	}

	@Override
	public String toString() {
		return "Foto [id=" + id + ", dtFoto=" + dtFoto + ", terminado=" + terminado + ", asociacionFotos="
				+ asociacionFotos + "]";
	}

}
