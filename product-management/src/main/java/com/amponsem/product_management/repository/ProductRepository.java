package com.amponsem.product_management.repository;

import com.amponsem.product_management.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
public interface ProductRepository extends MongoRepository<Product, String> {


  @Query("{'name' : ?0}")
  List<Product> findByName(String name);

  @Query("{'price': {$gt: ?0, $lt: ?1 }}")
    List<Product> findByPriceBetween(Double minprice, Double maxprice);


  @Query("{'category': ?0 }")
  List<Product> findByCategory(String category);
}