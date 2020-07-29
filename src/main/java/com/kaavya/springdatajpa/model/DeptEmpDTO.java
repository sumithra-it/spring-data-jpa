package com.kaavya.springdatajpa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class DeptEmpDTO {
	private String empDept;
	private String empName;
	private String empEmail;
	private String empAddress;
}
