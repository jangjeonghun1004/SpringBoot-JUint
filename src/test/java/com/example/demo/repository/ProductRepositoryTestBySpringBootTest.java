package com.example.demo.repository;

import com.example.demo.entity.Product;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class ProductRepositoryTestBySpringBootTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    public void basicCRUDTest() {
        /* create */
        // given
        Product givenProduct = new Product();
        givenProduct.setProductName("test product name");
        givenProduct.setProductPrice(999);
        givenProduct.setProductStock(999);
        givenProduct.setCreatedAt(LocalDateTime.now());
        givenProduct.setUpdatedAt(LocalDateTime.now());

        // when
        Product savedProduct = productRepository.save(givenProduct);

        // then
        Assertions.assertThat(savedProduct.getId())
                .isEqualTo(givenProduct.getId());
        Assertions.assertThat(savedProduct.getProductName())
                .isEqualTo(givenProduct.getProductName());
        Assertions.assertThat(savedProduct.getProductPrice())
                .isEqualTo(givenProduct.getProductPrice());
        Assertions.assertThat(savedProduct.getProductStock())
                .isEqualTo(givenProduct.getProductStock());

        /* read */
        // when
        Product selectedProduct = productRepository.findById(savedProduct.getId())
                .orElseThrow(RuntimeException::new);

        // then
        Assertions.assertThat(selectedProduct.getId())
                .isEqualTo(givenProduct.getId());
        Assertions.assertThat(selectedProduct.getProductName())
                .isEqualTo(givenProduct.getProductName());
        Assertions.assertThat(selectedProduct.getProductPrice())
                .isEqualTo(givenProduct.getProductPrice());
        Assertions.assertThat(selectedProduct.getProductStock())
                .isEqualTo(givenProduct.getProductStock());

        /* update */
        // when
        Product foundProduct = productRepository.findById(selectedProduct.getId())
                .orElseThrow(RuntimeException::new);

        foundProduct.setProductName("장난감");

        Product updatedProduct = productRepository.save(foundProduct);

        // then
        assertEquals(updatedProduct.getProductName(), "장난감");

        /* delete */
        // when
        productRepository.delete(updatedProduct);

        // then
        assertFalse(productRepository.findById(selectedProduct.getId()).isPresent());
    }
}