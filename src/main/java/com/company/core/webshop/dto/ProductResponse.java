package com.company.core.webshop.dto;

import java.util.List;

import com.company.core.webshop.model.Product;

public class ProductResponse {
	private String status;
	private String message;
	private List<Product> allProducts;
	private List<Product> categoryProducts;
	private Product product;	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<Product> getAllProducts() {
		return allProducts;
	}
	public void setAllProducts(List<Product> allProducts) {
		this.allProducts = allProducts;
	}
	public List<Product> getCategoryProducts() {
		return categoryProducts;
	}
	public void setCategoryProducts(List<Product> categoryProducts) {
		this.categoryProducts = categoryProducts;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	
}
