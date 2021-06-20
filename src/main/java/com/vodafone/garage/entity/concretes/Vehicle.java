package com.vodafone.garage.entity.concretes;

import com.vodafone.garage.entity.abstracts.model.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "vehicles")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "vehicle_type")
    @Enumerated
    private VehicleType vehicleType;

    @Column(name = "license_id")
    private String licenseId;

    @Column(name = "vehicle_color")
    private String vehicleColor;

    @Column(name = "vehicle_year")
    private int vehicleYear;

    @Column(name = "vehicle_size")
    private int vehicleSize;

}
