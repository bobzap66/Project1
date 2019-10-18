package dev.greene.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dev.greene.daos.EmployeeDAO;
import dev.greene.daos.EmployeeDAOjdbc;
import dev.greene.daos.ReimbursementDAO;
import dev.greene.daos.ReimbursementDAOjdbc;
import dev.greene.entities.Employee;
import dev.greene.entities.ManagerTotals;
import dev.greene.entities.Reimbursement;
import dev.greene.entities.Statistics;

public class StatisticsServicesImpl implements StatisticsServices {
	
	private EmployeeDAO eDAO = EmployeeDAOjdbc.getEmployeeDAOjdbc();
	private ReimbursementDAO rDAO = ReimbursementDAOjdbc.getReimbursementjdbc();
	
	private static StatisticsServices ss;
	
	public static StatisticsServices getStatisticsServices() {
		if(ss == null) {
			ss = new StatisticsServicesImpl();
		}
		return ss;
	}
	private StatisticsServicesImpl() {
		
	}

	@Override
	public List<ManagerTotals> getTotalPerManager() {
		List<Employee> managers = eDAO.getAllManagers();
		List<ManagerTotals> totals = new ArrayList<ManagerTotals>();
		List<Reimbursement> reimbursements = null;
		for(Employee employee : managers) {
			double total = 0;
			reimbursements = rDAO.getReimbursementsByManagerID(employee.getId());
			for(Reimbursement reimbursement : reimbursements) {
				total = total + reimbursement.getAmount();
			}
			ManagerTotals manager = new ManagerTotals();
			manager.setId(employee.getId());
			manager.setName(employee.getlName() + ", " + employee.getfName());
			manager.setTotal(total);
			totals.add(manager);
		}
		return totals;
	}

	@Override
	public double getAverageSize() {
		List<Reimbursement> reimbursements = rDAO.getAllReimbursements();
		double total = 0;
		for(Reimbursement reimbursement : reimbursements) {
			total = total + reimbursement.getAmount();
		}
		
		return total / reimbursements.size();
	}

	@Override
	public int getApproved() {
		int total = 0;
		List<Reimbursement> reimbursements = rDAO.getAllReimbursements();
		for(Reimbursement reimbursement : reimbursements) {
			if(reimbursement.getStatus() == 1)
				total++;
		}
		return total;
	}

	@Override
	public int getDenied() {
		int total = 0;
		List<Reimbursement> reimbursements = rDAO.getAllReimbursements();
		for(Reimbursement reimbursement : reimbursements) {
			if(reimbursement.getStatus() == -1)
				total++;
		}
		return total;
	}

	@Override
	public double getTotalAmount() {
		double total = 0;
		List<Reimbursement> reimbursements = rDAO.getAllReimbursements();
		for(Reimbursement reimbursement : reimbursements) {
			total = total + reimbursement.getAmount();
		}
		return total;
	}

	@Override
	public String getMost() {
		List<ManagerTotals> totals = getTotalPerManager();
		String most = null;
		double total = 0;
		for (ManagerTotals entry : totals)  
            if(entry.getTotal() > total) {
            	most = entry.getName();
            }
	 
		return most;
	}
	@Override
	public double getAmountApproved() {
		double total = 0;
		List<Reimbursement> reimbursements = rDAO.getAllReimbursements();
		for(Reimbursement reimbursement : reimbursements) {
			if(reimbursement.getStatus() == 1)
				total = total + reimbursement.getAmount();
		}
		return total;
	}
	@Override
	public double getAmountDenied() {
		double total = 0;
		List<Reimbursement> reimbursements = rDAO.getAllReimbursements();
		for(Reimbursement reimbursement : reimbursements) {
			if(reimbursement.getStatus() == -1)
				total = total + reimbursement.getAmount();
		}
		return total;
	}
	@Override
	public Statistics populateAll() {
		Statistics stats = new Statistics();
		stats.setAmountApproved(getAmountApproved());
		stats.setAmountDenied(getAmountDenied());
		stats.setApproved(getApproved());
		stats.setDenied(getDenied());
		stats.setAvgSize(getAverageSize());
		stats.setMost(getMost());
		stats.setTotal(getTotal());
		stats.setTotalAmount(getTotalAmount());
		stats.setTotals(getTotalPerManager());
		
		return stats;
		
	}
	@Override
	public int getTotal() {
		int total = 0;
		List<Reimbursement> reimbursements = rDAO.getAllReimbursements();
		for(Reimbursement reimbursement : reimbursements) {
			total++;
		}
		return total;
	}

}
