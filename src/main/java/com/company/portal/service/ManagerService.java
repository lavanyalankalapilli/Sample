package com.company.portal.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.company.portal.model.Employee;

@Service
@Qualifier("managerService")
public class ManagerService implements EmployeeService {

	private List<Employee> managers;

	public ManagerService() {
		managers = new ArrayList<Employee>();
	}

	@Override
	public List<Employee> getEmployees() {
		return managers;
	}

	@Override
	public Optional<Employee> getEmployeeById(int empid) {
		Optional<Employee> emp = managers.stream().filter(e -> (e.getId() == empid)).findFirst();
		return emp;
	}

	@Override
	public String addNewEmployee(Employee emp) {
		emp.setDesignation("manager");
		Optional<Employee> employee = managers.stream().filter(e -> (e.getId() == emp.getId())).findFirst();
		if (employee.isPresent()) {
			return "Employee with ID " + emp.getId() + " already exists";
		} else {
			managers.add(emp);
		}
		return "Successfully inserted";
	}

	@Override
	public Employee updateEmployee(Employee emp) {
		int empId = emp.getId();
		Employee employee = managers.stream().filter(e -> (e.getId() == empId)).findFirst().get();
		employee.setDepartment(emp.getDepartment());
		employee.setName(emp.getName());
		employee.setSalary(emp.getSalary());
		employee.setDesignation("manager");
		return employee;
	}

	@Override
	public void deleteEmployeeById(int empid) {
		managers.removeIf(e -> e.getId() == empid);
	}

}
