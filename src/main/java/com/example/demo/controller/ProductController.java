package com.example.demo.controller;

import com.example.demo.dto.ProductCreateDTO;
import com.example.demo.dto.ProductDTO;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/product")
@RestController
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @PostMapping("/create")
    public ResponseEntity<ProductDTO> create(@RequestBody ProductCreateDTO productCreateDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(this.productService.create(productCreateDTO));
    }

    @GetMapping("/read")
    public ResponseEntity<ProductDTO> read(@RequestParam Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.productService.read(id));
    }
}
