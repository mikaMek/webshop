package com.company.core.webshop.dao;

import java.util.List;

import com.company.core.webshop.model.Product;

public interface ProductDao {
	public List<Product> getAllProducts();
	public List<Product> getCategoryProducts(String category);
	public Product getProduct(String productId);
	public String inputInitialData();
}
