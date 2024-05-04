package backend.project.services;

import backend.project.entities.Cliente;

import java.util.List;

public interface ClienteService {
    public List<Cliente> listAll();
    public List<Cliente> listByNome(String nome);

    public Cliente findById(long id);


}