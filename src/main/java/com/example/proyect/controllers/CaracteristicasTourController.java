package com.example.proyect.controllers;

import com.example.proyect.entities.CaracteristicasTour;
import com.example.proyect.services.CaracteristicasTourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CaracteristicasTourController {
    @Autowired
    CaracteristicasTourService caracteristicasTourService;
    @GetMapping("/caracteristicasTours")
    public ResponseEntity<List<CaracteristicasTour>> getAllCaracteristicasTours() {
        List<CaracteristicasTour> caracteristicasTours = caracteristicasTourService.listAll();
        return new ResponseEntity<List<CaracteristicasTour>>(caracteristicasTours, HttpStatus.OK);
    }

    @GetMapping("/caracteristicasTours/{id}")
    public ResponseEntity<CaracteristicasTour> getACaracteristicasTourById(@PathVariable("id") Long id) {
        CaracteristicasTour caracteristicasTour = caracteristicasTourService.findById(id);
        return new ResponseEntity<CaracteristicasTour>(caracteristicasTour, HttpStatus.OK);
    }

    @PostMapping("/caracteristicasTours")
    public ResponseEntity<CaracteristicasTour> createCaracteristicasTour(@RequestBody CaracteristicasTour caracteristicasTour) {
        CaracteristicasTour newCaracteristicasTour = caracteristicasTourService.save(caracteristicasTour);
        return new ResponseEntity<CaracteristicasTour>(newCaracteristicasTour, HttpStatus.CREATED);
    }


    @DeleteMapping("/caracteristicasTours/{id}")
    public ResponseEntity<HttpStatus> deleteCaracteristicasTour(@PathVariable("id") Long id) {
        caracteristicasTourService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @PutMapping("/caracteristicasTours/{id}")
    public ResponseEntity<CaracteristicasTour> updateCaracteristicasTour(@RequestBody CaracteristicasTour caracteristicasTour, @PathVariable("id") Long id) {
        CaracteristicasTour foundCaracteristicasTour = caracteristicasTourService.findById(id);
        if (caracteristicasTour.getTours().getName()!=null) {
            foundCaracteristicasTour.setTours(caracteristicasTour.getTours());
        }
        if (caracteristicasTour.getActividadesFa()!=null) {
            foundCaracteristicasTour.setActividadesFa(caracteristicasTour.getActividadesFa());
        }
        CaracteristicasTour newCaracteristicasTour = caracteristicasTourService.save(foundCaracteristicasTour);
        return new ResponseEntity<CaracteristicasTour>(newCaracteristicasTour, HttpStatus.OK);
    }

    //Alternativa 2 -> Pasar el Id por el Body
    @PutMapping("/caracteristicasTours/")
    public ResponseEntity<CaracteristicasTour> updateCaracteristicasTourBody(@RequestBody CaracteristicasTour caracteristicasTour) {
        CaracteristicasTour foundCaracteristicasTour = caracteristicasTourService.findById(caracteristicasTour.getId());
        if (caracteristicasTour.getTours().getName()!=null) {
            foundCaracteristicasTour.setTours(caracteristicasTour.getTours());
        }
        if (caracteristicasTour.getActividadesFa()!=null) {
            foundCaracteristicasTour.setActividadesFa(caracteristicasTour.getActividadesFa());
        }
        CaracteristicasTour newCaracteristicasTour = caracteristicasTourService.save(foundCaracteristicasTour);
        return new ResponseEntity<CaracteristicasTour>(newCaracteristicasTour, HttpStatus.OK);
    }
}
