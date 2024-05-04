package backend.project.controllers;

import backend.project.entities.Cliente;
import backend.project.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ClienteController {


    ClienteService clienteService;

    @GetMapping("/clientes")
    public ResponseEntity<List<Cliente>> getAllClientes() {
        List<Cliente> clientes = clienteService.listAll();
        return new ResponseEntity<List<Cliente>>(clientes, HttpStatus.OK);
    }

    @GetMapping("/clientes/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable("id") int id) {
        Cliente cliente = clienteService.findById(id);
        return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
    }

    @PostMapping("/clientes")
    public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente) {
        Cliente newCliente = clienteService.save(cliente);
        return new ResponseEntity<Cliente>(newCliente, HttpStatus.CREATED);
    }

    @DeleteMapping("/clientes/{id}")
    public ResponseEntity<HttpStatus> deleteCliente(@PathVariable("id") int id) {
        clienteService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/clientes/{id}")
    public ResponseEntity<Cliente> updateCliente(@RequestBody Cliente cliente, @PathVariable("id") int id) {
        Cliente foundCliente = clienteService.findById(id);

         if (cliente.getNombre() != null) {
            foundCliente.setNombre(cliente.getNombre());
            }

        Cliente newCliente = clienteService.save(foundCliente);
        return new ResponseEntity<Cliente>(newCliente, HttpStatus.OK);
    }
}