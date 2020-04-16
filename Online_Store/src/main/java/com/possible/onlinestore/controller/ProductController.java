package com.possible.onlinestore.controller;

import com.possible.onlinestore.models.Category;
import com.possible.onlinestore.models.Product;
import com.possible.onlinestore.services.CategoryService;
import com.possible.onlinestore.services.MapValidationErrorService;
import com.possible.onlinestore.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @GetMapping("/{productCode}")
    public ResponseEntity<?> getProduct(@PathVariable String productCode){
        Product product = productService.findProductByProductCode(productCode);

        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }

    @GetMapping("/all")
    public Iterable<Product> getAllProducts(){


        return productService.findAllProduct();
    }

    @PostMapping("")
    public ResponseEntity<?> createNewProduct(@Valid @RequestBody Product product, BindingResult result){
        ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationErrorsService(result);
        if (errorMap != null)return errorMap;
        Product product1 = productService.saveOrUpdateProduct(product);

        return new ResponseEntity<Product>(product1, HttpStatus.CREATED);
    }


    @DeleteMapping("/{productCode}")
    public ResponseEntity<?> deleteProduct(@PathVariable String productCode){
        productService.deleteProductById(productCode);

        return new ResponseEntity<String>("Project '"+productCode+"' was successfully deleted", HttpStatus.OK);

    }
}

