package com.banu.employee.rest;

import java.util.List;

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
public class RestEmployee {

	private Long id;
	private String name;
	private String department;
	private List<RestAddress> addresses;
	private RestInsurance insurance;
	private String employeeErrorMsg;

}
