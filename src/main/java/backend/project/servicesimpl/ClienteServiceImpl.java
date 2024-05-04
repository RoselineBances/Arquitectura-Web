package backend.project.servicesimpl;

import backend.project.entities.Cliente;
import backend.project.repositories.ClienteRepository;
import backend.project.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<Cliente> listAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente findById(long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @Override
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public void delete(long id) {
        clienteRepository.deleteById(id);
    }
}