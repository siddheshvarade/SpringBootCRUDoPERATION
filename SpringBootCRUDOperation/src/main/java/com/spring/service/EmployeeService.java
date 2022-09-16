package com.spring.service;

import java.util.List;
import java.util.Optional;

import com.spring.model.Employee;

public interface EmployeeService {
	
	public Employee saveEmployee(Employee emp);
	
	public List<Employee> getAllEmployee();
	
	public Optional<Employee> getEmployeeById(Integer id);
	
	public void deleteById(int id);
	
	public int updateEmployeeName(String name, int id);
	
	public int updateEmployeeCity(String city, int id);

	
	public List<Employee> getListByCity(String city);

	public List<Employee> getListByName(String name);
	
	
}
