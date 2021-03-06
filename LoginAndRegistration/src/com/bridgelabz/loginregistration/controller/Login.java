package com.bridgelabz.loginregistration.controller;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.bridgelabz.loginregistration.dao.LoginDao;
/**************************************************************************************************
 * @author 	Pramila05263
 * Purpose	Code to Login the User
 *
 ***********************************************************************************************/
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
											throws ServletException, IOException {
		
		String user = request.getParameter("userName");
		String passw = request.getParameter("password");
		LoginDao logindao = new LoginDao();
		
		// if(userName.equals("Pramila") && password.equals("pramila0526"))
		try {
			// Checks Whether user exists
			if (logindao.check(user, passw)) {
				HttpSession session = request.getSession();
				session.setAttribute("uname", user);
				response.sendRedirect("welcome.jsp");
			} else {

				response.sendRedirect("login1.jsp");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
