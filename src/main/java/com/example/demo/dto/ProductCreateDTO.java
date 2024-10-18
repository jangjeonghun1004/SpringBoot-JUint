package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ProductCreateDTO {
    private String productName;
    private int productPrice;
    private int productStock;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
