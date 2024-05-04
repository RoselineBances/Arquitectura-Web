package backend.project.services;

import backend.project.entities.CaracteristicasCliente;
import java.util.List;

public interface CaracteristicasClienteService {
    List<CaracteristicasCliente> listAll();
    CaracteristicasCliente findById(int id);
    CaracteristicasCliente save(CaracteristicasCliente caracteristicasCliente);
    void delete(int id);
}