package com.codinftitans.backend.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public ModelMapper modelMapper(){
        ModelMapper modelMapper=new ModelMapper();
        /*modelMapper.addMappings(new PropertyMap<Car, CarDTO>() {
            @Override
            protected void configure() {
                map().getIdCar(source.getCategory().getIdCategory());
            }
        });
        modelMapper.addMappings(new PropertyMap<CarDTO, Car>() {
            @Override
            protected void configure() {
                skip(destination.);
            }

        });*/
        return modelMapper;


    }


}
