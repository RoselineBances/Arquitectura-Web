package com.example.proyect.services;

import com.example.proyect.entities.CaracteristicasTour;

import java.util.List;

public interface CaracteristicasTourService {
    public List<CaracteristicasTour> listAll();
    public List<CaracteristicasTour> listByName(String name);



    public CaracteristicasTour findById(Long id);

    public CaracteristicasTour save(CaracteristicasTour caracteristicasTour);
    public void delete(Long id);
}
