package com.possible.onlinestore.controller;

import com.possible.onlinestore.models.Category;
import com.possible.onlinestore.models.Product;
import com.possible.onlinestore.services.CategoryService;
import com.possible.onlinestore.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public ResponseEntity<?> getProduct(){


        return null;
    }

    @GetMapping("/products")
    public ResponseEntity<?> getProducts(){


        return null;
    }

    @PostMapping("")
    public ResponseEntity<?> createNewProduct(@RequestBody Product product){
        Product product1 = productService.saveOrUpdateProduct(product);

        return new ResponseEntity<Product>(product1, HttpStatus.CREATED);
    }
}

