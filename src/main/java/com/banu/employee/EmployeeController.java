package com.banu.employee;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banu.employee.rest.RestAddress;
import com.banu.employee.rest.RestEmployee;
import com.banu.employee.rest.RestInsurance;
import com.banu.employee.service.EmployeeService;

@RestController
@RequestMapping(value = "/v1/employee")
public class EmployeeController {

	@Inject
	EmployeeService employeeService;

	@GetMapping(value = "/status")
	private String getStatus() {
		return "Emp controller is up and running";
	}

	@GetMapping(value = "/get/insurance/{id}")
	public RestInsurance getInsurance(@PathVariable(value = "id") Long id) {
		return employeeService.getInsurnaceByEmpId(id);
	}

	@GetMapping(value = "/get/address/{id}")
	public List<RestAddress> getAddresses(@PathVariable(value = "id") Long id) {
		return employeeService.getAddressesByEmpId(id);
	}

	@PostMapping(value = "/post")
	private ResponseEntity<RestEmployee> post(@RequestBody RestEmployee restEmployee) {

		System.out.println("incoming request:-" + restEmployee);

		return ResponseEntity.ok().body(employeeService.post(restEmployee));
	}

}
