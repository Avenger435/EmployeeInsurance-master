package com.banu.employee.rest;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Component
@Data
@Getter
@Setter
@ToString
@JsonInclude(Include.NON_NULL)
public class RestInsurance {

	private Long id;
	
	private String insurance_type;
	
	private String plan_name;
	
	private String premium;
	
	private String expiry_date;
	
	private String due_date;
	
	private String insuranceErrorMsg;
}
