package com.vodafone.garage.repository.abstracts;


import com.vodafone.garage.entity.concretes.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
}
