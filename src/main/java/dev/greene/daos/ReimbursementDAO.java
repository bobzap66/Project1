package dev.greene.daos;

import java.util.List;
import java.util.Set;

import dev.greene.entities.Reimbursement;

public interface ReimbursementDAO {
	
	//Create
	boolean createReimbursement(Reimbursement reimbursement);
	
	//Read
	Reimbursement getReimbursementByID(int id);
	List <Reimbursement> getReimbursementsByEmployeeID(int employeeID);
	List <Reimbursement> getAllReimbursements();
	List<Reimbursement> getAllPendingReimbursements();
	
	//Update
	boolean updateReimbursementStatus(Reimbursement reimbursement);
	
	//Delete

}
