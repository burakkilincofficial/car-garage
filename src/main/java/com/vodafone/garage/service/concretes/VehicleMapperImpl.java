package com.vodafone.garage.service.concretes;

import com.vodafone.garage.entity.abstracts.model.VehicleType;
import com.vodafone.garage.entity.abstracts.model.dto.VehicleDTO;
import com.vodafone.garage.entity.concretes.Vehicle;
import com.vodafone.garage.service.abstracts.VehicleMapper;
import org.springframework.stereotype.Service;

@Service
public class VehicleMapperImpl implements VehicleMapper {
    @Override
    public VehicleDTO convertVehicleEntityToVehicleDTO(Vehicle vehicle) {
        return VehicleDTO.builder()
                .vehicleColor(vehicle.getVehicleColor())
                .vehicleType(vehicle.getVehicleType())
                .vehicleYear(vehicle.getVehicleYear())
                .vehicleLicense(vehicle.getLicenseId())
                .build();
    }

    @Override
    public Vehicle convertVehicleDTOToVehicleEntity(VehicleDTO vehicleDTO) {
        return Vehicle.builder()
                .id(vehicleDTO.getId())
                .vehicleColor(vehicleDTO.getVehicleColor())
                .vehicleSize(getSizeByVehicleType(vehicleDTO.getVehicleType()))
                .licenseId(vehicleDTO.getVehicleLicense())
                .vehicleType(vehicleDTO.getVehicleType())
                .vehicleYear(vehicleDTO.getVehicleYear())
                .build();
    }

    private int getSizeByVehicleType(VehicleType vehicleType) {
        int result;
        switch (vehicleType) {
            case JEEP:
                result = 2;
                break;
            case TRUCK:
                result = 4;
                break;
            default:
                result = 1;
                break;
        }
        return result;
    }
}
