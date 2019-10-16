package dev.greene.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import dev.greene.entities.Employee;
import dev.greene.entities.Reimbursement;
import dev.greene.services.EmployeeServices;
import dev.greene.services.EmployeeServicesImpl;


public class EmployeeController {
		private static EmployeeServices es = EmployeeServicesImpl.getEmployeeServices();
			
		public static void loginEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
			
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			Employee employee = new Employee();
			employee.setUsername(username);
			employee.setPassword(password);
			Employee actual = es.login(employee);
			
			Gson gson = new Gson();
			String json = gson.toJson(actual);
			HttpSession sess = request.getSession();
			sess.setAttribute("employee", actual);
			
			PrintWriter pw = response.getWriter();
			pw.append(json);
			
		}
		
		public static void allReimbursements(HttpServletRequest request, HttpServletResponse response) throws IOException {
	
			HttpSession sess = request.getSession();
			Employee employee = (Employee) sess.getAttribute("employee");
			System.out.println("allReimbursements called");

			
			Gson gson = new Gson();
			List<Reimbursement> reimbursements = es.getReimbursements(employee);
			System.out.println(employee);
			String json = gson.toJson(reimbursements);
			
			PrintWriter pw = response.getWriter();
			pw.append(json);
			System.out.println(json);
		}
		
		public static void createReimbursement(HttpServletRequest request, HttpServletResponse response) {
			System.out.println("create reimbursement called in employee controller");
			HttpSession sess = request.getSession();
			Employee employee = (Employee) sess.getAttribute("employee");
			int employeeID = employee.getId();
//			int employeeID = 8;
			Reimbursement reimbursement = new Reimbursement();
			double amount = Double.parseDouble(request.getParameter("amount"));
			String title = request.getParameter("title");
			String comment = request.getParameter("comment");
			System.out.println(comment);
			reimbursement.setEmployeeID(employeeID);
			reimbursement.setAmount(amount);
			reimbursement.setTitle(title);
			reimbursement.setComment(comment);
			System.out.println(reimbursement);
			boolean worked = es.requestReimbursement(reimbursement);
			System.out.println(worked);
			
			Gson gson = new Gson();
			String json = gson.toJson(worked);
			
			
			PrintWriter pw = null;
			try {
				pw = response.getWriter();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			pw.append(json);

		}

}
