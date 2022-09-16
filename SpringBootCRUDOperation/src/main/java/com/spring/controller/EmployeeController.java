package com.spring.controller;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.model.Employee;
import com.spring.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	
	@Autowired
	EmployeeService employeeService;

	@PostMapping("/save")
	public Employee saveEmployee(@RequestBody Employee emp) {

		Employee savedEmployee = employeeService.saveEmployee(emp);
		return savedEmployee;

	}

	@GetMapping("/getemployees")
	public List<Employee> getAllEmployee() {

		List<Employee> allEmployee = employeeService.getAllEmployee();
		return allEmployee;

	}

	@GetMapping("/getbyid/{id}")
	public Optional<Employee> getEmployeeById(@PathVariable Integer id) {

		Optional<Employee> employeeById = employeeService.getEmployeeById(id);
		return employeeById;

	}

	@DeleteMapping("/deletebyid/{id}")
	public void deleteById(@PathVariable int id) {

		employeeService.deleteById(id);

	}

	@PutMapping("/updatename/{id}/{name}")
	public ResponseEntity<Integer> updateEmployeeName(@PathVariable("id") int id, @PathVariable("name") String name) {

		int i = employeeService.updateEmployeeName(name, id);
        return ResponseEntity.ok().body(i);
	}
	
	@PutMapping("/updatecity/{id}/{city}")
	public ResponseEntity<Integer> updateEmployeeCity(@PathVariable("city")String city, @PathVariable("id")int id) {
		
		int i = employeeService.updateEmployeeCity(city, id);
		return ResponseEntity.ok().body(i);
	
	}


	@GetMapping("/getbycity/{city}")
	public List<Employee> getEmployeeByCity(@PathVariable String city) {

		List<Employee> listByCity = employeeService.getListByCity(city);
		return listByCity;

	}

	@GetMapping("/getbyname/{name}")
	public List<Employee> getEmployeeByName(@PathVariable String name) {

		List<Employee> listByName = employeeService.getListByName(name);
		return listByName;

	}

}
