package com.amponsem.product_management.controller;

import com.amponsem.product_management.model.Product;
import com.amponsem.product_management.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<String> createProduct(@RequestBody Product product){
        productService.addProduct(product);
        return ResponseEntity.ok().body("Product created successfully");
    }

    @GetMapping("/name/{name}")
    public List<Product> getProductsByName(@PathVariable String name){
        return productService.findByName(name);
    }

    @GetMapping("/price")
    public List<Product> getProductsByPriceRange(@RequestParam Double minPrice, @RequestParam Double maxPrice){
        return productService.findByPriceBetween(minPrice, maxPrice);
    }

    @GetMapping("/category/{category}")
    public List<Product> getProductsByCategory(@PathVariable String category){
        return productService.findByCategory(category);
    }

    @GetMapping
    public Page<Product> getAllProducts(@RequestParam int page, @RequestParam int size, @RequestParam String sortBy){
        return productService.findAll(page, size,sortBy);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable String id){
        productService.deleteProduct(id);
        return ResponseEntity.ok().body("Product deleted successfully");
    }

}
