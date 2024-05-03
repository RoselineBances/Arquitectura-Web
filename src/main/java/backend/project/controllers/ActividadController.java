package backend.project.controllers;

import backend.project.entities.Actividad;
import backend.project.services.ActividadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ActividadController {

    @Autowired
    ActividadService actividadService;

    @GetMapping("/actividades")
    public ResponseEntity<List<Actividad>> getAllActividades() {
        List<Actividad> actividades = actividadService.listAll();
        return new ResponseEntity<>(actividades, HttpStatus.OK);
    }

    @GetMapping("/actividades/{id}")
    public ResponseEntity<Actividad> getActividadById(@PathVariable("id") int id) {
        Actividad actividad = actividadService.findById(id);
        return new ResponseEntity<>(actividad, HttpStatus.OK);
    }

    @PostMapping("/actividades")
    public ResponseEntity<Actividad> createActividad(@RequestBody Actividad actividad) {
        Actividad newActividad = actividadService.save(actividad);
        return new ResponseEntity<>(newActividad, HttpStatus.CREATED);
    }

    @DeleteMapping("/actividades/{id}")
    public ResponseEntity<HttpStatus> deleteActividad(@PathVariable("id") int id) {
        actividadService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/actividades/{id}")
    public ResponseEntity<Actividad> updateActividad(@RequestBody Actividad actividad, @PathVariable("id") int id) {
        Actividad foundActividad = actividadService.findById(id);
        if (actividad.getCaracteristicasClientes() != null) {
            foundActividad.setCaracteristicasClientes(actividad.getCaracteristicasClientes());
        }
        // Add other properties if needed
        Actividad updatedActividad = actividadService.save(foundActividad);
        return new ResponseEntity<>(updatedActividad, HttpStatus.OK);
    }
}