package com.example.demo.dao;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProductDAOImpl implements ProductDAO {
    private final ProductRepository productRepository;

    public ProductDAOImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public Product create(Product product) {
        return this.productRepository.save(product);
    }

    @Override
    public Product read(Long id) {
        return this.productRepository.getReferenceById(id);
    }

    @Override
    public Product update(Product product) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
