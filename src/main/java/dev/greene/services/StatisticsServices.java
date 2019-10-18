package dev.greene.services;

import java.util.List;
import java.util.Map;

import dev.greene.entities.ManagerTotals;
import dev.greene.entities.Statistics;

public interface StatisticsServices {
//	How much each manager has approved, who submits the most requests,
//	size of the average reimbursement request,
//	amount of approved and denied money and total requests etc.
	
	List<ManagerTotals> getTotalPerManager();
	double getAverageSize();
	int getApproved();
	double getAmountApproved();
	int getDenied();
	double getAmountDenied();
	double getTotalAmount();
	int getTotal();
	String getMost();
	Statistics populateAll();

}
