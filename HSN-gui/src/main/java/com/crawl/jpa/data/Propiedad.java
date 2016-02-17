package com.crawl.jpa.data;

import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.primefaces.component.selectonemenu.SelectOneMenu;

import com.crawl.primefaces.beans.RepositorioBean;

@Entity
@Table(name="PROPIEDAD")
public class Propiedad extends EmptyEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id")
	private long id;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="fk_repositorio")
	private Repositorio repositorio;
	
	@Column(name="nombre")
	private String name;
	
	@Column(name="descripcion")
	private String description;
	
	@Column(name="valor")
	private String value;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Propiedad [id=" + id + ", repositorio=" + repositorio + ", name=" + name + ", description="
				+ description + ", value=" + value + "]";
	}
	
//	public void repositorioChanged(final AjaxBehaviorEvent event)  {
//		FacesContext context = FacesContext.getCurrentInstance();
//		RepositorioBean bean = context.getApplication().evaluateExpressionGet(context, "#{repositorioBean}", RepositorioBean.class);
//		for (Repositorio r : bean.getLstRepositorios()){
//			if (r.getId() == (Long.valueOf((String) ((SelectOneMenu)event.getComponent()).getSubmittedValue()))){
//				setRepositorio(r);
//				break;
//			}
//		}
//	}
}
