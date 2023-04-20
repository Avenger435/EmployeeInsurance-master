package com.banu.employee.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.banu.employee.rest.RestAddress;
import com.banu.employee.rest.RestEmployee;
import com.banu.employee.rest.RestInsurance;

@Service
public interface EmployeeService {

	public RestEmployee post(RestEmployee restEmployee);

	public RestInsurance getInsurnaceByEmpId(Long id);

	public List<RestAddress> getAddressesByEmpId(Long id);

}
