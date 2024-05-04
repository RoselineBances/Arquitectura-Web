package backend.project.controllers;

import backend.project.entities.CaracteristicasCliente;
import backend.project.services.CaracteristicasClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CaracteristicasClienteController {


    CaracteristicasClienteService caracteristicasClienteService;

    @GetMapping("/caracteristicasclientes")
    public ResponseEntity<List<CaracteristicasCliente>> getAllCaracteristicasClientes() {
        List<CaracteristicasCliente> caracteristicasClientes = caracteristicasClienteService.listAll();
        return new ResponseEntity<>(caracteristicasClientes, HttpStatus.OK);
    }

    @GetMapping("/caracteristicasclientes/{id}")
    public ResponseEntity<CaracteristicasCliente> getCaracteristicasClienteById(@PathVariable("id") long id) {
        CaracteristicasCliente caracteristicasCliente = caracteristicasClienteService.findById(id);
        return new ResponseEntity<>(caracteristicasCliente, HttpStatus.OK);
    }

    @PostMapping("/caracteristicasclientes")
    public ResponseEntity<CaracteristicasCliente> createCaracteristicasCliente(@RequestBody CaracteristicasCliente caracteristicasCliente) {
        CaracteristicasCliente newCaracteristicasCliente = caracteristicasClienteService.save(caracteristicasCliente);
        return new ResponseEntity<>(newCaracteristicasCliente, HttpStatus.CREATED);
    }

    @DeleteMapping("/caracteristicasclientes/{id}")
    public ResponseEntity<HttpStatus> deleteCaracteristicasCliente(@PathVariable("id") long id) {
        caracteristicasClienteService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}