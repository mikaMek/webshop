package com.company.core.webshop.model;

import java.math.BigDecimal;

public class VariantBuilder {
	private Product parent;
	private String variantId;
	private String color;
	private String size;
	private BigDecimal price;
	private BigDecimal discount;
	private BigDecimal discountedPrice;
	private int stockAmount;
	
	public VariantBuilder parent(Product parent) {
		this.parent = parent;
		return this;
	}
	public VariantBuilder variantId(String variantId) {
		this.variantId = variantId;
		return this;
	}
	public VariantBuilder color(String color) {
		this.color = color;
		return this;
	}
	public VariantBuilder size(String size) {
		this.size = size;
		return this;
	}
	public VariantBuilder price(BigDecimal price) {
		this.price = price;
		return this;
	}
	public VariantBuilder discount(BigDecimal discount) {
		this.discount = discount;
		return this;
	}
	public VariantBuilder discountedPrice(BigDecimal discountedPrice) {
		this.discountedPrice = discountedPrice;
		return this;
	}
	public VariantBuilder stockAmount(int stockAmount) {
		this.stockAmount = stockAmount;
		return this;
	}
	
	public Variant build() {
		return new Variant(this.parent, this.variantId, this.color, this.size, this.price, this.discount, this.discountedPrice, this.stockAmount);
	}
	
}
