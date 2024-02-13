package com.microservices.Product.service.repository;

import com.microservices.Product.service.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

public interface ProductRepository extends MongoRepository<Product,String> {


}
