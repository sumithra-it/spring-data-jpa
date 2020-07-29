package com.kaavya.springdatajpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaavya.springdatajpa.model.DeptEmpDTO;
import com.kaavya.springdatajpa.repo.DepartmentRepository;
import com.kaavya.springdatajpa.repo.EmployeeRepository;

@Service
public class DeptEmplService {

	@Autowired
	DepartmentRepository deptRepo;
	
	@Autowired
	EmployeeRepository empRepo;
	
	public List<DeptEmpDTO> getDeptEmployeesLeftJoin() {
		return deptRepo.fetchDeptLeftJoinEmp();
	}
	public List<DeptEmpDTO> getDeptEmployeesRightJoin() {
		return deptRepo.fetchDeptRightJoinEmp();
	}
	public List<DeptEmpDTO> getDeptEmployeesInnerJoin() {
		return empRepo.fetchDeptInnerJoinEmp();
	}
	public List<DeptEmpDTO> getDeptEmployeesCrossJoin() {
		return empRepo.fetchDeptCrossJoinEmp();
	}
}
