package backend.project.servicesimpl;

import backend.project.entities.Tours;
import backend.project.exceptions.IncompleteDataException;
import backend.project.exceptions.KeyRepeatedDataException;
import backend.project.exceptions.ResourceNotFoundException;
import backend.project.repositories.ToursRepository;
import backend.project.services.ToursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToursServiceImpl implements ToursService {
    @Autowired
    ToursRepository toursRepository;

    @Override
    public List<Tours> listAll() {
        List<Tours> tours = toursRepository.findAll();
        for (Tours t: tours) {
            t.setEventoProgramados(null);
        }
        return tours;
    }
    @Override
    public List<Tours> listByName(String name) {
        List<Tours> tours = toursRepository.findByNameContaining(name);
        return tours;
    }
    @Override
    public Tours findById(long id) {
        Tours toursFound= toursRepository.findById(id).orElse(null);
        if (toursFound == null) {
            throw new ResourceNotFoundException("There are no Employee with the id: "+String.valueOf(id));
        }
        return toursFound;
    }
    @Override
    public Tours save(Tours tours) {
        if (tours.getName()==null || tours.getName().isEmpty()) {
            throw new IncompleteDataException("Employee name can not be null or empty");
        }
        List<Tours> listEmployeeNameDuplicated= toursRepository.findByNameContaining(tours.getName());
        if (listEmployeeNameDuplicated.size()>1 || (listEmployeeNameDuplicated.size()==1 && !listEmployeeNameDuplicated.get(0).getId().equals(tours.getId())) ) {
            throw new KeyRepeatedDataException("Employee name can not be duplicated");
        }

        return toursRepository.save(tours);
    }
    @Override
    public void delete(Long id) {
        Tours tours = findById(id);
        toursRepository.delete(tours);
    }
}