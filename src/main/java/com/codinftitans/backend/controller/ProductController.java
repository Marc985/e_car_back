package com.codinftitans.backend.controller;

import com.codinftitans.backend.dto.ProductDTO;
import com.codinftitans.backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;
    @PostMapping("/product/new")
    public ProductDTO saveProduct(ProductDTO product){
        return  productService.saveNewProduct(product);

    }
}
