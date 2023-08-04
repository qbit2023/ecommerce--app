package com.eshopee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.eshopee.model.Product;
import com.eshopee.service.ProductService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
	private ProductService productService;

	@GetMapping
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Long id) {
		Optional<Product> product = productService.getProductById(id);
		return product.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@PostMapping("/create")
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {
		Product createdProduct = productService.saveProduct(product);
		return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
		Optional<Product> existingProduct = productService.getProductById(id);
		if (existingProduct.isPresent()) {
			product.setId(id);
			Product updatedProduct = productService.saveProduct(product);
			return ResponseEntity.ok(updatedProduct);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
		Optional<Product> existingProduct = productService.getProductById(id);
		if (existingProduct.isPresent()) {
			productService.deleteProduct(id);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
