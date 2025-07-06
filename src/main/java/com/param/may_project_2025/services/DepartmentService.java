package com.param.may_project_2025.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.param.may_project_2025.dao.DepartmentDao;
import com.param.may_project_2025.entities.Department;
import com.param.may_project_2025.models.DepartmentRequestDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class DepartmentService {
	private final DepartmentDao departmentDao;

	public Department createDepartment(DepartmentRequestDto dto) {
		departmentDao.validateByDepartmentName(dto.getName());
		Department dept = Department.builder().name(dto.getName()).isDeleted(false).build();
		return departmentDao.saveAndGet(dept);
	}

	public Page<Department> getAllDepartments(int page, int pageSize) {
		Pageable pageable = PageRequest.of(page, pageSize);
		return departmentDao.findAllDepartment(pageable);
	}

	public Department updateDepartment(Integer id, DepartmentRequestDto dto) {
		Department dept = departmentDao.validateAndGet(id);
		dept.setName(dto.getName());
		return departmentDao.saveAndGet(dept);
	}

	public Department getDepartmentById(Integer id) {
		return departmentDao.validateAndGet(id);
	}

	public void deleteDepartment(Integer id) {

		// Way 3
		Department dept = departmentDao.validateAndGet(id);
		dept.setDeleted(true);
		departmentDao.saveAndGet(dept);

		// Way 1
//		Optional<Department> opt = departmentRepository.findByIdAndIsDeletedFalse(id);
//		if (opt.isEmpty()) {
//			throw new NotFoundException("Department not found with ID: " + id);
//		}
//		Department dept = opt.get();
//		departmentRepository.delete(dept);

		// Way 2
//		departmentRepository.deleteById(id);
	}
}