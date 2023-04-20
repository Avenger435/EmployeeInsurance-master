package com.banu.employee.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "insurance")
@Data
@Getter
@Setter
@ToString
public class Insurance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "insurance_type")
	private String insurance_type;

	@Column(name = "plan_name")
	private String plan_name;

	@Column(name = "premium")
	private String premium;

	@Column(name = "expiry_date")
	private String expiry_date;

	@Column(name = "due_date")
	private String due_date;

}
