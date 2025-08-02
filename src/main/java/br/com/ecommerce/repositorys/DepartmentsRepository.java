package br.com.ecommerce.repositorys;

import br.com.ecommerce.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentsRepository extends JpaRepository<Department, String> {
}
