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
@Table(name="DAT_SUSTITUCION")
public class Sustitucion implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id")
	private Long id;
	
	@Column(name="from_val")
	private String from;
	
	@Column(name="to_val")
	private String to;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_repositorio")
	private Repositorio repositorio;


	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public Repositorio getRepositorio() {
		return repositorio;
	}

	public void setRepositorio(Repositorio repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public String toString() {
		return "Sustitucion [id=" + id + ", from=" + from + ", to=" + to + ", repositorio=" + repositorio + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
