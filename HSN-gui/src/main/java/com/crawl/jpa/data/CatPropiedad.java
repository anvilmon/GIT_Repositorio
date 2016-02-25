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
	private String forCategory;
	
	@Column(name="forProduct")
	private String forProduct;

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

	public String getForCategory() {
		return forCategory;
	}

	public void setForCategory(String forCategory) {
		this.forCategory = forCategory;
	}

	public String getForProduct() {
		return forProduct;
	}

	public void setForProduct(String forProduct) {
		this.forProduct = forProduct;
	}

	@Override
	public String toString() {
		return "CatPropiedad [id=" + id + ", name=" + name + ", description=" + description + ", forCategory="
				+ forCategory + ", forProduct=" + forProduct + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	
}
