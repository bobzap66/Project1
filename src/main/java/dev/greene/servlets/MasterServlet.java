package dev.greene.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.greene.controllers.EmployeeController;
import dev.greene.controllers.ManagerController;

public class MasterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MasterServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		switch(uri) {
		
			case "/AMWatch/login.do" : {EmployeeController.loginEmployee(request, response);} break;
			case "/AMWatch/getReimbursements.do" : {EmployeeController.allReimbursements(request, response);} break;
			case "/AMWatch/createReimbursement.do" : {EmployeeController.createReimbursement(request, response); } break;
			case "/AMWatch/getEmployeeInfo.do" : {EmployeeController.getEmployeeInfo(request, response);} break;
			case "/AMWatch/getAllReimbursements.do" : {ManagerController.allReimbursements(request, response);} break;
			case "/AMWatch/getPendingReimbursements.do" : {ManagerController.pendingReimbursements(request, response);} break;
			case "/AMWatch/updateReimbursement.do" : {ManagerController.updateReimbursement(request, response);} break;
			case "/AMWatch/logout.do" : {EmployeeController.logout(request, response);} break;
			case "/AMWatch/getStats.do" : {ManagerController.getStats(request, response);} break;
		}

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
