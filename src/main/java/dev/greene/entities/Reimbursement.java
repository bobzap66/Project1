package dev.greene.entities;

public class Reimbursement {
	
	int reimbursementID;
	int EmployeeID;
	double amount;
	// -1 denied, 0 submitted, 1 approved
	int status;
	String title;
	String comment;
	String response;
	long time;
	int managerID;

	public Reimbursement(int reimbursementID, int employeeID, double amount, int status, String title, String comment,
			String response, long time, int managerID) {
		super();
		this.reimbursementID = reimbursementID;
		EmployeeID = employeeID;
		this.amount = amount;
		this.status = status;
		this.title = title;
		this.comment = comment;
		this.response = response;
		this.time = time;
		this.managerID = managerID;
	}

	@Override
	public String toString() {
		return "Reimbursement [reimbursementID=" + reimbursementID + ", EmployeeID=" + EmployeeID + ", amount=" + amount
				+ ", status=" + status + ", title=" + title + ", comment=" + comment + ", response=" + response
				+ ", time=" + time + ", managerID=" + managerID + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + EmployeeID;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + managerID;
		result = prime * result + reimbursementID;
		result = prime * result + ((response == null) ? 0 : response.hashCode());
		result = prime * result + status;
		result = prime * result + (int) (time ^ (time >>> 32));
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reimbursement other = (Reimbursement) obj;
		if (EmployeeID != other.EmployeeID)
			return false;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (managerID != other.managerID)
			return false;
		if (reimbursementID != other.reimbursementID)
			return false;
		if (response == null) {
			if (other.response != null)
				return false;
		} else if (!response.equals(other.response))
			return false;
		if (status != other.status)
			return false;
		if (time != other.time)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	public int getReimbursementID() {
		return reimbursementID;
	}

	public void setReimbursementID(int reimbursementID) {
		this.reimbursementID = reimbursementID;
	}


	public int getEmployeeID() {
		return EmployeeID;
	}

	public void setEmployeeID(int employeeID) {
		EmployeeID = employeeID;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public int getManagerID() {
		return managerID;
	}

	public void setManagerID(int managerID) {
		this.managerID = managerID;
	}

	public Reimbursement() {
		super();
		this.time = System.currentTimeMillis();
	}

}
