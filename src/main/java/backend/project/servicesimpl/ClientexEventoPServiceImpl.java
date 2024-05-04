package backend.project.servicesimpl;

import backend.project.entities.ClientexEventoP;
import backend.project.repositories.ClientexEventoPRepository;
import backend.project.services.ClientexEventoPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientexEventoPServiceImpl implements ClientexEventoPService {

    private final ClientexEventoPRepository clientexEventoPRepository;

    @Autowired
    public ClientexEventoPServiceImpl(ClientexEventoPRepository clientexEventoPRepository) {
        this.clientexEventoPRepository = clientexEventoPRepository;
    }

    @Override
    public List<ClientexEventoP> listAll() {
        return clientexEventoPRepository.findAll();
    }

    @Override
    public ClientexEventoP findById(int id) {
        return clientexEventoPRepository.findById(id).orElse(null);
    }

    @Override
    public ClientexEventoP save(ClientexEventoP clientexEventoP) {
        return clientexEventoPRepository.save(clientexEventoP);
    }

    @Override
    public void delete(int id) {
        clientexEventoPRepository.deleteById(id);
    }
}