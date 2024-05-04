package backend.project.repositories;

import backend.project.entities.Tours;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ToursRepository extends JpaRepository<Tours, Long> {
    List<Tours> findByNameContaining(String name);
}