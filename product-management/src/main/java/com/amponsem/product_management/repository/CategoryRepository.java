package com.amponsem.product_management.repository;

import com.amponsem.product_management.model.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<Category, String> {
}