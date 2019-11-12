package com.company.portal.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.company.portal.model.Employee;

@Service
@Qualifier("engineerService")
public class EngineerService implements EmployeeService {

	private List<Employee> engineers;

	public EngineerService() {
		engineers = new ArrayList<Employee>();
	}

	@Override
	public List<Employee> getEmployees() {
		return engineers;
	}

	@Override
	public Optional<Employee> getEmployeeById(int empid) {
		Optional<Employee> emp = engineers.stream().filter(e -> (e.getId() == empid)).findFirst();
		return emp;
	}

	@Override
	public String addNewEmployee(Employee emp) {
		emp.setDesignation("engineer");
		Optional<Employee> employee = engineers.stream().filter(e -> (e.getId() == emp.getId())).findFirst();
		if (employee.isPresent()) {
			return "Employee with ID " + emp.getId() + " already exists";
		} else {
			engineers.add(emp);
		}
		return "Successfully inserted";
	}

	@Override
	public Employee updateEmployee(Employee emp) {
		System.out.println("in engineer update");
		int empId = emp.getId();
		Employee employee = engineers.stream().filter(e -> (e.getId() == empId)).findFirst().get();
		employee.setDepartment(emp.getDepartment());
		employee.setName(emp.getName());
		employee.setSalary(emp.getSalary());
		employee.setDesignation("engineer");
		return employee;
	}

	@Override
	public void deleteEmployeeById(int empid) {
		engineers.removeIf(e -> e.getId() == empid);
	}

}
