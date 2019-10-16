package dev.greene.services;

import java.util.List;

import dev.greene.daos.EmployeeDAO;
import dev.greene.daos.EmployeeDAOjdbc;
import dev.greene.daos.ReimbursementDAO;
import dev.greene.daos.ReimbursementDAOjdbc;
import dev.greene.entities.Employee;
import dev.greene.entities.Reimbursement;

public class EmployeeServicesImpl implements EmployeeServices {
	
	
	private EmployeeDAO eDAO = EmployeeDAOjdbc.getEmployeeDAOjdbc();
	private ReimbursementDAO rDAO = ReimbursementDAOjdbc.getReimbursementjdbc();
	
	private static EmployeeServices es;
	
	public static EmployeeServices getEmployeeServices() {
		if(es == null) {
			es = new EmployeeServicesImpl();
		}
		return es;
	}
	private EmployeeServicesImpl() {
		
	}
	
	//if employee.password = -1, invalid password
	//if employee.password = -2, invalid username
	@Override
	public Employee login(Employee employee) {
		Employee actual = eDAO.getEmployeeByUsername(employee.getUsername());
		if(actual != null) {
			if(actual.getPassword().equals(employee.getPassword())) {
				return actual;
				
			} else {
				employee.setPassword("-1");
				return employee;
			}
		} else {
			employee.setPassword("-2");
			return employee;
		}
	}

	@Override
	public boolean requestReimbursement(Reimbursement reimbursement) {
		rDAO.createReimbursement(reimbursement);
		
		return true;
	}

	@Override
	public List<Reimbursement> getReimbursements(Employee employee) {
		List<Reimbursement> reimbursements = rDAO.getReimbursementsByEmployeeID(employee.getId());
		return reimbursements;
	}





}
