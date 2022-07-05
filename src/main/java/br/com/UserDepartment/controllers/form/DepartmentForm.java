package br.com.UserDepartment.controllers.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.UserDepartment.entities.Department;
import br.com.UserDepartment.entities.User;
import br.com.UserDepartment.repositories.UserRepository;


public class DepartmentForm {

	private Long department_id;
	private String department_name;
	@NotNull @NotEmpty
	private String user_name;

	public Long getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(Long department_id) {
		this.department_id = department_id;
	}

	public String getDepartment_name() {
		return department_name;
	}

	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}
	
	public Department converter(UserRepository userRepository) {
		User user = userRepository.findByNome(user_name);
		return new Department(department_name,user);
	}
	

}
