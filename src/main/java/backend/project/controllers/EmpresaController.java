package backend.project.controllers;

import backend.project.entities.Empresa;
import backend.project.services.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class EmpresaController {

    @Autowired
    EmpresaService empresaService;

    @GetMapping("/empresas")
    public ResponseEntity<List<Empresa>> getAllEmpresas() {
        List<Empresa> empresas = empresaService.listAll();
        return new ResponseEntity<>(empresas, HttpStatus.OK);
    }

    @GetMapping("/empresas/{id}")
    public ResponseEntity<Empresa> getEmpresaById(@PathVariable("id") int id) {
        Empresa empresa = empresaService.findById(id);
        return new ResponseEntity<>(empresa, HttpStatus.OK);
    }

    @PostMapping("/empresas")
    public ResponseEntity<Empresa> createEmpresa(@RequestBody Empresa empresa) {
        Empresa newEmpresa = empresaService.save(empresa);
        return new ResponseEntity<>(newEmpresa, HttpStatus.CREATED);
    }

    @DeleteMapping("/empresas/{id}")
    public ResponseEntity<HttpStatus> deleteEmpresa(@PathVariable("id") int id) {
        empresaService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/empresas/{id}")
    public ResponseEntity<Empresa> updateEmpresa(@RequestBody Empresa empresa, @PathVariable("id") int id) {
        Empresa foundEmpresa = empresaService.findById(id);
        if (empresa.getTour() != null) {
            foundEmpresa.setTour(empresa.getTour());
        }
        // Add other properties if needed
        Empresa updatedEmpresa = empresaService.save(foundEmpresa);
        return new ResponseEntity<>(updatedEmpresa, HttpStatus.OK);
    }
}