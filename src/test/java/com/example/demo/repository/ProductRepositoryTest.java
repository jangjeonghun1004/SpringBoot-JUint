package com.example.demo.repository;

import com.example.demo.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;


    @Test
    public void create() {
        // given
        Product product = new Product();
        product.setProductName("test product name");
        product.setProductPrice(999);
        product.setProductStock(999);
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());

        // when
        Product savedProduct = this.productRepository.save(product);

        // then
        assertEquals(product.getProductName(), savedProduct.getProductName());
        assertEquals(product.getProductPrice(), savedProduct.getProductPrice());
        assertEquals(product.getProductStock(), savedProduct.getProductStock());
        assertEquals(product.getCreatedAt(), savedProduct.getCreatedAt());
        assertEquals(product.getUpdatedAt(), savedProduct.getUpdatedAt());
    }

    @Test
    public void read() {
        // given
        Product givenProduct = new Product();
        givenProduct.setProductName("test product name");
        givenProduct.setProductPrice(999);
        givenProduct.setProductStock(999);
        givenProduct.setCreatedAt(LocalDateTime.now());
        givenProduct.setUpdatedAt(LocalDateTime.now());

        Product savedProduct = this.productRepository.saveAndFlush(givenProduct);

        // when
        Optional<Product> selectedProduct =  this.productRepository.findById(savedProduct.getId());
        if(selectedProduct.isPresent()) {
            Product product = selectedProduct.get();

            // then
            assertEquals(savedProduct.getId(), product.getId());
            assertEquals(savedProduct.getProductName(), product.getProductName());
            assertEquals(savedProduct.getProductPrice(), product.getProductPrice());
            assertEquals(savedProduct.getProductStock(), product.getProductStock());
        }
    }
}
