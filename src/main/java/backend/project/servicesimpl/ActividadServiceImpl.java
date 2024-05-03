package backend.project.services;

import backend.project.entities.Actividad;
import backend.project.repositories.ActividadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActividadServiceImpl implements ActividadService {

    private final ActividadRepository actividadRepository;

    @Autowired
    public ActividadServiceImpl(ActividadRepository actividadRepository) {
        this.actividadRepository = actividadRepository;
    }

    @Override
    public List<Actividad> listAll() {
        return actividadRepository.findAll();
    }

    @Override
    public Actividad findById(int id) {
        return actividadRepository.findById(id).orElse(null);
    }

    @Override
    public Actividad save(Actividad actividad) {
        return actividadRepository.save(actividad);
    }

    @Override
    public void delete(int id) {
        actividadRepository.deleteById(id);
    }
}