package com.kaavya.springdatajpa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.kaavya.springdatajpa.model.Department;
import com.kaavya.springdatajpa.model.DeptEmpDTO;

public interface DepartmentRepository extends CrudRepository<Department, Integer>{
	@Query("select new com.kaavya.springdatajpa.model.DeptEmpDTO(d.name,e.name,e.email,e.address)"
			+ "FROM Department d LEFT JOIN d.employees e")
	List<DeptEmpDTO> fetchDeptLeftJoinEmp();
	
	@Query("select new com.kaavya.springdatajpa.model.DeptEmpDTO(d.name,e.name,e.email,e.address)"
			+ "FROM Department d RIGHT JOIN d.employees e")
	List<DeptEmpDTO> fetchDeptRightJoinEmp();
	
}
