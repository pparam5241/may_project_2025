package com.param.may_project_2025.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.param.may_project_2025.entities.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
//	@Query("select * from department where name = :name") - Not Required
	Optional<Department> findByNameAndIsDeletedFalse(String name); // Syntax of Spring Data JPA

	Page<Department> findByIsDeletedFalse(Pageable pageable);

	Optional<Department> findByIdAndIsDeletedFalse(Integer id);
}