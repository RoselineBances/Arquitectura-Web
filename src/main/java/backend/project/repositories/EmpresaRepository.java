package backend.project.repositories;

import backend.project.entities.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {
    // You can add custom query methods here if needed
}