package com.example.demo.service;

import com.example.demo.dao.ProductDAOImpl;
import com.example.demo.dto.ProductCreateDTO;
import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;

import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

public class ProductServiceTest {
    private final ProductDAOImpl productDAO = Mockito.mock(ProductDAOImpl.class);
    private ProductServiceImpl productService;

    @BeforeEach
    public void setUpTest() {
        this.productService = new ProductServiceImpl(this.productDAO);
    }

    @Test
    public void create() {
        Mockito.when(this.productDAO.create(any(Product.class))).then(returnsFirstArg());

        ProductDTO productDTO = this.productService.create(ProductCreateDTO.builder()
                .productName("test product name")
                .productPrice(999)
                .productStock(999)
                .build()
        );

        Assertions.assertEquals(productDTO.getProductName(), "test product name");
        Assertions.assertEquals(productDTO.getProductPrice(), 999);
        Assertions.assertEquals(productDTO.getProductStock(), 999);

        verify(this.productDAO).create(any());
    }

    @Test
    public void read() {
        Product givenProduct = new Product();
        givenProduct.setId(999L);
        givenProduct.setProductName("test product");
        givenProduct.setProductPrice(999);
        givenProduct.setProductStock(999);
        givenProduct.setCreatedAt(LocalDateTime.now());
        givenProduct.setUpdatedAt(LocalDateTime.now());

        Mockito.when(this.productDAO.read(999L)).thenReturn(givenProduct);

        ProductDTO productDTO = this.productService.read(999L);

        Assertions.assertEquals(productDTO.getId(), givenProduct.getId());
        Assertions.assertEquals(productDTO.getProductName(), givenProduct.getProductName());
        Assertions.assertEquals(productDTO.getProductPrice(), givenProduct.getProductPrice());
        Assertions.assertEquals(productDTO.getProductStock(), givenProduct.getProductStock());

        verify(this.productDAO).read(999L);
    }

}
