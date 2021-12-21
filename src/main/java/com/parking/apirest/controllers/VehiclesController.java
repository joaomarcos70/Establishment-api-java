package com.parking.apirest.controllers;

import com.parking.apirest.dto.VehicleCreateDto;
import com.parking.apirest.enums.TypeVehicle;
import com.parking.apirest.models.Establishment;
import com.parking.apirest.models.Vehicles;
import com.parking.apirest.repository.EstablishmentRepository;
import com.parking.apirest.repository.VehiclesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class VehiclesController {

    @Autowired
    VehiclesRepository vehiclesRepository;

    @Autowired
    EstablishmentRepository establishmentRepository;

    @GetMapping("/vehicles")
    public List<Vehicles> getAll() {
        return vehiclesRepository.findAll();
    }

    @GetMapping("/vehicle/{id}")
    public Optional<Vehicles> getById(@PathVariable(value = "id") long id) {
        return vehiclesRepository.findById(id);
    }

    @PostMapping("/vehicle")
    public ResponseEntity<String> create(@RequestBody VehicleCreateDto body) {

        Vehicles vehicle = new Vehicles();
        vehicle.setBrand(body.getBrand());
        vehicle.setColor(body.getColor());
        vehicle.setModel(body.getModel());
        vehicle.setPlate(body.getPlate());
        vehicle.setType(body.getType());

        Optional<Establishment> optEstablishment = establishmentRepository.findById(body.getEstablishment_id());

        if (optEstablishment.isPresent()) {
            Establishment establishment = optEstablishment.get();

            TypeVehicle type = body.getType();
            if (type == TypeVehicle.CAR) {
                establishment.setCarVacancy(establishment.getCarVacancy() - 1);
            } else {
                establishment.setMotoVacancy(establishment.getMotoVacancy() - 1);
            }
            vehicle.setEstablishment(establishment);
        }

        vehiclesRepository.save(vehicle);

        return new ResponseEntity<String>("Veículo cadastrado com sucesso!", HttpStatus.OK);

    }

    @DeleteMapping("/vehicle/{id}")
    public void delete(@PathVariable(value = "id") long id) {
        vehiclesRepository.deleteById(id);
    }

    @PutMapping("/vehicles")
    public Vehicles update(@RequestBody Vehicles vehicles) {
        return vehiclesRepository.save(vehicles);
    }

}
