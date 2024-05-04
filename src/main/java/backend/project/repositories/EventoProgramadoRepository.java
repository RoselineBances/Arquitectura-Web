package backend.project.repositories;

import backend.project.entities.EventoProgramado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EventoProgramadoRepository extends JpaRepository<EventoProgramado, Integer> {


    List<EventoProgramado> findByFecha(Date fecha);


    List<EventoProgramado> findByCantPasajeros(int cantPasajeros);

    List<EventoProgramado> findByCostoTotal(double costoTotal);


    List<EventoProgramado> findByTour_Id(int tourId);
}