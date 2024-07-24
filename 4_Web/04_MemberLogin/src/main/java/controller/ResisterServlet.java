package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DAO.ex.MemberDAO;
import model.vo.ex.MemberEx;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/resister")
public class ResisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		
		MemberDAO dao = new MemberDAO();
		try {
			dao.register(id,password,name);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		response.sendRedirect("index.jsp");
	}
	
}
