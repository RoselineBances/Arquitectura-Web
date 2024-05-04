package backend.project.services;

import backend.project.entities.Cliente;
import java.util.List;

public interface ClienteService {
    List<Cliente> listAll();
    Cliente findById(long id);
    Cliente save(Cliente cliente);
    void delete(long id);
}