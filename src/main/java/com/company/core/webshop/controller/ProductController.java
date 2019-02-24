package com.company.core.webshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.core.webshop.dto.ProductResponse;
import com.company.core.webshop.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@GetMapping("/init")
	public ProductResponse initProducts() {
		return productService.initialize();
	}
	
	@GetMapping("/getAllProducts")
	public ProductResponse getAllProducts() {
		return productService.getAllProducts();
	}
	
	@GetMapping("/bla")
	public String bla() {
		return productService.getAllProducts().getAllProducts().get(0).getVariants().get(0).getVariantId();
	}
	
	@GetMapping("/test")
	public String test() {
		return "successful";
	}
}
