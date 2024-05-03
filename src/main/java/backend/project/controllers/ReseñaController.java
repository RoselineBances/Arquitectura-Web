package backend.project.controllers;

import backend.project.entities.Reseña;
import backend.project.services.ReseñaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ReseñaController {

    @Autowired
    ReseñaService reseñaService;

    @GetMapping("/reseñas")
    public ResponseEntity<List<Reseña>> getAllReseñas() {
        List<Reseña> reseñas = reseñaService.listAll();
        return new ResponseEntity<>(reseñas, HttpStatus.OK);
    }

    @GetMapping("/reseñas/{id}")
    public ResponseEntity<Reseña> getReseñaById(@PathVariable("id") int id) {
        Reseña reseña = reseñaService.findById(id);
        return new ResponseEntity<>(reseña, HttpStatus.OK);
    }

    @PostMapping("/reseñas")
    public ResponseEntity<Reseña> createReseña(@RequestBody Reseña reseña) {
        Reseña newReseña = reseñaService.save(reseña);
        return new ResponseEntity<>(newReseña, HttpStatus.CREATED);
    }

    @DeleteMapping("/reseñas/{id}")
    public ResponseEntity<HttpStatus> deleteReseña(@PathVariable("id") int id) {
        reseñaService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/reseñas/{id}")
    public ResponseEntity<Reseña> updateReseña(@RequestBody Reseña reseña, @PathVariable("id") int id) {
        Reseña foundReseña = reseñaService.findById(id);
        if (reseña.getComent() != 0) {
            foundReseña.setComent(reseña.getComent());
        }
        if (reseña.getPuntuacion() != 0) {
            foundReseña.setPuntuacion(reseña.getPuntuacion());
        }
        // Add other properties if needed
        Reseña updatedReseña = reseñaService.save(foundReseña);
        return new ResponseEntity<>(updatedReseña, HttpStatus.OK);
    }
}
