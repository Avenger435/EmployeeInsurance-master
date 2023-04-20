package com.banu.employee.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "address")
@Data
@Getter
@Setter
@ToString
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id")
	private Long id;

	@Column(name = "address_name")
	private String address_name;

//	@Column(name = "address_type")
//	private String address_type;
//
//	@Column(name = "street")
//	private String street;
//
//	@Column(name = "landmark")
//	private String landmark;
//
//	@Column(name = "city")
//	private String city;
//
//	@Column(name = "state")
//	private String state;
//
//	@Column(name = "pincode")
//	private String pincode;

	@JoinColumn(name = "employee_id")
	@ManyToOne
	private Employee employee;

	public Address(String address_name, Employee employee) {
		super();
		this.address_name = address_name;
		this.employee = employee;
	}

	public Address() {
	}

}
