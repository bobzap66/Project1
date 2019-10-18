package dev.greene.entities;

public class ManagerTotals {
	
	private String name;
	private int id;
	private double total;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public ManagerTotals() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return this.name + ": " + this.total;
	}
	
	

}
