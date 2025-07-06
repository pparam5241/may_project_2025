package com.param.may_project_2025.controllers;

import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.param.may_project_2025.entities.Department;
import com.param.may_project_2025.models.DepartmentRequestDto;
import com.param.may_project_2025.services.DepartmentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/department")
public class DepartmentController {
	private final DepartmentService departmentService;

	@PostMapping
	public ResponseEntity<Department> createDepartment(@RequestBody DepartmentRequestDto dto) {
		log.info("DepartmentRequestDto: {}", dto);
		return ResponseEntity.ok(departmentService.createDepartment(dto));
	}

	@GetMapping
	public ResponseEntity<Page<Department>> findAllDepartments(@RequestParam int page, @RequestParam int pageSize) {
		log.info("Find all Employees for Page: {} and pageSize: {}", page, pageSize);
		return ResponseEntity.ok(departmentService.getAllDepartments(page, pageSize));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Department> updateDepartment(@PathVariable Integer id,
			@RequestBody DepartmentRequestDto dto) {
		log.info("Update Department Request for ID: {} and Body: {}", id, dto);
		return ResponseEntity.ok(departmentService.updateDepartment(id, dto));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, String>> updateDepartment(@PathVariable Integer id) {
		log.info("Delete Department Request for ID : {}", id);
		departmentService.deleteDepartment(id);
		return ResponseEntity.ok(Map.of("message", "Department Deleted Successfully!", "status", "200"));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Department> getDepartmentById(@PathVariable Integer id) {
		return ResponseEntity.ok(departmentService.getDepartmentById(id));
	}
}