
package br.com.UserDepartment.controllers;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.UserDepartment.entities.User;
import br.com.UserDepartment.repositories.UserRepository;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private UserRepository repository;

	@GetMapping
	public List<User> findAll() {
		return repository.findAll();
		
	}

	@GetMapping(value = "{id}")
	public User findById(@PathVariable Long id) {
		return repository.findById(id).get();
		
	}

	@PostMapping
	public User save(@RequestBody User user) {
		return repository.save(user);
	}

	@PutMapping(value = "{id}")
	public User update(@PathVariable Long id, @RequestBody User user) {
		User result = repository.findById(id).get();
		BeanUtils.copyProperties(user, result, "id");
		return repository.save(result);
	}

	@DeleteMapping(value = "{id}")
	public void delete(@PathVariable Long id) {
		repository.delete(findById(id));
	}
}
