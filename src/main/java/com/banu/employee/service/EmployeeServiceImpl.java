package com.banu.employee.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.banu.employee.entity.Address;
import com.banu.employee.entity.Employee;
import com.banu.employee.repo.EmployeeRepo;
import com.banu.employee.rest.RestAddress;
import com.banu.employee.rest.RestEmployee;
import com.banu.employee.rest.RestInsurance;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Inject
	EmployeeRepo employeeRepo;

	@Inject
	ModelMapper modelMapper;

	@Override
	public RestEmployee post(RestEmployee restEmployee) {

		Employee employeeEntity = modelMapper.map(restEmployee, Employee.class);
		Employee newEmpEntity = new Employee(employeeEntity.getName());

		List<Address> addressList = new ArrayList<Address>();

		// setting the parents to the childs here
		employeeEntity.getAddresses().stream().forEach(address -> {
			addressList.add(new Address(address.getAddress_name(), newEmpEntity));
		});

		newEmpEntity.setDepartment(employeeEntity.getDepartment());
		newEmpEntity.setAddresses(addressList);
		newEmpEntity.setInsurance(employeeEntity.getInsurance());

		try {
			restEmployee = modelMapper.map(employeeRepo.save(newEmpEntity), RestEmployee.class);
			restEmployee.setEmployeeResponseMsg("success");
			return restEmployee;
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
			restEmployee.setEmployeeResponseMsg("failure");
			return restEmployee;
		}

	}

	@Override
	public List<RestAddress> getAddressesByEmpId(Long id) {

		List<RestAddress> addresses = new ArrayList<RestAddress>();
		Optional<Employee> employeeEntity;
		try {
			employeeEntity = employeeRepo.findById(id);
			employeeEntity.get().getAddresses().forEach(address -> {
				addresses.add(modelMapper.map(address, RestAddress.class));
			});
		} catch (Exception e) {
			RestAddress restAddress = new RestAddress();
			restAddress.setAddressErrorMsg("No Addresses found for the employee with id:- " + id);
			addresses.add(restAddress);
		}
		return addresses;
	}

	@Override
	public RestInsurance getInsurnaceByEmpId(Long id) {

		RestInsurance restInsurance = new RestInsurance();
		Optional<Employee> employeeEntity;
		try {
			employeeEntity = employeeRepo.findById(id);
			return modelMapper.map(employeeEntity.get().getInsurance(), RestInsurance.class);

		} catch (Exception e) {
			restInsurance.setInsuranceErrorMsg("No Insurance plan found for the employee with id:- " + id);
			return restInsurance;
		}

	}

}
