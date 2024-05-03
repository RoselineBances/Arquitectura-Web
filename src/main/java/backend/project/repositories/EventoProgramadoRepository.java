package backend.project.repositories;

import backend.project.entities.EventoProgramado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoProgramadoRepository extends JpaRepository<EventoProgramado, Integer> {
    // You can add custom query methods here if needed
}