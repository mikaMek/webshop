package com.company.core.webshop.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.core.webshop.dao.ProductDao;
import com.company.core.webshop.dto.ProductResponse;

@Service
@Transactional
public class ProductService {
	@Autowired
	private ProductDao productDao;
	
	public ProductResponse initialize() {
		String message = productDao.inputInitialData();
		ProductResponse response = new ProductResponse();
		response.setStatus("success");
		response.setMessage(message);
		return response;		
	}
	
	public ProductResponse getAllProducts() {
		ProductResponse response = new ProductResponse();
		response.setAllProducts(productDao.getAllProducts());
		response.setStatus("success");
		return response;
	}
}
