//package com.amponsem.product_management.service;
//
//import com.amponsem.product_management.model.Product;
//import com.amponsem.product_management.repository.ProductRepository;
////import com.amponsem.product_management.util.BinaryTree;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class ProductService {
//
//    @Autowired
//    private ProductRepository productRepository;
//
////    private final BinaryTree productTree = new BinaryTree();
//
//    public List<Product> findByName(String name) {
//        return productRepository.findByName(name);
//    }
//
//    public List<Product> findByPriceBetween(Double minPrice, Double maxPrice) {
//        return productRepository.findByPriceBetween(minPrice, maxPrice);
//    }
//
//    public Page<Product> findAll(int page, int size, String sortBy) {
//        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
//        return productRepository.findAll(pageable);
//    }
//
//    public List<Product> findByCategory(String category) {
//        return productRepository.findByCategory(category);
//    }
//
//    public void addProduct(Product product) {
//        productRepository.save(product);
////        productTree.add(product);
//    }
//
////    public boolean productExists(String name) {
////        return productTree.containsNode(name);
////    }
//
//    public void deleteProduct(String id) {
//        productRepository.deleteById(id);
//    }
//
//    public Product updateProduct(String id, Product product) {
//        Optional<Product> existingProduct = productRepository.findById(id);
//        if (existingProduct.isPresent()) {
//            product.setId(id); // Ensure ID consistency
//            return productRepository.save(product); // Save and return the updated product
//        }
//        return null; // Return null if product with given ID is not found
//    }
//}
//
package com.amponsem.product_management.service;

import com.amponsem.product_management.model.Product;
import com.amponsem.product_management.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findByName(String name) {
        return productRepository.findByName(name);
    }

    public List<Product> findByPriceBetween(Double minPrice, Double maxPrice) {
        return productRepository.findByPriceBetween(minPrice, maxPrice);
    }

    public Page<Product> findAll(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return productRepository.findAll(pageable);
    }

    public List<Product> findByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    public Product findById(String id) {
        Optional<Product> productOptional = productRepository.findById(id);
        return productOptional.orElse(null);
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(String id, Product product) {
        Optional<Product> existingProduct = productRepository.findById(id);
        if (existingProduct.isPresent()) {
            product.setId(id); // Ensure ID consistency
            return productRepository.save(product); // Save and return the updated product
        }
        return null; // Return null if product with given ID is not found
    }

    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }
}
