package br.com.UserDepartment.controllers.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.UserDepartment.entities.User;

public class UserDTO {

	private Long user_id;

	private String user_name;
	private String email;

	private DepartmentDTO department;

	public UserDTO(User user) {
		this.user_id = user.getUser_id();
		this.user_name = user.getUser_name();
		this.email = user.getEmail();

	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public DepartmentDTO getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentDTO department) {
		this.department = department;
	}

	public static List<UserDTO> converter(List<User> user) {
		return user.stream().map(UserDTO::new).collect(Collectors.toList());
	}
}
