package backend.project.repositories;

import backend.project.entities.CaracteristicasCliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaracteristicasClienteRepository extends JpaRepository<CaracteristicasCliente, Integer> {
}