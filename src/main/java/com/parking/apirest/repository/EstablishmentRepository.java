package com.parking.apirest.repository;

import com.parking.apirest.models.Establishment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstablishmentRepository extends JpaRepository<Establishment,Long> {
}
