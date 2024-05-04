package backend.project.repositories;

import backend.project.entities.Reseña;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReseñaRepository extends JpaRepository<Reseña, Integer> {


    List<Reseña> findByPuntuacion(int puntuacion);


    List<Reseña> findByCliente_Id(int clienteId);
}