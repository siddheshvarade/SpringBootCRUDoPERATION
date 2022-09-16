package com.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.EmployeeRepository;
import com.spring.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Employee saveEmployee(Employee emp) {

		Employee employee = employeeRepository.save(emp);
		return employee;
	}

	@Override
	public List<Employee> getAllEmployee() {

		List<Employee> listEmployee = employeeRepository.findAll();
		return listEmployee;
	}

	@Override
	public Optional<Employee> getEmployeeById(Integer id) {

		Optional<Employee> emp = employeeRepository.findById(id);
		return emp;

	}

	@Override
	public void deleteById(int id) {

		employeeRepository.deleteById(id);

	}

	@Override
	public int updateEmployeeName(String name,int id) {
		int i = employeeRepository.updateEmployee( name, id);
		return i;
	}

	@Override
	public int updateEmployeeCity(String city, int id) {
		int i = employeeRepository.updateEmployeeCity(city, id);
		return i;
	}

	
	@Override
	public List<Employee> getListByCity(String city) {

		List<Employee> emp = employeeRepository.findByCity(city);

		return emp;
	}

	@Override
	public List<Employee> getListByName(String name) {

		List<Employee> emp = employeeRepository.findByName(name);

		return emp;
	}

	
}
