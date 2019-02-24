package com.company.core.webshop.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="variantId")
@Entity
@Table(name="variant")
public class Variant implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4052346746334133076L;
	@Id
	@GeneratedValue
	private int id;
	@ManyToOne
	private Product parent; // ProductId
	private String variantId;
	private String color;
	private String size;
	private BigDecimal price;
	private BigDecimal discount;
	private BigDecimal discountedPrice;
	private int stockAmount;
	
	public Variant() {
		super();
	}

	public Variant(Product parent, String variantId, String color, String size, BigDecimal price,
			BigDecimal discount, BigDecimal discountedPrice, int stockAmount) {
		super();
		this.parent = parent;
		this.variantId = variantId;
		this.color = color;
		this.size = size;
		this.price = price;
		this.discount = discount;
		this.discountedPrice = discountedPrice;
		this.stockAmount = stockAmount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Product getParent() {
		return parent;
	}

	public void setParent(Product parent) {
		this.parent = parent;
	}

	public String getVariantId() {
		return variantId;
	}

	public void setVariantId(String variantId) {
		this.variantId = variantId;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public BigDecimal getDiscountedPrice() {
		return discountedPrice;
	}

	public void setDiscountedPrice(BigDecimal discountedPrice) {
		this.discountedPrice = discountedPrice;
	}

	public int getStockAmount() {
		return stockAmount;
	}

	public void setStockAmount(int stockAmount) {
		this.stockAmount = stockAmount;
	}
}
