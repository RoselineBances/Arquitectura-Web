package com.example.proyect.servicesimpl;

import com.example.proyect.entities.Destino;
import com.example.proyect.exceptions.IncompleteDataException;
import com.example.proyect.exceptions.KeyRepeatedDataException;
import com.example.proyect.exceptions.ResourceNotFoundException;
import com.example.proyect.repositories.DestinoRepository;
import com.example.proyect.services.DestinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DestinoServiceImpl implements DestinoService {
    @Autowired
    DestinoRepository destinoRepository;
    @Override
    public List<Destino> listAll() {
        List<Destino> destinos = destinoRepository.findAll();
        for (Destino d: destinos) {
            d.setTours(null);
        }
        return destinos;
    }

    @Override
    public List<Destino> listByName(String name) {
        List<Destino> destinos = destinoRepository.findByNameContaining(name);
        return destinos;
    }

    @Override
    public Destino findById(Long id) {
        Destino destinoFound = destinoRepository.findById(id).orElse(null);
        if (destinoFound == null) {
            throw new ResourceNotFoundException("There are no Employee with the id: "+String.valueOf(id));
        }
        return destinoFound;
    }

    @Override
    public Destino save(Destino destino) {
        if (destino.getName()==null || destino.getName().isEmpty()) {
            throw new IncompleteDataException("Employee name can not be null or empty");
        }
        List<Destino> listDestinoNameDuplicated= destinoRepository.findByNameContaining(destino.getName());
        if (listDestinoNameDuplicated.size()>1 || (listDestinoNameDuplicated.size()==1 && !listDestinoNameDuplicated.get(0).getId().equals(destino.getId())) ) {
            throw new KeyRepeatedDataException("Employee name can not be duplicated");
        }

        return destinoRepository.save(destino);
    }

    @Override
    public void delete(Long id) {
        Destino destino = findById(id);
        destinoRepository.delete(destino);
    }
}
