package dev.greene.daotests;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import dev.greene.daos.ReimbursementDAO;
import dev.greene.daos.ReimbursementDAOjdbc;
import dev.greene.entities.Reimbursement;

public class ReimbursementDAOTest {
	public static ReimbursementDAO rdao = ReimbursementDAOjdbc.getReimbursementjdbc();

	@Test
	public void createReimbursement() {
		Reimbursement reimbursement = new Reimbursement();
		reimbursement.setAmount(10);
		reimbursement.setEmployeeID(2);
		reimbursement.setStatus(0);
		reimbursement.setTitle("Tea Money");
		reimbursement.setComment("Needed more tea. Nobby robbed us again.");
		boolean actual = rdao.createReimbursement(reimbursement);
		Assert.assertEquals(true, actual);
	
	}
	
	@Test 
	public void getReimbursementByID() {
		int expected = 2000;
		Reimbursement reimbursement = rdao.getReimbursementByID(2000);
		Assert.assertEquals(expected, reimbursement.getReimbursementID());
		
	}
	
	@Test
	public void getAllReimbursements() {
		List<Reimbursement> reimbursements = rdao.getAllReimbursements();
		boolean actual = reimbursements.size()>0;
		Assert.assertEquals(true, actual);
	}
	
	@Test
	public void getReimbursementsByEmployeeID() {
		List<Reimbursement> reimbursements = rdao.getReimbursementsByEmployeeID(2);
		boolean actual = reimbursements.size()>0;
		Assert.assertEquals(true, actual);
	}
	
	@Test
	public void updateReimbursementStatus() {
		Reimbursement reimbursement = rdao.getReimbursementByID(2000);
		reimbursement.setManagerID(1);
		reimbursement.setResponse("Stop stealing");
		reimbursement.setStatus(-1);
		rdao.updateReimbursementStatus(reimbursement);
		reimbursement = rdao.getReimbursementByID(2000);
		boolean actual = reimbursement.getStatus() == -1;
		Assert.assertEquals(true, actual);
	}
	
	@Test
	public void getPendingReimbursements() {
		List<Reimbursement> reimbursements = rdao.getAllPendingReimbursements();
		boolean actual = reimbursements.size()>0;
		Assert.assertEquals(true, actual);
	}
}
