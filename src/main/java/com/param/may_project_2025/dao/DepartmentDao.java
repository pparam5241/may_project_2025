package com.param.may_project_2025.dao;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.param.may_project_2025.entities.Department;
import com.param.may_project_2025.exceptions.AlreadyExistsException;
import com.param.may_project_2025.exceptions.NotFoundException;
import com.param.may_project_2025.repositories.DepartmentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DepartmentDao {

	private final DepartmentRepository repository;

	public Department validateAndGet(Integer id) {
		Optional<Department> opt = repository.findByIdAndIsDeletedFalse(id);
		if (opt.isEmpty()) {
			throw new NotFoundException("Department not found with ID: " + id);
		}
		return opt.get();
	}

	public void validateByDepartmentName(String name) {
		Optional<Department> opt = repository.findByNameAndIsDeletedFalse(name);
		if (opt.isPresent()) {
			throw new AlreadyExistsException("Department already exists with name: " + name);
		}
	}

	public Page<Department> findAllDepartment(Pageable pageable) {
		return repository.findByIsDeletedFalse(pageable);
	}

	public Department saveAndGet(Department dept) {
		return repository.save(dept);
	}
}