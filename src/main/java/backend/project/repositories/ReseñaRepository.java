package backend.project.repositories;

import backend.project.entities.Reseña;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReseñaRepository extends JpaRepository<Reseña, Integer> {
    // You can add custom query methods here if needed
}