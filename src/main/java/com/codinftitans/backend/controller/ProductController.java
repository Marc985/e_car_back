package com.codinftitans.backend.controller;

import com.codinftitans.backend.dto.ProductDTO;
import com.codinftitans.backend.model.Product;
import com.codinftitans.backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;
    @PostMapping("/product/new")
    public ProductDTO saveProduct(@RequestBody ProductDTO product){
        return  productService.saveNewProduct(product);

    }
    @GetMapping("/products")
    public List<ProductDTO> findAll(){
        return productService.findAllProduct();
    }
    @DeleteMapping("/product/delete")
    public String deleteProduct(@RequestParam (name = "id") int id){
        return productService.deleteById(id);
    }
}
