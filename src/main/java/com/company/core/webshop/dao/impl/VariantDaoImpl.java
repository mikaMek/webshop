package com.company.core.webshop.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.company.core.webshop.dao.VariantDao;
import com.company.core.webshop.model.Variant;

@Repository
public class VariantDaoImpl implements VariantDao {
	@Autowired
	private SessionFactory factory;

	public List<Variant> getAllVariants() {
		String sql = "SELECT FROM product";
		Query query = getSession().createQuery(sql, Variant.class);
		return query.getResultList();
	}

	public List<Variant> getCategoryVariants(String category) {
		String sql = "SELECT P.variants FROM product P WHERE category = :category";
		Query query = getSession().createQuery(sql, Variant.class);
		query.setParameter("category", category);
		return query.getResultList();
	}

	public Variant getVariant(String variantId) {
		String sql = "SELECT FROM product WHERE productId = :productId";
		Query query = getSession().createQuery(sql, Variant.class);
		query.setParameter("productId", variantId);
		return (Variant) query.getResultList().get(0);
	}

	private Session getSession() {
		Session session = null;
		try {
			session = factory.getCurrentSession();
		} catch (HibernateException e) {
			session = factory.openSession();
		}
		return session;
	}
}
