package backend.project.repositories;

import backend.project.entities.Actividad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActividadRepository extends JpaRepository<Actividad, Integer> {
    // You can add custom query methods here if needed
}