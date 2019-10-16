package dev.greene.daotests;


import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import dev.greene.daos.EmployeeDAO;
import dev.greene.daos.EmployeeDAOjdbc;
import dev.greene.entities.Employee;

public class EmployeeDAOTest {
	public static EmployeeDAO edao = EmployeeDAOjdbc.getEmployeeDAOjdbc();
	
	
	@Test
	public void getEmployeeByID() {
		Employee employee = edao.getEmployeeByID(1);
		String fname = "Samuel";
		Assert.assertEquals(fname, employee.getfName());
	}
	
	@Test
	public void getEmployeeByUsername() {
		Employee employee = edao.getEmployeeByUsername("watchman");
		String fname = "Samuel";
		Assert.assertEquals(fname, employee.getfName());
	}
	
	@Test
	public void getAllEmployees() {
		List<Employee> employees = edao.getAllEmployees();
		int actual = employees.size();
		Assert.assertEquals(8, actual);
	}
	

}
