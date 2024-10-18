package com.example.demo.service;

import com.example.demo.dto.ProductCreateDTO;
import com.example.demo.dto.ProductDTO;

public interface ProductService {
    ProductDTO create(ProductCreateDTO productCreateDTO);
    ProductDTO read(Long id);
    ProductDTO update(ProductDTO productDTO);
    void delete(Long id);
}
