package backend.project.controllers;

import backend.project.entities.EventoProgramado;
import backend.project.services.EventoProgramadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class EventoProgramadoController {

    @Autowired
    EventoProgramadoService eventoProgramadoService;

    @GetMapping("/eventos")
    public ResponseEntity<List<EventoProgramado>> getAllEventos() {
        List<EventoProgramado> eventos = eventoProgramadoService.listAll();
        return new ResponseEntity<>(eventos, HttpStatus.OK);
    }

    @GetMapping("/eventos/{id}")
    public ResponseEntity<EventoProgramado> getEventoById(@PathVariable("id") int id) {
        EventoProgramado evento = eventoProgramadoService.findById(id);
        return new ResponseEntity<>(evento, HttpStatus.OK);
    }

    @PostMapping("/eventos")
    public ResponseEntity<EventoProgramado> createEvento(@RequestBody EventoProgramado evento) {
        EventoProgramado newEvento = eventoProgramadoService.save(evento);
        return new ResponseEntity<>(newEvento, HttpStatus.CREATED);
    }

    @DeleteMapping("/eventos/{id}")
    public ResponseEntity<HttpStatus> deleteEvento(@PathVariable("id") int id) {
        eventoProgramadoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/eventos/{id}")
    public ResponseEntity<EventoProgramado> updateEvento(@RequestBody EventoProgramado evento, @PathVariable("id") int id) {
        EventoProgramado foundEvento = eventoProgramadoService.findById(id);
        if (evento.getFecha() != null) {
            foundEvento.setFecha(evento.getFecha());
        }
        if (evento.getCantPasajeros() != 0) {
            foundEvento.setCantPasajeros(evento.getCantPasajeros());
        }
        if (evento.getCostoTotal() != 0.0) {
            foundEvento.setCostoTotal(evento.getCostoTotal());
        }
        // Add other properties if needed
        EventoProgramado updatedEvento = eventoProgramadoService.save(foundEvento);
        return new ResponseEntity<>(updatedEvento, HttpStatus.OK);
    }
}