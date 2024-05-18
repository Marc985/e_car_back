package com.codinftitans.backend.service;

import com.codinftitans.backend.dto.ProductDTO;
import com.codinftitans.backend.repository.CarRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
   private CarRepository carRepository;

    @Autowired
    private ModelMapper mapper;

    public ProductDTO saveNewProduct(ProductDTO product){

        Product newProduct=this.mapper.map(product,Product.class);
        carRepository.save(newProduct);
        return  product;
    }
    public List<Product> findAllProduct(){
        //List<ProductDTO> products=productRepository.findAll().stream()
          //      .map(product -> this.mapper.map(product,ProductDTO.class)).toList();
        return carRepository.findAll();
    }
    public String deleteById(int id){
        carRepository.deleteById(id);
        return "deleted successfullly";
    }
   /* public List<ProductDTO> filterByName(String nameChar){
        List<ProductDTO> products=findAllProduct().stream().filter(product ->
                product.getName().toLowerCase().contains(nameChar)
                ).toList();
        return products;
    }*/

}
