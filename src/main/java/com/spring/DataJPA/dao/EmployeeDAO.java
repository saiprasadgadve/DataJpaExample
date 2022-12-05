package com.spring.DataJPA.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.spring.DataJPA.entity.Employee;



public interface EmployeeDAO extends CrudRepository<Employee, Integer> {
	public List<Employee> findByLastName(String lastName);
	
	@Query("FROM Employee")
	public List<Employee> getAllDetailsEmployee();
	
	@Query("SELECT COUNT(DISTINCT(E.firstName)) FROM Employee E")
	public List getDetailsCount();
	
	@Query("SELECT E.firstName FROM Employee E")
	public List<String> getAllFirstName();

	//@Query("FROM Employee E WHERE E.id>1 ORDER BY E.salary DESC")
	@Query("FROM Employee E WHERE E.id>1 ORDER BY E.salary ASC")
	public List<Employee> getOrderedEmployees();
	
	//@Query("SELECT SUM(E.salary),E.firstName FROM Employee E GROUP BY E.firstName")
	//@Query("SELECT AVG(E.salary),E.firstName FROM Employee E GROUP BY E.firstName")
	//@Query("SELECT MAX(E.salary),E.firstName FROM Employee E GROUP BY E.firstName")
	//@Query("SELECT MIN(E.salary),E.firstName FROM Employee E GROUP BY E.firstName")
	@Query("SELECT COUNT(E.salary),E.firstName FROM Employee E GROUP BY E.firstName")
	public List<Object[]> getGroupedEmployees();
	
	
	
}
