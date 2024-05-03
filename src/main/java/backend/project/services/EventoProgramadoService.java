package backend.project.services;

import backend.project.entities.EventoProgramado;

import java.util.List;

public interface EventoProgramadoService {

    List<EventoProgramado> listAll();

    EventoProgramado findById(int id);

    EventoProgramado save(EventoProgramado eventoProgramado);

    void delete(int id);
}