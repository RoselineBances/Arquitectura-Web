package backend.project.controllers;

import backend.project.entities.ClientexEventoP;
import backend.project.services.ClientexEventoPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ClientexEventoPController {


    private ClientexEventoPService clientexEventoPService;

    @GetMapping("/clientexeventosp")
    public ResponseEntity<List<ClientexEventoP>> getAllClientexEventoP() {
        List<ClientexEventoP> clientexEventoPs = clientexEventoPService.listAll();
        return new ResponseEntity<>(clientexEventoPs, HttpStatus.OK);
    }

    @GetMapping("/clientexeventosp/{id}")
    public ResponseEntity<ClientexEventoP> getClientexEventoPById(@PathVariable("id") int id) {
        ClientexEventoP clientexEventoP = clientexEventoPService.findById(id);
        return new ResponseEntity<>(clientexEventoP, HttpStatus.OK);
    }

    @PostMapping("/clientexeventosp")
    public ResponseEntity<ClientexEventoP> createClientexEventoP(@RequestBody ClientexEventoP clientexEventoP) {
        ClientexEventoP newClientexEventoP = clientexEventoPService.save(clientexEventoP);
        return new ResponseEntity<>(newClientexEventoP, HttpStatus.CREATED);
    }

    @DeleteMapping("/clientexeventosp/{id}")
    public ResponseEntity<HttpStatus> deleteClientexEventoP(@PathVariable("id") int id) {
        clientexEventoPService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}