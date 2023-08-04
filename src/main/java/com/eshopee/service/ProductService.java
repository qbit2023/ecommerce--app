package com.eshopee.service;

import java.util.List;
import java.util.Optional;

import com.eshopee.model.Product;

public interface ProductService {

	public List<Product> getAllProducts();

	public Optional<Product> getProductById(Long id);

	public Product saveProduct(Product product);

	public void deleteProduct(Long id);
}
