package com.parking.apirest.controllers;

import com.parking.apirest.models.Vehicles;
import com.parking.apirest.repository.VehiclesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class VehiclesController {

    @Autowired
    VehiclesRepository vehiclesRepository;

    @GetMapping("/vehicles")
    public List<Vehicles> getAll(){
        return vehiclesRepository.findAll();
    }

    @GetMapping("/vehicle/{id}")
    public Vehicles getById(@PathVariable(value="id") long id){
        return vehiclesRepository.findById(id);
    }

    @PostMapping("/vehicle")
    public Vehicles create(@RequestBody Vehicles vehicles){
        return vehiclesRepository.save(vehicles);
    }

    @DeleteMapping("/vehicle/{id}")
    public void delete(@PathVariable(value ="id")long id){
        vehiclesRepository.deleteById(id);
    }

    @PutMapping("/vehicles")
    public Vehicles update(@RequestBody Vehicles vehicles){
        return vehiclesRepository.save(vehicles);
    }

}
