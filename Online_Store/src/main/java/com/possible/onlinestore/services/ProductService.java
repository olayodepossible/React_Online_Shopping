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
}
