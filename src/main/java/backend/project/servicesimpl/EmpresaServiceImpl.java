package backend.project.services;

import backend.project.entities.Empresa;
import backend.project.repositories.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaServiceImpl implements EmpresaService {

    private final EmpresaRepository empresaRepository;

    @Autowired
    public EmpresaServiceImpl(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    @Override
    public List<Empresa> listAll() {
        return empresaRepository.findAll();
    }

    @Override
    public Empresa findById(int id) {
        return empresaRepository.findById(id).orElse(null);
    }

    @Override
    public Empresa save(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    @Override
    public void delete(int id) {
        empresaRepository.deleteById(id);
    }
}