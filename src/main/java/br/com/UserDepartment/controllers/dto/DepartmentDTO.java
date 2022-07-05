package br.com.UserDepartment.controllers.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.UserDepartment.entities.Department;

public class DepartmentDTO {


	private Long department_id;

	private String department_name;

	public DepartmentDTO(Department department) {
		this.department_id = department.getDepartment_id();
		this.department_name = department.getDepartment_name();
	}

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
	
	public static List<DepartmentDTO> converter(List<Department> department) {
		return department.stream().map(DepartmentDTO::new).collect(Collectors.toList());
	}
}
