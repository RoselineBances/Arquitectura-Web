package backend.project.services;

import backend.project.entities.Reseña;
import backend.project.repositories.ReseñaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReseñaServiceImpl implements ReseñaService {

    private final ReseñaRepository reseñaRepository;

    @Autowired
    public ReseñaServiceImpl(ReseñaRepository reseñaRepository) {
        this.reseñaRepository = reseñaRepository;
    }

    @Override
    public List<Reseña> listAll() {
        return reseñaRepository.findAll();
    }

    @Override
    public Reseña findById(int id) {
        return reseñaRepository.findById(id).orElse(null);
    }

    @Override
    public Reseña save(Reseña reseña) {
        return reseñaRepository.save(reseña);
    }

    @Override
    public void delete(int id) {
        reseñaRepository.deleteById(id);
    }
}