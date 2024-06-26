package com.codinftitans.backend.dto.response;

import com.codinftitans.backend.dto.base.CarBaseDTO;
import com.codinftitans.backend.model.CarPic;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CarResponseDTO extends CarBaseDTO {
    private UUID id;
    private boolean pinned;
    private List<String> pics;
}
