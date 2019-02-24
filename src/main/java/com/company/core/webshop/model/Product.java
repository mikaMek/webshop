package com.company.core.webshop.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="productId")
@Entity
@Table(name="product")
public class Product implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7964495756080406240L;
	@Id
	@GeneratedValue
	private int id;
	private String productId;
	private String productName;
	private String productDescription;
	private String category;	
	@OneToMany(mappedBy="parent", cascade = {CascadeType.ALL, CascadeType.MERGE, CascadeType.PERSIST})
	private List<Variant> variants;
	
	public Product() {
		super();
	}

	public Product(String productId, String productName, String productDescription, String category,
			List<Variant> variants) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDescription = productDescription;
		this.category = category;
		this.variants = variants;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<Variant> getVariants() {
		return variants;
	}

	public void setVariants(List<Variant> variants) {
		this.variants = variants;
	}
}
