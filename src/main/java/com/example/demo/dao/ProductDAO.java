package com.example.demo.dao;

import com.example.demo.entity.Product;

public interface ProductDAO {
    Product create(Product product);
    Product read(Long id);
    Product update(Product product);
    void delete(Long id);
}
