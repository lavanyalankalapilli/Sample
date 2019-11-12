package com.company.portal.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.company.portal.model.Employee;
import com.company.portal.service.EmployeeService;

@RestController
@RequestMapping("/zemoso/api/v1")
public class EmployeeController {

	@Autowired
	@Qualifier("engineerService")
	EmployeeService engService;

	@Autowired
	@Qualifier("managerService")
	EmployeeService manService;

	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		List<Employee> res = new ArrayList<Employee>();
		res.addAll(engService.getEmployees());
		res.addAll(manService.getEmployees());
		return res;
	}

	@RequestMapping(value = "/employees/{id}", method = RequestMethod.GET)
	public Employee getEmployee(@PathVariable int id) throws Exception {
		Optional<Employee> emp = engService.getEmployeeById(id);
		if (!emp.isPresent()) {
			emp = manService.getEmployeeById(id);
			if (!emp.isPresent()) {
				throw new Exception("No employee with ID " + id + " found.");
			}
		}
		return emp.get();
	}

	@RequestMapping(value = "/employees/engineers", method = RequestMethod.POST)
	public String createEngineer(@RequestBody Employee e) {
		e.setDesignation("engineer");
		return engService.addNewEmployee(e);
	}

	@RequestMapping(value = "/employees/managers", method = RequestMethod.POST)
	public String createManager(@RequestBody Employee e) {
		e.setDesignation("engineer");
		return manService.addNewEmployee(e);
	}

	@RequestMapping(value = "/employees/engineers/{id}", method = RequestMethod.PUT)
	public Employee updateEngineer(@RequestBody Employee e, @PathVariable int id) throws Exception {
		System.out.println("controller engineer in update method");
		Optional<Employee> emp = engService.getEmployeeById(id);
		if (!emp.isPresent()) {
			throw new Exception("Employee with ID " + id + " not found");
		}
		engService.updateEmployee(e);
		return e;
	}

	@RequestMapping(value = "/employees/managers/{id}", method = RequestMethod.PUT)
	public Employee updateManager(@RequestBody Employee e, @PathVariable int id) throws Exception {
		System.out.println(" contr mang in update method");
		Optional<Employee> emp = manService.getEmployeeById(id);
		if (!emp.isPresent()) {
			throw new Exception("Employee with ID " + id + " not found");
		}
		manService.updateEmployee(e);
		return e;
	}

	@DeleteMapping("/employees/{id}")
	public void delEmployee(@PathVariable int id) {
		System.out.println("in delEmployee");
		Optional<Employee> emp = engService.getEmployeeById(id);
		if (emp.isPresent()) {
			engService.deleteEmployeeById(id);
		} else {
			emp = manService.getEmployeeById(id);
			if (emp.isPresent()) {
				manService.deleteEmployeeById(id);
			}
		}
	}

}
