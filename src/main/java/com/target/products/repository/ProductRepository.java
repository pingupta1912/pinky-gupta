package com.target.products.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.target.products.document.Products;

public interface ProductRepository extends MongoRepository<Products, String> {
}
