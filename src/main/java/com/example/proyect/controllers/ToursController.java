package com.example.proyect.controllers;

import com.example.proyect.entities.Tours;
import com.example.proyect.services.ToursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ToursController {
    @Autowired
    ToursService toursService;
    @GetMapping("/tours")
    public ResponseEntity<List<Tours>> getAllTours() {
        List<Tours> tours = toursService.listAll();
        return new ResponseEntity<List<Tours>>(tours, HttpStatus.OK);
    }
    @GetMapping("/tours/{id}")
    public ResponseEntity<Tours> getAToursById(@PathVariable("id") Long id) {
        Tours tours = toursService.findById(id);
        return new ResponseEntity<Tours>(tours, HttpStatus.OK);
    }
    @PostMapping("/tourss")
    public ResponseEntity<Tours> createTours(@RequestBody Tours tours) {
        Tours newTours = toursService.save(tours);
        return new ResponseEntity<Tours>(newTours, HttpStatus.CREATED);
    }
    @DeleteMapping("/tours/{id}")
    public ResponseEntity<HttpStatus> deleteTours(@PathVariable("id") Long id) {
        toursService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping("/tourss/{id}")
    public ResponseEntity<Tours> updateEmployee(@RequestBody Tours tours, @PathVariable("id") Long id) {
        Tours foundTours = toursService.findById(id);
        if (tours.getName()!=null) {
            foundTours.setName(tours.getName());
        }
        if (tours.getDescription()!=null) {
            foundTours.setDescription(tours.getDescription());
        }
        if (tours.getDate_start()!=null) {
            foundTours.setDate_start(tours.getDate_start());
        }
        if (tours.getDate_finish()!=null) {
            foundTours.setDate_finish(tours.getDate_finish());
        }
        if (tours.getCost()!=null) {
            foundTours.setCost(tours.getCost());
        }
        Tours newTours = toursService.save(foundTours);
        return new ResponseEntity<Tours>(newTours, HttpStatus.OK);
    }

    @PutMapping("/tourss/")
    public ResponseEntity<Tours> updateEmployeeBody(@RequestBody Tours tours) {
        Tours foundTours = toursService.findById(tours.getId());
        if (tours.getName()!=null) {
            foundTours.setName(tours.getName());
        }
        if (tours.getDescription()!=null) {
            foundTours.setDescription(tours.getDescription());
        }
        if (tours.getDate_start()!=null) {
            foundTours.setDate_start(tours.getDate_start());
        }
        if (tours.getDate_finish()!=null) {
            foundTours.setDate_finish(tours.getDate_finish());
        }
        if (tours.getCost()!=null) {
            foundTours.setCost(tours.getCost());
        }
        Tours newTours = toursService.save(foundTours);
        return new ResponseEntity<Tours>(newTours, HttpStatus.OK);
    }
}
