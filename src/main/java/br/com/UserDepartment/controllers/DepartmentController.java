package br.com.UserDepartment.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.UserDepartment.entities.Department;
import br.com.UserDepartment.repositories.DepartmentRepository;

@RestController
@RequestMapping(value = "/department")
public class DepartmentController {
	
	@Autowired
	private DepartmentRepository repository;
	
	@GetMapping
	public List<Department> findAll() {
		return repository.findAll();
	}
	
	@GetMapping(value = "{id}")
	public Department findById(@PathVariable Long id) {
		return repository.findById(id).get();
	}
	
	@PostMapping
	public Department save(@RequestBody Department department){
		return repository.save(department);
	}
	
	@DeleteMapping(value = "{id}")
	public void delete(@PathVariable Long id) {
		repository.delete(findById(id));
	}

}
