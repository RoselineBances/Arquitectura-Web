package backend.project.services;

import backend.project.entities.Destino;

import java.util.List;

public interface DestinoService {
    public List<Destino> listAll();
    public List<Destino> listByName(String name);



    public Destino findById(Long id);

    public Destino save(Destino destino);
    public void delete(Long id);
}