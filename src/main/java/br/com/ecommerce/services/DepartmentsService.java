package br.com.ecommerce.services;

import br.com.ecommerce.models.Department;
import br.com.ecommerce.repositorys.DepartmentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentsService {
    private final DepartmentsRepository departmentsRepository;

    @Autowired
    public DepartmentsService(DepartmentsRepository departmentsRepository) {
        this.departmentsRepository = departmentsRepository;
    }

    public List<Department> findAll() {
        return departmentsRepository.findAll();
    }
}
