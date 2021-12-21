package com.parking.apirest.dto;

import com.parking.apirest.enums.TypeVehicle;

public class VehicleCreateDto {

    String brand;
    String model;
    String color;
    String plate;
    TypeVehicle type;
    Long establishment_id;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public TypeVehicle getType() {
        return type;
    }

    public void setType(TypeVehicle type) {
        this.type = type;
    }

    public Long getEstablishment_id() {
        return establishment_id;
    }

    public void setEstablishment_id(Long establishment_id) {
        this.establishment_id = establishment_id;
    }
}
