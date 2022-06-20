package br.com.UserDepartment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.UserDepartment.entities.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
