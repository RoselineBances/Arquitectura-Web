package backend.project.services;

import backend.project.entities.Tours;

import java.util.List;

public interface ToursService {
    public List<Tours> listAll();
    public List<Tours> listByName(String name);



    public Tours findById(Long id);

    public Tours save(Tours tours);
    public void delete(Long id);
}