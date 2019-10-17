package dev.greene.services;

import java.util.List;

import dev.greene.entities.Reimbursement;

public interface ManagerServices {
	List<Reimbursement> getAllReimbursements();
	List<Reimbursement> getAllPendingReimbursements();
	Reimbursement updateReimbursement(Reimbursement reimbursement);
	
	

}
