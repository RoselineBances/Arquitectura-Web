package backend.project.repositories;

import backend.project.entities.CaracteristicasTour;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CaracteristicasTourRepository extends JpaRepository<CaracteristicasTour, Long> {
    List<CaracteristicasTour> findByNameContaining(String name);
}