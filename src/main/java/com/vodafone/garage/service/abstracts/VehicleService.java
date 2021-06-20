package com.vodafone.garage.service.abstracts;

import com.vodafone.garage.common.exceptions.GarageLimitExceedException;
import com.vodafone.garage.entity.abstracts.model.dto.VehicleDTO;
import com.vodafone.garage.entity.concretes.Vehicle;
import com.vodafone.garage.results.DataResult;

import java.util.List;

public interface VehicleService {
    DataResult<List<Vehicle>> getAll();

    DataResult<Vehicle> addVehicle(VehicleDTO vehicleDto) throws GarageLimitExceedException;

    void deleteById(int id);

    DataResult<Long> getTotalCount();

    DataResult<Integer> getTotalSizeOfVehicles();
}
