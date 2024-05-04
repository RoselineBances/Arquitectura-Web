package backend.project.controllers;

import backend.project.entities.Cliente;
import backend.project.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Void>registrarCliente(@RequestBody Cliente cliente) {
        clienteService.registrarCliente(cliente);
        return ResponseEntity.ok().build();
    }
}