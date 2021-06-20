package com.vodafone.garage.entity.abstracts.model.dto;

import com.vodafone.garage.entity.abstracts.model.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class VehicleDTO {
    private int id;
    private VehicleType vehicleType;
    private String vehicleColor;
    private String vehicleLicense;
    private int vehicleYear;
}
