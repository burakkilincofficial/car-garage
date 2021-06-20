package com.vodafone.garage.service.abstracts;

import com.vodafone.garage.entity.abstracts.model.dto.VehicleDTO;
import com.vodafone.garage.entity.concretes.Vehicle;

public interface VehicleMapper {
    VehicleDTO convertVehicleEntityToVehicleDTO(Vehicle vehicle);

    Vehicle convertVehicleDTOToVehicleEntity(VehicleDTO vehicleDTO);
}
