package com.company.core.webshop.dao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.company.core.webshop.dao.ProductDao;
import com.company.core.webshop.model.Product;
import com.company.core.webshop.model.ProductBuilder;
import com.company.core.webshop.model.Variant;
import com.company.core.webshop.model.VariantBuilder;

@Repository
public class ProductDaoImpl implements ProductDao {
	@Autowired
	private SessionFactory sessionFactory;

	public List<Product> getAllProducts() {
		return getSession().createCriteria(Product.class).list();
	}

	public List<Product> getCategoryProducts(String category) {
		return getSession().createCriteria(Product.class).add(Restrictions.eq("category", category)).list();
	}

	public Product getProduct(String productId) {
		String sql = "FROM product WHERE productId = :productId";
		Query query = getSession().createQuery(sql, Product.class);
		query.setParameter("productId", productId);
		return (Product) query.getResultList().get(0);
	}

	public String inputInitialData() {
		Product p1 = new ProductBuilder().productId("P00001").productName("Gas giant")
				.productDescription("A massive planet composed primarily of hydrogen and helium.").category("Planets")
				.build();

		Variant v1 = new VariantBuilder().variantId("PV01").parent(p1).color("Blue").size("XL")
				.price(BigDecimal.valueOf(119.99)).discount(BigDecimal.ZERO).discountedPrice(BigDecimal.valueOf(119.99))
				.stockAmount(99).build();
		Variant v2 = new VariantBuilder().variantId("PV02").parent(p1).color("Green").size("XXL")
				.price(BigDecimal.valueOf(119.99)).discount(BigDecimal.ZERO).discountedPrice(BigDecimal.valueOf(119.99))
				.stockAmount(99).build();
		Variant v3 = new VariantBuilder().variantId("PV03").parent(p1).color("Red").size("XXXL")
				.price(BigDecimal.valueOf(119.99)).discount(BigDecimal.ZERO).discountedPrice(BigDecimal.valueOf(119.99))
				.stockAmount(99).build();
		p1.setVariants(Arrays.asList(v1, v2, v3));
		getSession().save(p1);
		return "Successfully Saved Prodcut: " + p1.getProductId();
	}

	private Session getSession() {
		Session session = null;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}
		return session;
	}
}
