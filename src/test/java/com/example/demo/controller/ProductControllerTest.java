package com.example.demo.controller;

import com.example.demo.dto.ProductCreateDTO;
import com.example.demo.dto.ProductDTO;
import com.example.demo.service.ProductServiceImpl;
import com.google.gson.Gson;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(ProductController.class)
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ProductServiceImpl productService;

    @Test
    @DisplayName("Test: create()")
    public void create() throws Exception {
        given(this.productService.create(ProductCreateDTO.builder()
                        .productName("test product")
                        .productPrice(999)
                        .productStock(999)
                        .build())
        ).willReturn(ProductDTO.builder()
                        .id(999L)
                        .productName("test product")
                        .productPrice(999)
                        .productStock(999)
                        .createdAt(LocalDateTime.now())
                        .updatedAt(LocalDateTime.now())
                        .build()
        );

        Gson gson = new Gson();
        String content = gson.toJson(ProductCreateDTO.builder()
                        .productName("test product")
                        .productPrice(999)
                        .productStock(999)
                        .build()
        );

        this.mockMvc.perform(post("/product/create")
                .content(content)
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.productName").exists())
                .andExpect(jsonPath("$.productPrice").exists())
                .andExpect(jsonPath("$.productStock").exists())
                .andExpect(jsonPath("$.createdAt").exists())
                .andExpect(jsonPath("$.updatedAt").exists())
                .andDo(print())
        ;

        verify(this.productService).create(ProductCreateDTO.builder()
                        .productName("test product")
                        .productPrice(999)
                        .productStock(999)
                        .build()
        );
    }

    @Test
    @DisplayName("Test: read()")
    public void read() throws Exception {
        given(this.productService.read(20L)).willReturn(
                ProductDTO.builder()
                        .id(999L)
                        .productName("test product name")
                        .productPrice(999)
                        .productStock(999)
                        .build()
        );

        this.mockMvc.perform(get("/product/read?id=" + 20))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.productName").exists())
                .andExpect(jsonPath("$.productPrice").exists())
                .andExpect(jsonPath("$.productStock").exists())
                .andDo(print())
        ;

        verify(this.productService).read(20L);
    }

}
