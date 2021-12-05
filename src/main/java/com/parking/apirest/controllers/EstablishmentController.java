package com.parking.apirest.controllers;

import com.parking.apirest.models.Establishment;
import com.parking.apirest.repository.EstablishmentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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
}
