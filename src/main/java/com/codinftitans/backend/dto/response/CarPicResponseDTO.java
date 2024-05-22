package com.codinftitans.backend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CarPicResponseDTO implements Serializable {
    private  UUID id;
    private String url;
}
