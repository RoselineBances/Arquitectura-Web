package backend.project.repositories;

import backend.project.entities.ActividadesFa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActividadRepository extends JpaRepository<ActividadesFa, Integer> {
    // You can add custom query methods here if needed
}