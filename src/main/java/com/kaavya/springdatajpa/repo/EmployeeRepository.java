package com.kaavya.springdatajpa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.kaavya.springdatajpa.model.Employee;
import com.kaavya.springdatajpa.model.DeptEmpDTO;

public interface EmployeeRepository extends CrudRepository<Employee, Integer>{
	//This is not native query, its JPQL/HQL (Hibernate QL)
	//use the Entity name and not table name
	@Query("select new com.kaavya.springdatajpa.model.DeptEmpDTO(d.name,e.name,e.email,e.address)"
			+ "FROM Department d INNER JOIN d.employees e")
	List<DeptEmpDTO> fetchDeptInnerJoinEmp();
	
	@Query("select new com.kaavya.springdatajpa.model.DeptEmpDTO(d.name,e.name,e.email,e.address)"
			+ "FROM Department d, Employee e")
	List<DeptEmpDTO> fetchDeptCrossJoinEmp();

}
