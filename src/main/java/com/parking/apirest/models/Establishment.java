package com.parking.apirest.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "TB_ESTABLISHMENT")
public class Establishment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String cnpj;
    private String telephoneNumber;
    private Integer motoVacancy;
    private Integer carVacancy;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "establishment")
    private List<Vehicles> vehicles;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public Integer getMotoVacancy() {
        return motoVacancy;
    }

    public void setMotoVacancy(Integer motoVacancy) {
        this.motoVacancy = motoVacancy;
    }

    public Integer getCarVacancy() {
        return carVacancy;
    }

    public void setCarVacancy(Integer carVacancy) {
        this.carVacancy = carVacancy;
    }

    public List<Vehicles> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicles> vehicles) {
        this.vehicles = vehicles;
    }

    @Override
    public String toString() {
        return "Establishment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                ", motoVacancy=" + motoVacancy +
                ", carVacancy=" + carVacancy +
                '}';
    }
}
