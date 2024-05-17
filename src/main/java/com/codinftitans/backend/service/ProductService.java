package com.codinftitans.backend.service;

import com.codinftitans.backend.dto.ProductDTO;
import com.codinftitans.backend.model.Product;
import com.codinftitans.backend.repository.OrderRepository;
import com.codinftitans.backend.repository.ProductRepository;
import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
   private ProductRepository productRepository;

  private   ModelMapper mapper=new ModelMapper();

    public ProductDTO saveNewProduct(ProductDTO product){
        mapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        Product newProduct=this.mapper.map(product,Product.class);
        productRepository.save(newProduct);
        return  product;
    }

}
