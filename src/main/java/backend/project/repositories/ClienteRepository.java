package backend.project.repositories;

import backend.project.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {


    List<Cliente> findByNombre(String nombre);

    Cliente findByUsuario_Id(int usuarioId);
}