package dev.greene.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import dev.greene.entities.Employee;
import dev.greene.entities.Reimbursement;
import dev.greene.utils.ConnectionUtil;

public class ReimbursementDAOjdbc implements ReimbursementDAO{
	
	private static ReimbursementDAO rDAO;
	
	public static ReimbursementDAO getReimbursementjdbc() {
		if (rDAO == null) {
			rDAO = new ReimbursementDAOjdbc();
		}
		return rDAO;
		}
	
	private ReimbursementDAOjdbc() {
	}
	
	ConnectionUtil connection = new ConnectionUtil();

	@Override
	public boolean createReimbursement(Reimbursement reimbursement) {
		try (Connection conn = connection.createConnection()) { 
			String sql = "INSERT INTO AnkhMorporkWatch.reimbursement values(?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, 0);
			ps.setInt(2, reimbursement.getEmployeeID());
			ps.setDouble(3, reimbursement.getAmount());
			ps.setInt(4, reimbursement.getStatus());
			ps.setString(5, reimbursement.getTitle());
			ps.setString(6, reimbursement.getComment());
			ps.setString(7, reimbursement.getResponse());
			ps.setInt(8,  reimbursement.getManagerID());
			ps.setLong(9,  reimbursement.getTime());
			ps.execute();
			
			return true;
			
			
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public Reimbursement getReimbursementByID(int id) {
		try (Connection conn = connection.createConnection()) {
			String sql = "SELECT * FROM AnkhMorporkWatch.reimbursement WHERE reimbursementID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,  id);
			
			ResultSet rs = ps.executeQuery();
			
			rs.next();
			
			Reimbursement reimbursement = new Reimbursement();
			reimbursement.setReimbursementID(rs.getInt("reimbursementID"));
			reimbursement.setEmployeeID(rs.getInt("employeeID"));
			reimbursement.setAmount(rs.getDouble("amount"));
			reimbursement.setStatus(rs.getInt("status"));
			reimbursement.setTitle(rs.getString("title"));
			reimbursement.setComment(rs.getString("comment"));
			reimbursement.setResponse(rs.getString("response"));
			reimbursement.setManagerID(rs.getInt("managerID"));
			reimbursement.setTime(rs.getLong("time"));
			return reimbursement;
		
		} catch(SQLException e) {
			//e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Reimbursement> getReimbursementsByEmployeeID(int employeeID) {
		try(Connection conn = connection.createConnection()) {
			String sql = "SELECT * from AnkhMorporkWatch.reimbursement WHERE employeeID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, employeeID);
		
			List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
		
			ResultSet rs = ps.executeQuery();
		
			while(rs.next()) {
			
				Reimbursement reimbursement = new Reimbursement();
				reimbursement.setReimbursementID(rs.getInt("reimbursementID"));
				reimbursement.setEmployeeID(rs.getInt("employeeID"));
				reimbursement.setAmount(rs.getDouble("amount"));
				reimbursement.setStatus(rs.getInt("status"));
				reimbursement.setTitle(rs.getString("title"));
				reimbursement.setComment(rs.getString("comment"));
				reimbursement.setResponse(rs.getString("response"));
				reimbursement.setManagerID(rs.getInt("managerID"));
				reimbursement.setTime(rs.getLong("time"));

				reimbursements.add(reimbursement);
			
			}
			return reimbursements;	
		
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}

	}
	

	@Override
	public List<Reimbursement> getAllReimbursements() {
		try(Connection conn = connection.createConnection()) {
			String sql = "SELECT * from AnkhMorporkWatch.reimbursement";
			PreparedStatement ps = conn.prepareStatement(sql);
		
			List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
		
			ResultSet rs = ps.executeQuery();
		
			while(rs.next()) {
			
				Reimbursement reimbursement = new Reimbursement();
				reimbursement.setReimbursementID(rs.getInt("reimbursementID"));
				reimbursement.setEmployeeID(rs.getInt("employeeID"));
				reimbursement.setAmount(rs.getDouble("amount"));
				reimbursement.setStatus(rs.getInt("status"));
				reimbursement.setTitle(rs.getString("title"));
				reimbursement.setComment(rs.getString("comment"));
				reimbursement.setResponse(rs.getString("response"));
				reimbursement.setManagerID(rs.getInt("managerID"));
				reimbursement.setTime(rs.getLong("time"));

				reimbursements.add(reimbursement);
			
			}
			return reimbursements;	
		
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public boolean updateReimbursementStatus(Reimbursement reimbursement) {
		try (Connection conn = connection.createConnection()) { 
			String sql = "UPDATE AnkhMorporkWatch.reimbursement SET status = ?, response = ?, managerID = ? WHERE reimbursementID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, reimbursement.getStatus());
			ps.setString(2, reimbursement.getResponse());
			ps.setInt(3, reimbursement.getManagerID());
			ps.setInt(4, reimbursement.getReimbursementID());
			ps.execute();
			
			return true;
				
				
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Reimbursement> getAllPendingReimbursements() {
		try(Connection conn = connection.createConnection()) {
			String sql = "SELECT * from AnkhMorporkWatch.reimbursement WHERE status = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, 0);
		
			List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
		
			ResultSet rs = ps.executeQuery();
		
			while(rs.next()) {
			
				Reimbursement reimbursement = new Reimbursement();
				reimbursement.setReimbursementID(rs.getInt("reimbursementID"));
				reimbursement.setEmployeeID(rs.getInt("employeeID"));
				reimbursement.setAmount(rs.getDouble("amount"));
				reimbursement.setStatus(rs.getInt("status"));
				reimbursement.setTitle(rs.getString("title"));
				reimbursement.setComment(rs.getString("comment"));
				reimbursement.setResponse(rs.getString("response"));
				reimbursement.setManagerID(rs.getInt("managerID"));
				reimbursement.setTime(rs.getLong("time"));

				reimbursements.add(reimbursement);
			
			}
			return reimbursements;	
		
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Reimbursement> getReimbursementsByManagerID(int managerID) {
		try(Connection conn = connection.createConnection()) {
			String sql = "SELECT * from AnkhMorporkWatch.reimbursement WHERE managerID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, managerID);
		
			List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
		
			ResultSet rs = ps.executeQuery();
		
			while(rs.next()) {
			
				Reimbursement reimbursement = new Reimbursement();
				reimbursement.setReimbursementID(rs.getInt("reimbursementID"));
				reimbursement.setEmployeeID(rs.getInt("employeeID"));
				reimbursement.setAmount(rs.getDouble("amount"));
				reimbursement.setStatus(rs.getInt("status"));
				reimbursement.setTitle(rs.getString("title"));
				reimbursement.setComment(rs.getString("comment"));
				reimbursement.setResponse(rs.getString("response"));
				reimbursement.setManagerID(rs.getInt("managerID"));
				reimbursement.setTime(rs.getLong("time"));

				reimbursements.add(reimbursement);
			
			}
			return reimbursements;	
		
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}

	}
}
