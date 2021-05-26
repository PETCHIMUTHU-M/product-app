package com.chainsys.product.dao;

import java.util.Set;

import com.chainsys.product.exception.ProductNotFoundException;
import com.chainsys.product.model.Product;

public interface ProductDAO {
	Set<Product> findAll();

	Product findById(int id);
	Product findByName(String name);

	void save(Product product);

	void update(Product product);
	void update_expire(Product updateProduct1);

	void delete(int id);

	void delete(String name);

}