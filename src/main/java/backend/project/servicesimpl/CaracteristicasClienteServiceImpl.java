package backend.project.servicesimpl;

import backend.project.entities.CaracteristicasCliente;
import backend.project.repositories.CaracteristicasClienteRepository;
import backend.project.services.CaracteristicasClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaracteristicasClienteServiceImpl implements CaracteristicasClienteService {

    private final CaracteristicasClienteRepository caracteristicasClienteRepository;

    @Autowired
    public CaracteristicasClienteServiceImpl(CaracteristicasClienteRepository caracteristicasClienteRepository) {
        this.caracteristicasClienteRepository = caracteristicasClienteRepository;
    }

    @Override
    public List<CaracteristicasCliente> listAll() {
        return caracteristicasClienteRepository.findAll();
    }

    @Override
    public CaracteristicasCliente findById(int id) {
        return caracteristicasClienteRepository.findById(id).orElse(null);
    }

    @Override
    public CaracteristicasCliente save(CaracteristicasCliente caracteristicasCliente) {
        return caracteristicasClienteRepository.save(caracteristicasCliente);
    }

    @Override
    public void delete(int id) {
        caracteristicasClienteRepository.deleteById(id);
    }
}