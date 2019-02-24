package com.company.core.webshop.dao;

import java.util.List;

import com.company.core.webshop.model.Variant;

public interface VariantDao {
	public List<Variant> getAllVariants();
	public List<Variant> getCategoryVariants(String category);
	public Variant getVariant(String variantId);
}
