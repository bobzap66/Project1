package dev.greene.services;

import java.util.ArrayList;
import java.util.List;

import dev.greene.daos.EmployeeDAO;
import dev.greene.daos.EmployeeDAOjdbc;
import dev.greene.daos.ReimbursementDAO;
import dev.greene.daos.ReimbursementDAOjdbc;
import dev.greene.entities.Reimbursement;

public class ManagerServicesImpl implements ManagerServices {
	
	private EmployeeDAO eDAO = EmployeeDAOjdbc.getEmployeeDAOjdbc();
	private ReimbursementDAO rDAO = ReimbursementDAOjdbc.getReimbursementjdbc();
	
	private static ManagerServices es;
	
	public static ManagerServices getManagerServices() {
		if(es == null) {
			es = new ManagerServicesImpl();
		}
		return es;
	}
	private ManagerServicesImpl() {
		
	}
	

	@Override
	public List<Reimbursement> getAllReimbursements() {
		List<Reimbursement> reimbursements = rDAO.getAllReimbursements();
		return reimbursements;
	}

	@Override
	public List<Reimbursement> getAllPendingReimbursements() {
		List<Reimbursement> reimbursements = rDAO.getAllReimbursements();

		List<Reimbursement> pending = new ArrayList();
		for(Reimbursement reimbursement : reimbursements) {

			if(reimbursement.getStatus() == 0) {
				pending.add(reimbursement);
			}
		}
		return pending;
	}

	@Override
	public Reimbursement updateReimbursement(Reimbursement reimbursement) {
		Reimbursement actual = rDAO.getReimbursementByID(reimbursement.getReimbursementID());
		actual.setStatus(reimbursement.getStatus());
		actual.setManagerID(reimbursement.getManagerID());
		actual.setResponse(reimbursement.getResponse());
		rDAO.updateReimbursementStatus(actual);
		return actual;
	}

}
