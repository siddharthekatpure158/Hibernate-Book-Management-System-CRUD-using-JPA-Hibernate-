package com.siddharth.Hibernate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class EmployeeDTO {
	
	@Id
	private int id;
	private String name;
	private double salary;
	private long mobile;
	

}
