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
public class RestAddress {

	private Long id;

	private String address_name;

	private String address_type;

	private String street;

	private String landmark;

	private String city;

	private String state;

	private String pincode;

	private String addressErrorMsg;

}
