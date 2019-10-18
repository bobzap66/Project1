package dev.greene.daos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


import dev.greene.entities.Employee;
import dev.greene.utils.ConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDAOjdbc implements EmployeeDAO{
	
	private static EmployeeDAO eDAO;
	
	public static EmployeeDAO getEmployeeDAOjdbc() {
		if(eDAO == null) {
			eDAO = new EmployeeDAOjdbc();
		}
		return eDAO;
	}
	private EmployeeDAOjdbc() {
		
	}
	
	ConnectionUtil connection = new ConnectionUtil();
	
	@Override
	public Employee getEmployeeByID(int id) {
		try (Connection conn = connection.createConnection()) {
			String sql = "SELECT * FROM AnkhMorporkWatch.employee WHERE employeeID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,  id);
			
			ResultSet rs = ps.executeQuery();
			
			rs.next();
			
			Employee employee = new Employee();
			employee.setId(rs.getInt("EmployeeID"));
			employee.setfName(rs.getString("fName"));
			employee.setlName(rs.getString("lName"));
			employee.setUsername(rs.getString("username"));
			employee.setPassword(rs.getString("password"));
			employee.setRank(rs.getString("watchRank"));
			return employee;
		
		} catch(SQLException e) {
			return null;
		}
	}
	
	@Override
	public Employee getEmployeeByUsername(String username) {
		try (Connection conn = connection.createConnection()) {
			String sql = "SELECT * FROM AnkhMorporkWatch.employee WHERE username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,  username);
			
			ResultSet rs = ps.executeQuery();
			
			rs.next();
			
			Employee employee = new Employee();
			employee.setId(rs.getInt("EmployeeID"));
			employee.setfName(rs.getString("fName"));
			employee.setlName(rs.getString("lName"));
			employee.setUsername(rs.getString("username"));
			employee.setPassword(rs.getString("password"));
			employee.setRank(rs.getString("watchRank"));
			return employee;
		
		} catch(SQLException e) {
			return null;
		}
	}

	@Override
	public List<Employee> getAllEmployees() {
		try(Connection conn = connection.createConnection()) {
			
			String sql = "SELECT * from AnkhMorporkWatch.employee";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			List<Employee> employees = new ArrayList<Employee>();
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Employee employee = new Employee();
				employee.setId(rs.getInt("employeeID"));
				employee.setfName(rs.getString("fName"));
				employee.setlName(rs.getString("lName"));
				employee.setUsername(rs.getString("username"));
				employee.setPassword(rs.getString("password"));
				employee.setRank(rs.getString("watchRank"));
				
				employees.add(employee);
				
			}
			return employees;	
			
		}catch(SQLException e) {
			return null;
		}	
	}
	@Override
	public List<Employee> getAllManagers() {
		try(Connection conn = connection.createConnection()) {
			
			String sql = "SELECT * from AnkhMorporkWatch.employee WHERE watchRank = 'Commander' or watchRank = 'Captain'";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			List<Employee> employees = new ArrayList<Employee>();
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Employee employee = new Employee();
				employee.setId(rs.getInt("employeeID"));
				employee.setfName(rs.getString("fName"));
				employee.setlName(rs.getString("lName"));
				employee.setUsername(rs.getString("username"));
				employee.setPassword(rs.getString("password"));
				employee.setRank(rs.getString("watchRank"));
				
				employees.add(employee);
				
				}
				return employees;	
			
			}catch(SQLException e) {
				return null;
			}

	}
}
