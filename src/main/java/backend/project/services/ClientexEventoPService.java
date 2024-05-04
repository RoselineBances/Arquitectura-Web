package backend.project.services;

import backend.project.entities.ClientexEventoP;
import java.util.List;

public interface ClientexEventoPService {
    List<ClientexEventoP> listAll();
    ClientexEventoP findById(int id);
    ClientexEventoP save(ClientexEventoP clientexEventoP);
    void delete(int id);
}