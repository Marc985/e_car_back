package com.codinftitans.backend.controller;

import com.codinftitans.backend.model.FarProduct;
import com.codinftitans.backend.repository.ProductFarRepository;
import com.codinftitans.backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
   // @Autowired
    //ProductRepository productRepository;

            /* public Optional<Product> getProductById(){
        return  null;
        //return productRepository.findById(2);
    }*/
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductFarRepository productFarRepository;
    @GetMapping("/sum/chocolate")
public List<Chocolat> getSumByChocolate(){
   return productRepository.findSumByChocolate();
}
@GetMapping("/product/far")
public FarProduct getProductFar(){
        return productFarRepository.findFarProduct();
}
}
