package backend.project.controllers;

import backend.project.entities.ActividadesFa;
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
    public ResponseEntity<List<ActividadesFa>> getAllActividades() {
        List<ActividadesFa> actividades = actividadService.listAll();
        return new ResponseEntity<>(actividades, HttpStatus.OK);
    }

    @GetMapping("/actividades/{id}")
    public ResponseEntity<ActividadesFa> getActividadById(@PathVariable("id") int id) {
        ActividadesFa actividad = actividadService.findById(id);
        return new ResponseEntity<>(actividad, HttpStatus.OK);
    }

    @PostMapping("/actividades")
    public ResponseEntity<ActividadesFa> createActividad(@RequestBody ActividadesFa actividad) {
        ActividadesFa newActividad = actividadService.save(actividad);
        return new ResponseEntity<>(newActividad, HttpStatus.CREATED);
    }

    @DeleteMapping("/actividades/{id}")
    public ResponseEntity<HttpStatus> deleteActividad(@PathVariable("id") int id) {
        actividadService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/actividades/{id}")
    public ResponseEntity<ActividadesFa> updateActividad(@RequestBody ActividadesFa actividad, @PathVariable("id") int id) {
        ActividadesFa foundActividad = actividadService.findById(id);
        if (actividad.getCaracteristicasClientes() != null) {
            foundActividad.setCaracteristicasClientes(actividad.getCaracteristicasClientes());
        }
        // Add other properties if needed
        ActividadesFa updatedActividad = actividadService.save(foundActividad);
        return new ResponseEntity<>(updatedActividad, HttpStatus.OK);
    }
}