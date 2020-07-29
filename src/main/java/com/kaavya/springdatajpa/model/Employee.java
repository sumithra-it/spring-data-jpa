package com.kaavya.springdatajpa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@Entity
@Table(name="employee")
public class Employee implements Serializable{

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String name;
	private String email;
	private String address;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="dept_id", insertable=false, updatable=false)
	@Fetch(FetchMode.JOIN)
	private Department department;
}
