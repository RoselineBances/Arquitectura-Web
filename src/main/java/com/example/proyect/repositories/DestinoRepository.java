package com.example.proyect.repositories;

import com.example.proyect.entities.Destino;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DestinoRepository extends JpaRepository<Destino, Long> {
    List<Destino> findByNameContaining(String name);
}
