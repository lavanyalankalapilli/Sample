package com.company.portal.service;

import java.util.List;
import java.util.Optional;

import com.company.portal.model.Employee;

public interface EmployeeService {
	public List<Employee> getEmployees();

	public Optional<Employee> getEmployeeById(int empid);

	public String addNewEmployee(Employee emp);

	public Employee updateEmployee(Employee emp);

	public void deleteEmployeeById(int empid);

}
