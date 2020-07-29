package com.kaavya.springdatajpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kaavya.springdatajpa.model.DeptEmpDTO;
import com.kaavya.springdatajpa.service.DeptEmplService;

@RestController
@RequestMapping(path="/org")
public class DepartmentEmployeeController {
	@Autowired
	public DeptEmplService service;
	
	@GetMapping("/inner")
	public List<DeptEmpDTO> getDeptEmployeesInnerJoin() {
		 return service.getDeptEmployeesInnerJoin();
	}
	@GetMapping("/left")
	public List<DeptEmpDTO> left() {
		 return service.getDeptEmployeesLeftJoin();
	}
	@GetMapping("/right")
	public List<DeptEmpDTO> right() {
		 return service.getDeptEmployeesRightJoin();
	}
	@GetMapping("/cross")
	public List<DeptEmpDTO> cross() {
		 return service.getDeptEmployeesCrossJoin();
	}	
}
