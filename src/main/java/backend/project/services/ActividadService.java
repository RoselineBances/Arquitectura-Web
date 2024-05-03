package backend.project.services;

import backend.project.entities.Actividad;

import java.util.List;

public interface ActividadService {

    List<Actividad> listAll();

    Actividad findById(int id);

    Actividad save(Actividad actividad);

    void delete(int id);
}