package backend.project.servicesimpl;

import backend.project.entities.CaracteristicasTour;
import backend.project.exceptions.IncompleteDataException;
import backend.project.exceptions.KeyRepeatedDataException;
import backend.project.exceptions.ResourceNotFoundException;
import backend.project.repositories.CaracteristicasTourRepository;
import backend.project.services.CaracteristicasTourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaracteristicasTourServicesImpl implements CaracteristicasTourService {
    @Autowired
    CaracteristicasTourRepository caracteristicasTourRepository;
    @Override
    public List<CaracteristicasTour> listAll() {
        List<CaracteristicasTour> caracteristicasTours = caracteristicasTourRepository.findAll();
        for (CaracteristicasTour c: caracteristicasTours) {
            c.setTours(null);
        }
        return caracteristicasTours;
    }

    @Override
    public List<CaracteristicasTour> listByName(String name) {
        List<CaracteristicasTour> caracteristicasTours = caracteristicasTourRepository.findByNameContaining(name);
        return caracteristicasTours;
    }

    @Override
    public CaracteristicasTour findById(Long id) {
        CaracteristicasTour caracteristicasTourFound = caracteristicasTourRepository.findById(id).orElse(null);
        if (caracteristicasTourFound == null) {
            throw new ResourceNotFoundException("There are no Employee with the id: "+String.valueOf(id));
        }
        return caracteristicasTourFound;
    }

    @Override
    public CaracteristicasTour save(CaracteristicasTour caracteristicasTour) {
        if (caracteristicasTour.getTours().getName()==null || caracteristicasTour.getTours().getName().isEmpty()) {
            throw new IncompleteDataException("Employee name can not be null or empty");
        }
        List<CaracteristicasTour> listCaracteristicasTourToursDuplicated= caracteristicasTourRepository.findByNameContaining(caracteristicasTour.getTours().getName());
        if (listCaracteristicasTourToursDuplicated.size()>1 || (listCaracteristicasTourToursDuplicated.size()==1 && !listCaracteristicasTourToursDuplicated.get(0).getId().equals(caracteristicasTour.getId())) ) {
            throw new KeyRepeatedDataException("Employee name can not be duplicated");
        }

        return caracteristicasTourRepository.save(caracteristicasTour);
    }

    @Override
    public void delete(Long id) {
        CaracteristicasTour caracteristicasTour = findById(id);
        caracteristicasTourRepository.delete(caracteristicasTour);
    }
}