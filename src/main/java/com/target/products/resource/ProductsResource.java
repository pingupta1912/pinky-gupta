package com.target.products.resource;

import com.target.products.exception.ProductNotfoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.target.products.document.Products;
import com.target.products.repository.ProductRepository;


@RestController
@RequestMapping("/products")
public class ProductsResource {

	private static final Logger logger = LoggerFactory.getLogger(ProductsResource.class);

	private ProductRepository productRepository;

	public ProductsResource(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@GetMapping("{id}")
	public Products getBy(@PathVariable("id") String id) {
		logger.info("Fetching product by id " + id);
		return productRepository.findOne(id);
	}

	@PutMapping("{id}")
	public ResponseEntity<Object> updateUser(@PathVariable("id") String id,
											 @RequestBody Products product) {
		logger.info("Updating product by id " + id);
		if (productRepository.findOne(id).getId().isEmpty()) throw new ProductNotfoundException();
		productRepository.save(product);
		return new ResponseEntity<>("Product is updated successfully", HttpStatus.OK);
	}
}
