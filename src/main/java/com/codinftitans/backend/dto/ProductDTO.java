package com.codinftitans.backend.dto;

import com.codinftitans.backend.model.Category;
import com.codinftitans.backend.model.Order;
import com.codinftitans.backend.model.ProductPic;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Set;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDTO {
    private int idProduct;
    private String name;
    private String description;
    private double price;
    private List<String> pics;
    private  int idCategory;

}
