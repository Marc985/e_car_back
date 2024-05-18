package com.codinftitans.backend.config;

import com.codinftitans.backend.dto.ProductDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public ModelMapper modelMapper(){
        ModelMapper modelMapper=new ModelMapper();
        modelMapper.addMappings(new PropertyMap<Product, ProductDTO>() {
            @Override
            protected void configure() {
                map().setIdCategory(source.getCategory().getIdCategory());
            }
        });
        modelMapper.addMappings(new PropertyMap<ProductDTO, Product>() {
            @Override
            protected void configure() {
                skip(destination.getCategory());
            }

        });
        return modelMapper;
    }


}
