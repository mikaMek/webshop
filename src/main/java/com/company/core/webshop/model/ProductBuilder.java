package com.company.core.webshop.model;

import java.util.List;

public class ProductBuilder {
	private int id;
	private String productId;
	private String productName;
	private String productDescription;
	private String category;
	private List<Variant> variants;

	public ProductBuilder productId(String productId) {
		this.productId = productId;
		return this;
	}

	public ProductBuilder productName(String productName) {
		this.productName = productName;
		return this;
	}

	public ProductBuilder productDescription(String productDescription) {
		this.productDescription = productDescription;
		return this;
	}

	public ProductBuilder category(String category) {
		this.category = category;
		return this;
	}

	public ProductBuilder variants(List<Variant> variants) {
		this.variants = variants;
		return this;
	}

	public Product build() {
		return new Product(this.productId, this.productName, this.productDescription, this.category, this.variants);
	}

}
