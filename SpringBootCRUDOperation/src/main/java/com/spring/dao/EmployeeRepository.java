package com.spring.dao;
//JpaRepository
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.model.Employee;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Serializable> {

	@Query(value="select * from emp where city=?", nativeQuery=true)
	public List<Employee> findByCity(String city);
	
	@Query(value="select * from emp where name=?", nativeQuery=true)
	public List<Employee> findByName(String name);
	
	@Transactional
	@Modifying
	@Query(value="update emp set name=? where id=?", nativeQuery=true)
	public int updateEmployee(String name, int id);
	
	@Transactional
	@Modifying
	@Query(value="update emp set city=? where id=?", nativeQuery=true)
	public int updateEmployeeCity(String city, int id);

}
