package dev.greene.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.greene.controllers.EmployeeController;

public class MasterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MasterServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String uri = request.getRequestURI();
		System.out.println(uri);
		switch(uri) {
		
			case "/AMWatch/login.do" : {EmployeeController.loginEmployee(request, response);} break;
			case "/AMWatch/getReimbursements.do" : {EmployeeController.allReimbursements(request, response);} break;
			case "/AMWatch/createReimbursement.do" : {EmployeeController.createReimbursement(request, response); } break;
		}

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
