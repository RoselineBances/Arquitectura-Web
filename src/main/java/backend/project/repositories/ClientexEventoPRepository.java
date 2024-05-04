package backend.project.repositories;

import backend.project.entities.ClientexEventoP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientexEventoPRepository extends JpaRepository<ClientexEventoP, Integer> {


    List<ClientexEventoP> findByAsistencia(boolean asistencia);

    List<ClientexEventoP> findByEventoProgramado_Id(int eventoProgramadoId);
}