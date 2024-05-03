package backend.project.services;

import backend.project.entities.EventoProgramado;
import backend.project.repositories.EventoProgramadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoProgramadoServiceImpl implements EventoProgramadoService {

    private final EventoProgramadoRepository eventoProgramadoRepository;

    @Autowired
    public EventoProgramadoServiceImpl(EventoProgramadoRepository eventoProgramadoRepository) {
        this.eventoProgramadoRepository = eventoProgramadoRepository;
    }

    @Override
    public List<EventoProgramado> listAll() {
        return eventoProgramadoRepository.findAll();
    }

    @Override
    public EventoProgramado findById(int id) {
        return eventoProgramadoRepository.findById(id).orElse(null);
    }

    @Override
    public EventoProgramado save(EventoProgramado eventoProgramado) {
        return eventoProgramadoRepository.save(eventoProgramado);
    }

    @Override
    public void delete(int id) {
        eventoProgramadoRepository.deleteById(id);
    }
}