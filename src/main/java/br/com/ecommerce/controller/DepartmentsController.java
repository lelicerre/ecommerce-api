package br.com.ecommerce.controller;

import br.com.ecommerce.models.Department;
import br.com.ecommerce.services.DepartmentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/departamentos")
public class DepartmentsController {
    private final DepartmentsService departmentsService;

    @Autowired
    public DepartmentsController(DepartmentsService departmentsService) {
        this.departmentsService = departmentsService;
    }

    @GetMapping
    public ResponseEntity<List<Department>> listAll() {
        List<Department> departments = departmentsService.findAll();
        return ResponseEntity.ok(departments);
    }

}
