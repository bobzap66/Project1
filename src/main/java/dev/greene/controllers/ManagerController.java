package dev.greene.controllers;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import dev.greene.entities.Employee;
import dev.greene.entities.Reimbursement;
import dev.greene.entities.Statistics;
import dev.greene.services.ManagerServices;
import dev.greene.services.ManagerServicesImpl;
import dev.greene.services.StatisticsServices;
import dev.greene.services.StatisticsServicesImpl;

public class ManagerController {
	private static ManagerServices ms = ManagerServicesImpl.getManagerServices();
	
	public static void allReimbursements(HttpServletRequest request, HttpServletResponse response) throws IOException {

		Gson gson = new Gson();
		List<Reimbursement> reimbursements = ms.getAllReimbursements();
		String json = gson.toJson(reimbursements);
		
		PrintWriter pw = response.getWriter();
		pw.append(json);
	}

	public static void pendingReimbursements(HttpServletRequest request, HttpServletResponse response) throws IOException {

		Gson gson = new Gson();
		List<Reimbursement> reimbursements = ms.getAllPendingReimbursements();
		String json = gson.toJson(reimbursements);
		
		PrintWriter pw = response.getWriter();
		pw.append(json);
	}
	
	
	//untested
	public static void updateReimbursement(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int reimbursementID = Integer.parseInt(request.getParameter("reimbursementID"));
		int status = Integer.parseInt(request.getParameter("reimbursementStatus"));
		String reimbursementResponse = request.getParameter("response");
		HttpSession sess = request.getSession();
		Employee employee = (Employee) sess.getAttribute("employee");
		Reimbursement reimbursement = new Reimbursement();
		reimbursement.setManagerID(employee.getId());
		//reimbursement.setManagerID(1);
		reimbursement.setReimbursementID(reimbursementID);
		reimbursement.setResponse(reimbursementResponse);
		reimbursement.setStatus(status);
		Gson gson = new Gson();
		Reimbursement actual = ms.updateReimbursement(reimbursement);
		String json = gson.toJson(actual);
		
		PrintWriter pw = response.getWriter();
		pw.append(json);
	}
	
	public static void getStats(HttpServletRequest request, HttpServletResponse response) throws IOException {
		StatisticsServices ss = StatisticsServicesImpl.getStatisticsServices();
		Gson gson = new Gson();
		Statistics stats = ss.populateAll();
		String json = gson.toJson(stats);
		
		PrintWriter pw = response.getWriter();
		pw.append(json);
	}

}
