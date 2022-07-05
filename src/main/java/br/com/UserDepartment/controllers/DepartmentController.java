package br.com.UserDepartment.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.UserDepartment.controllers.dto.DepartmentDTO;
import br.com.UserDepartment.controllers.form.DepartmentForm;
import br.com.UserDepartment.entities.Department;
import br.com.UserDepartment.repositories.DepartmentRepository;
import br.com.UserDepartment.repositories.UserRepository;

@RestController
@RequestMapping(value = "/department")
public class DepartmentController {

	@Autowired
	private DepartmentRepository repository;

	@Autowired
	private UserRepository userRepository;

	@GetMapping
	public List<DepartmentDTO> findAll() {
		List<Department> department = repository.findAll();
		return DepartmentDTO.converter(department);
	}

	@GetMapping(value = "{id}")
	public Department findById(@PathVariable Long id) {
		return repository.findById(id).get();
	}

	
	 @PostMapping public ResponseEntity<DepartmentDTO> save(@Valid @RequestBody
	  DepartmentForm departmentForm, UriComponentsBuilder uriBuilder) { Department
	 department = departmentForm.converter(userRepository);
	 repository.save(department);
	 
	 URI uri = uriBuilder.path("/department/{id}").buildAndExpand(department.getDepartment_id()).toUri(); 
	 return ResponseEntity.created(uri).body(new DepartmentDTO(department)); }
	 
	@PutMapping(value = "{id}")
	public Department update(@PathVariable Long id, @Valid @RequestBody Department department) {
		Department result = repository.findById(id).get();
		BeanUtils.copyProperties(department, result, "id");
		return repository.save(result);
	}

	@DeleteMapping(value = "{id}")
	public void delete(@PathVariable Long id) {
		repository.delete(findById(id));

	}
}
