package com.crawl.jpa.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.crawl.jpa.AbstractEntity;

@Entity
@Table(name="CAT_PROPIEDAD")
public class CatPropiedad extends AbstractEntity{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id")
	private Long id;

	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="forCategory")
	private Boolean forCategory;
	
	@Column(name="forProduct")
	private Boolean forProduct;
	
	@Column(name="system")
	private Boolean system;

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

	@Override
	public String toString() {
		return "CatPropiedad [id=" + id + ", name=" + name + ", description=" + description + ", forCategory="
				+ forCategory + ", forProduct=" + forProduct + ", system=" + system + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getForCategory() {
		return forCategory;
	}

	public void setForCategory(Boolean forCategory) {
		this.forCategory = forCategory;
	}

	public Boolean getForProduct() {
		return forProduct;
	}

	public void setForProduct(Boolean forProduct) {
		this.forProduct = forProduct;
	}

	public Boolean getSystem() {
		return system;
	}

	public void setSystem(Boolean system) {
		this.system = system;
	}

}
