package backend.project.repositories;

import backend.project.entities.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {


    List<Empresa> findByTour_Id(int tourId);
}