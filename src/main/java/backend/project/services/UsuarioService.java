package backend.project.services;

import backend.project.entities.Usuario;
import java.util.List;

public interface UsuarioService {
    List<Usuario> listAll();
    Usuario findById(int id);
    Usuario save(Usuario usuario);
    void delete(int id);
}