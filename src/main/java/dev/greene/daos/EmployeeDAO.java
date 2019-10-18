package dev.greene.daos;

import java.util.List;
import java.util.Set;

import dev.greene.entities.Employee;

public interface EmployeeDAO {
	
	Employee getEmployeeByID(int id);
	Employee getEmployeeByUsername(String username);
	List<Employee> getAllEmployees();
	List<Employee> getAllManagers();

}
