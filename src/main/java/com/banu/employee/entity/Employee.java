package com.banu.employee.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "employee")
@Data
@Getter
@Setter
@ToString
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "employee_id")
	private Long id;

	@Column(name = "name", unique = true)
	private String name;

	@Column(name = "department")
	private String department;

	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	private List<Address> addresses;

	@JoinColumn(name = "insurance_id")
	@OneToOne(cascade = CascadeType.ALL)
	private Insurance insurance;

	public Employee() {
	}

	public Employee(String name) {
		this.name = name;
	}

}
