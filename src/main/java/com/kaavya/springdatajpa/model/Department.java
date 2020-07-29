package com.kaavya.springdatajpa.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@Entity
@Table(name = "department")
public class Department implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String name;
	
	private String description;
	
	@OneToMany(targetEntity=Employee.class, mappedBy="id", orphanRemoval=false, fetch=FetchType.LAZY)
	private Set<Employee> employees;
}
