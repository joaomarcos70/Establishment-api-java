package com.parking.apirest.controllers;

import com.parking.apirest.models.Establishment;
import com.parking.apirest.repository.EstablishmentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class EstablishmentController {

    @Autowired
    EstablishmentRepository establishmentRepository;

    @GetMapping("/establishments")
    public List<Establishment> getAll(){
        return establishmentRepository.findAll();
    }

    @GetMapping("/establishment/{id}")
    public Establishment getById(@PathVariable(value="id") long id){
        return establishmentRepository.findById(id);
    }

    @PostMapping("/establishment")
    public Establishment create(@RequestBody Establishment establishment){
        return establishmentRepository.save(establishment);
    }

    @DeleteMapping("/establishment/{id}")
    public void delete(@PathVariable(value ="id")long id){
        establishmentRepository.deleteById(id);
    }

    @PutMapping("/establishment")
    public Establishment update(@RequestBody Establishment establishment){
        return establishmentRepository.save(establishment);
    }
}
