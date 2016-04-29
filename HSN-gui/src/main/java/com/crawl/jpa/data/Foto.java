package com.crawl.jpa.data;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="DAT_FOTO")
public class Foto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id")
	private Long id;
	
	@Column(name="dt_foto")
	@Temporal(TemporalType.DATE)
	private Date dtFoto;
	
	@Column(name="terminado")
	private boolean terminado;
	
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Foto [id=" + id + ", dtFoto=" + dtFoto + ", terminado=" + terminado + "]";
	}

}
