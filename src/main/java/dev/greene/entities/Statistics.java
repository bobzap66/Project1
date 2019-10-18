package dev.greene.entities;

import java.util.List;
import java.util.Map;

public class Statistics {
	/*
	 * How much each manager has approved, who submits the most requests, size of
	 * the average reimbursement request, amount of approved and denied money and
	 * total requests etc.
	 */

		private double avgSize;
		private int approved;
		private double amountApproved;
		private int denied;
		private double amountDenied;
		private int total;
		private String most;
		private double totalAmount;
		public double getTotalAmount() {
			return totalAmount;
		}

		public void setTotalAmount(double totalAmount) {
			this.totalAmount = totalAmount;
		}

		private List<ManagerTotals> totals;
		
		public Statistics() {
			super();
			// TODO Auto-generated constructor stub
		}

		public double getAmountApproved() {
			return amountApproved;
		}

		public void setAmountApproved(double amountApproved) {
			this.amountApproved = amountApproved;
		}

		public double getAmountDenied() {
			return amountDenied;
		}

		public void setAmountDenied(double amountDenied) {
			this.amountDenied = amountDenied;
		}

		public double getAvgSize() {
			return avgSize;
		}

		public void setAvgSize(double avgSize) {
			this.avgSize = avgSize;
		}

		public int getApproved() {
			return approved;
		}

		public void setApproved(int approved) {
			this.approved = approved;
		}

		public int getDenied() {
			return denied;
		}

		public void setDenied(int denied) {
			this.denied = denied;
		}

		public int getTotal() {
			return total;
		}

		public void setTotal(int total) {
			this.total = total;
		}

		public String getMost() {
			return most;
		}

		public void setMost(String most) {
			this.most = most;
		}

		public List<ManagerTotals> getTotals() {
			return totals;
		}

		public void setTotals(List<ManagerTotals> totals) {
			this.totals = totals;
		}

		@Override
		public String toString() {
			return "Statistics [avgSize=" + avgSize + ", approved=" + approved + ", amountApproved=" + amountApproved
					+ ", denied=" + denied + ", amountDenied=" + amountDenied + ", total=" + total + ", most=" + most
					+ ", totalAmount=" + totalAmount + ", totals=" + totals + "]";
		}
		
		
}
