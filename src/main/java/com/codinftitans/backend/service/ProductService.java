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

import java.util.List;

@Service
public class ProductService {
    @Autowired
   private ProductRepository productRepository;

    @Autowired
    private ModelMapper mapper;

    public ProductDTO saveNewProduct(ProductDTO product){

        Product newProduct=this.mapper.map(product,Product.class);
        productRepository.save(newProduct);
        return  product;
    }
    public List<Product> findAllProduct(){
        //List<ProductDTO> products=productRepository.findAll().stream()
          //      .map(product -> this.mapper.map(product,ProductDTO.class)).toList();
        return productRepository.findAll();
    }
    public String deleteById(int id){
        productRepository.deleteById(id);
        return "deleted successfullly";
    }
   /* public List<ProductDTO> filterByName(String nameChar){
        List<ProductDTO> products=findAllProduct().stream().filter(product ->
                product.getName().toLowerCase().contains(nameChar)
                ).toList();
        return products;
    }*/

}
