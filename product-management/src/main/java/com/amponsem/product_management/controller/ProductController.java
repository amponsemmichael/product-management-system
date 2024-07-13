package com.amponsem.product_management.controller;

import com.amponsem.product_management.model.Product;
import com.amponsem.product_management.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
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
        return new  ResponseEntity<>("Product created successfully", HttpStatus.CREATED);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Product>> getProductsByName(@PathVariable String name){
        List<Product> products = productService.findByName(name);
        return new ResponseEntity<>(products,HttpStatus.OK);
    }

    @GetMapping("/price")
    public ResponseEntity<List<Product>> getProductsByPrice(){
        Double minPrice = 0.0;
        Double maxPrice = 0.0;
        List<Product> products = productService.findByPriceBetween(minPrice,maxPrice);
     return new ResponseEntity<>(products,HttpStatus.OK);
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable String category){
        List<Product> products = productService.findByCategory(category);
        return new ResponseEntity<>(products,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Page<Product>> getAllProducts(
        @RequestParam(required = false, defaultValue = "0") int page,
        @RequestParam(required = false, defaultValue = "10") int size,
        @RequestParam(required = false, defaultValue = "name") String sortBy){
                Page<Product> products = productService.findAll(page,size,sortBy);
         return new ResponseEntity<>(products,HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable String id){
        productService.deleteProduct(id);
        return new ResponseEntity<>("Product deleted successfully", HttpStatus.OK);
    }

}
