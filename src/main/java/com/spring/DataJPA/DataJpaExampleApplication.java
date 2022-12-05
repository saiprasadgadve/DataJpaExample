package com.spring.DataJPA;

import java.util.Iterator;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.spring.DataJPA.dao.EmployeeDAO;
import com.spring.DataJPA.entity.Employee;



@SpringBootApplication
public class DataJpaExampleApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context=SpringApplication.run(DataJpaExampleApplication.class, args);
		EmployeeDAO dao = (EmployeeDAO)context.getBean("employeeDAO");
		dao.save(new Employee(1,"Sunil","Kambil",20000));
		dao.save(new Employee(2,"Ajay","Gadve",25000));
		dao.save(new Employee(3,"Anil","Gadve",20000));
		dao.save(new Employee(4,"Anil","Natapa",25000));

		Iterable<Employee> employees = dao.findAll();
		System.out.println("EMployees:"+employees);

		Employee empl = dao.findById(5).orElse(new Employee());
		System.out.println("filter:"+empl);
		
		List<String> li =dao.getAllFirstName();
		System.out.println("DataJpaExampleApplication.main()"+li);
		
		List<Employee> emp=dao.getAllDetailsEmployee();
		for(Employee emp1:emp)
		{
			System.out.println("EMP1"+emp1);
		}

		/*
		 * List<Employee> emp1 = dao.findByLastName("Gadve");
		 * System.out.println("byLastName"+emp1);
		 * 
		 * List<Employee> emp2 = dao.getAllDetailsEmployee(); Iterator<Employee> it1 =
		 * emp2.iterator(); while(it1.hasNext()) { Employee emp =(Employee) it1.next();
		 * System.out.println(emp);
		 * 
		 * }
		 * 
		 * List<Employee> emp3 = dao.getDetailsCount(); Iterator<Employee> it2 =
		 * emp3.iterator(); while(it2.hasNext()) { System.out.println(it2.next()); }
		 * 
		 * Employee emp4 = dao.findById(3).orElse(new Employee());
		 * emp4.setSalary(18000); dao.save(emp4);
		 * 
		 * //dao.deleteById(3);
		 * 
		 * //dao.delete(emp4);
		 */	

		/* List<Employee> employess1 = dao.getAllDetailsEmployee();
		Iterator<Employee> it = employess1.iterator();
		while(it.hasNext())
		{
			Employee emp = it.next();
			System.out.println(emp);
		}*/
		
		/*List<String> employess1 = dao.getAllFirstName();
		Iterator<String> it = employess1.iterator();
		while(it.hasNext())
		{
			String firstName = it.next();
			System.out.println(firstName);
		}*/
		
		/*List<Employee> employess1 = dao.getOrderedEmployees();
		Iterator<Employee> it = employess1.iterator();
		while(it.hasNext())
		{
			Employee salaryDesc = it.next();
			System.out.println(salaryDesc);
		}*/
		List<Object[]> objects = dao.getGroupedEmployees();
		Iterator<Object[]> it = objects.iterator();
		while(it.hasNext())
		{
			Object[] objectArray = it.next();
			System.out.println(objectArray[0]+"   "+objectArray[1]);
		}
		
	}

}
