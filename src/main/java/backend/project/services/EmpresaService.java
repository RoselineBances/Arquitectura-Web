package backend.project.services;

import backend.project.entities.Empresa;

import java.util.List;

public interface EmpresaService {

    List<Empresa> listAll();

    Empresa findById(int id);

    Empresa save(Empresa empresa);

    void delete(int id);
}