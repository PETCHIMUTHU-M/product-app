package com.chainsys.product.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import com.chainsys.product.dao.ProductDAO;
import com.chainsys.product.dao.ProductDAOImpl;
import com.chainsys.product.exception.ProductNotFoundException;
import com.chainsys.product.model.Product;

public class ProductServiceImpl implements ProductService {
	private static ProductDAO dao;

	public ProductServiceImpl() {
		dao = new ProductDAOImpl();
	}

	@Override
	public Set<Product> findAll() {
		return dao.findAll();
	}

	@Override
	public Product findById(int id) throws ProductNotFoundException {
		Product Product = dao.findById(id);
		if (Product == null) {
			throw new ProductNotFoundException("Product Id Not Found");
		} else {
			return Product;
		}
	}

	
	@Override
	public Product findByName(String name) throws ProductNotFoundException {
		Product Product = dao.findByName(name);
		if (Product == null) {
			throw new ProductNotFoundException("Product Name Not Found");
		} else {
			return Product;
		}
	}
	
	@Override
	public Product findByDate(String date) throws ProductNotFoundException {
		Product Product = dao.findByDate(date);
		return Product;

	}

	@Override
	public void save(Product Product) {
		dao.save(Product);

	}

	@Override
	public void update_expire(Product updateProduct1) throws ProductNotFoundException {
		Product result = dao.findById(updateProduct1.getId());
		if (result == null) {
			throw new ProductNotFoundException("Product Id Not Found");
		} else {
			dao.update(updateProduct1);
		}

	}

	@Override
	public void update(Product Product) throws ProductNotFoundException {
		Product result = dao.findById(Product.getId());
		if (result == null) {
			throw new ProductNotFoundException("Product Id Not Found");
		} else {
			dao.update(Product);
		}

	}

	@Override
	public void delete(int id) throws ProductNotFoundException {
		Product Product = dao.findById(id);
		if (Product == null) {
			throw new ProductNotFoundException("Product doesn't exist!!");
		} else {
			dao.delete(id);
		}
	}

	@Override
	public void delete(String name) throws ProductNotFoundException{
		Product Product = dao.findByName(name);
		if (Product == null) {
			throw new ProductNotFoundException("Product doesn't exist!!");
		} else {
			dao.delete(name);
		}
		
	}
	
	@Override
	public void delete(LocalDate date) throws ProductNotFoundException {
		Product Product = dao.findByName(date);
		if (Product == null) {
			throw new ProductNotFoundException("Product doesn't exist!!");
		} else {
			dao.delete(date);
		}		
	}

	@Override
	public List<String> findAllName() {
		return dao.findAllName();
	}

	@Override
	public List<Integer> findAllId() {
		return dao.findAllId();

	}





}