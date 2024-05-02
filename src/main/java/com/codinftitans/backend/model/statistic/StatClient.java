package com.codinftitans.backend.model.statistic;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class StatClient {

    String clientName;
    String clientEmail;
    String totalPrix;
}
