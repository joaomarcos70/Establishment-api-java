package com.parking.apirest.repository;

import com.parking.apirest.models.Vehicles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehiclesRepository extends JpaRepository<Vehicles,Long> {
}
