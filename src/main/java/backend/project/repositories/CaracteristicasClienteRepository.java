package backend.project.repositories;

import backend.project.entities.CaracteristicasCliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CaracteristicasClienteRepository extends JpaRepository<CaracteristicasCliente, Integer> {


    List<CaracteristicasCliente> findByClienteId(int clienteId);


    List<CaracteristicasCliente> findByActividadFa_Id(int actividadId);
}