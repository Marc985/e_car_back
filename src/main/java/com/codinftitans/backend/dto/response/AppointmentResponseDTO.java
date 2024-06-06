package com.codinftitans.backend.dto.response;

import com.codinftitans.backend.dto.base.AppointmentBaseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AppointmentResponseDTO extends AppointmentBaseDTO {
    private UUID id;

}
