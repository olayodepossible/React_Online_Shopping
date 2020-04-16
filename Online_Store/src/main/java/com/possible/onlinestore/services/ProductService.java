package com.possible.onlinestore.services;

import com.possible.onlinestore.models.Product;
import com.possible.onlinestore.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product saveOrUpdateProduct(Product product){
        return productRepository.save(product);
    }

    public Product findProductByProductCode(String productCode){
        return productRepository.findByProductCode(productCode);
    }

    public Iterable<Product> findAllProduct(){
        return productRepository.findAll();
    }

    public void deleteProductById(String productCode){
        Product product = productRepository.findByProductCode(productCode);

        productRepository.delete(product);
    }
}
