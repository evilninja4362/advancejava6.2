package com.nagarro.bookmanagement.services;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.nagarro.bookmanagement.dao.LoginDao;
import com.nagarro.bookmanagement.entity.Bean;



/**
 * Servlet implementation class LoginServlet
 */
@Component
public class LoginServices extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginDao loginDao;

	public void init() {
		loginDao = new LoginDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("userName");
		String password = request.getParameter("password");
		Bean loginBean = new Bean();
		loginBean.setUsername(username);
		loginBean.setPassword(password);

		try {
			if (loginDao.validate(loginBean)) {

				response.sendRedirect("product-form.jsp");
			} else {

				response.sendRedirect("login.jsp");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
