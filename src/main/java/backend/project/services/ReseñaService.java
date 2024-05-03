package backend.project.services;

import backend.project.entities.Reseña;

import java.util.List;

public interface ReseñaService {

    List<Reseña> listAll();

    Reseña findById(int id);

    Reseña save(Reseña reseña);

    void delete(int id);
}