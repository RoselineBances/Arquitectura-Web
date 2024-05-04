package backend.project.controllers;

import backend.project.entities.Destino;
import backend.project.services.DestinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class DestinoController {
    @Autowired
    DestinoService destinoService;
    @GetMapping("/destinos")
    public ResponseEntity<List<Destino>> getAllDestinos() {
        List<Destino> destinos = destinoService.listAll();
        return new ResponseEntity<List<Destino>>(destinos, HttpStatus.OK);
    }

    @GetMapping("/destinos/{id}")
    public ResponseEntity<Destino> getADestinoById(@PathVariable("id") Long id) {
        Destino destino = destinoService.findById(id);
        return new ResponseEntity<Destino>(destino, HttpStatus.OK);
    }

    @PostMapping("/destinos")
    public ResponseEntity<Destino> createDestino(@RequestBody Destino destino) {
        Destino newDestino = destinoService.save(destino);
        return new ResponseEntity<Destino>(newDestino, HttpStatus.CREATED);
    }


    @DeleteMapping("/destinos/{id}")
    public ResponseEntity<HttpStatus> deleteDestino(@PathVariable("id") Long id) {
        destinoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @PutMapping("/destinos/{id}")
    public ResponseEntity<Destino> updateDestino(@RequestBody Destino destino, @PathVariable("id") Long id) {
        Destino foundDestino = destinoService.findById(id);
        if (destino.getName()!=null) {
            foundDestino.setName(destino.getName());
        }
        if (destino.getDescription()!=null) {
            foundDestino.setDescription(destino.getDescription());
        }
        Destino newDestino = destinoService.save(foundDestino);
        return new ResponseEntity<Destino>(newDestino, HttpStatus.OK);
    }


    @PutMapping("/destinos/")
    public ResponseEntity<Destino> updateDestinoBody(@RequestBody Destino destino) {
        Destino foundDestino = destinoService.findById(destino.getId());
        if (destino.getName()!=null) {
            foundDestino.setName(destino.getName());
        }
        if (destino.getDescription()!=null) {
            foundDestino.setDescription(destino.getDescription());
        }
        Destino newDestino = destinoService.save(foundDestino);
        return new ResponseEntity<Destino>(newDestino, HttpStatus.OK);
    }
}