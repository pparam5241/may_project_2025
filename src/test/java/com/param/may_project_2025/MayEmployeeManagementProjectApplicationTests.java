package com.param.may_project_2025;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.param.may_project_2025.controllers.DepartmentController;

@SpringBootTest(classes = MayEmployeeManagementProjectApplication.class)
class MayEmployeeManagementProjectApplicationTests {
	@Autowired
	private DepartmentController departmentController;

	@Test
	void contextLoads() {
		Assertions.assertThat(departmentController).isNotNull();
	}
}