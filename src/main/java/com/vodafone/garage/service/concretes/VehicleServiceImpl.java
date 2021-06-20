package com.vodafone.garage.service.concretes;

import com.vodafone.garage.common.exceptions.GarageLimitExceedException;
import com.vodafone.garage.entity.abstracts.model.dto.VehicleDTO;
import com.vodafone.garage.entity.concretes.Vehicle;
import com.vodafone.garage.repository.abstracts.VehicleRepository;
import com.vodafone.garage.results.DataResult;
import com.vodafone.garage.results.SuccessDataResult;
import com.vodafone.garage.service.abstracts.VehicleMapper;
import com.vodafone.garage.service.abstracts.VehicleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class VehicleServiceImpl implements VehicleService {
    private static final int MAX_LIMIT_GARAGE = 10;
    private final VehicleRepository vehicleRepository;
    private final VehicleMapper vehicleMapper;

    @Override
    public DataResult<List<Vehicle>> getAll() {
        return new SuccessDataResult<>(vehicleRepository.findAll(), "OK");
    }

    @Override
    public DataResult<Vehicle> addVehicle(VehicleDTO vehicleDto) throws GarageLimitExceedException {
        Vehicle vehicle = vehicleMapper.convertVehicleDTOToVehicleEntity(vehicleDto);
        checkLimit(vehicle);

        printSavedLog(vehicle);
        return new DataResult<>(vehicleRepository.save(vehicle), true);
    }

    private void printSavedLog(Vehicle vehicle) {
        String parkString = "parked " + vehicle.getLicenseId() + "-" + vehicle.getVehicleYear() + " " + vehicle.getVehicleColor() + " " + vehicle.getVehicleType().name();
        log.error(parkString);
    }

    private void checkLimit(Vehicle vehicle) throws GarageLimitExceedException {
        if ((vehicle.getVehicleSize() + getSizeOfVehicles()) >= MAX_LIMIT_GARAGE) {
            throw new GarageLimitExceedException(vehicle.getVehicleSize());
        }
    }

    @Override
    public void deleteById(int id) {
        vehicleRepository.deleteById(id);
    }

    @Override
    public DataResult<Long> getTotalCount() {
        return new SuccessDataResult<>(vehicleRepository.count());
    }

    @Override
    public DataResult<Integer> getTotalSizeOfVehicles() {
        return new SuccessDataResult<>(getSizeOfVehicles(), "OK");
    }

    private int getSizeOfVehicles() {
        return vehicleRepository.findAll().stream().mapToInt(Vehicle::getVehicleSize).sum();

    }
}
