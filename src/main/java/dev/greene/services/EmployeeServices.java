package dev.greene.services;

import java.util.List;

import dev.greene.entities.Employee;
import dev.greene.entities.Reimbursement;

public interface EmployeeServices {
	boolean requestReimbursement(Reimbursement reimbursement);
	List<Reimbursement> getReimbursements(Employee employee);
	Employee login(Employee employee);
	
	
	

}
