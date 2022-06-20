package br.com.UserDepartment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.UserDepartment.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
