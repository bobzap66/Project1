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
		
public static void getEmployeeInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
			
			HttpSession sess = request.getSession();
			Employee employee = (Employee) sess.getAttribute("employee");
			Gson gson = new Gson();
			String json = gson.toJson(employee);
			PrintWriter pw = response.getWriter();
			pw.append(json);
			
		}
		
		public static void allReimbursements(HttpServletRequest request, HttpServletResponse response) throws IOException {
	
			HttpSession sess = request.getSession();
			Employee employee = (Employee) sess.getAttribute("employee");

			
			Gson gson = new Gson();
			List<Reimbursement> reimbursements = es.getReimbursements(employee);

			String json = gson.toJson(reimbursements);
			
			PrintWriter pw = response.getWriter();
			pw.append(json);

		}
		
		public static void createReimbursement(HttpServletRequest request, HttpServletResponse response) {
			HttpSession sess = request.getSession();
			Employee employee = (Employee) sess.getAttribute("employee");
			int employeeID = employee.getId();

			Reimbursement reimbursement = new Reimbursement();
			double amount = Double.parseDouble(request.getParameter("amount"));
			String title = request.getParameter("title");
			String comment = request.getParameter("comment");

			reimbursement.setEmployeeID(employeeID);
			reimbursement.setAmount(amount);
			reimbursement.setTitle(title);
			reimbursement.setComment(comment);

			boolean worked = es.requestReimbursement(reimbursement);

			
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
		public static void logout(HttpServletRequest request, HttpServletResponse response) {
			HttpSession sess = request.getSession();
			sess.invalidate();
		}
}
