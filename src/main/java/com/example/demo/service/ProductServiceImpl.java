package com.example.demo.service;

import com.example.demo.dao.ProductDAO;
import com.example.demo.dto.ProductCreateDTO;
import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductDAO productDAO;

    @Autowired
    public ProductServiceImpl(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }


    @Override
    public ProductDTO create(ProductCreateDTO productCreateDTO) {
        Product product = new Product();
        product.setProductName(productCreateDTO.getProductName());
        product.setProductPrice(productCreateDTO.getProductPrice());
        product.setProductStock(productCreateDTO.getProductStock());
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());

        Product newProduct = this.productDAO.create(product);
        return ProductDTO.builder()
                .id(newProduct.getId())
                .productName(newProduct.getProductName())
                .productPrice(newProduct.getProductPrice())
                .productStock(newProduct.getProductStock())
                .build();
    }

    @Override
    public ProductDTO read(Long id) {
        Product product = this.productDAO.read(id);
        return ProductDTO.builder()
                .id(product.getId())
                .productName(product.getProductName())
                .productPrice(product.getProductPrice())
                .productStock(product.getProductStock())
                .build();
    }

    @Override
    public ProductDTO update(ProductDTO productDTO) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
