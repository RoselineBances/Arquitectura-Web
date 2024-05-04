package backend.project.services;

import backend.project.entities.ActividadesFa;

import java.util.List;

public interface ActividadService {

    List<ActividadesFa> listAll();

    ActividadesFa findById(int id);

    ActividadesFa save(ActividadesFa actividad);

    void delete(int id);
}