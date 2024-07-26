package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.DAO.ex.MemberDAO;
import model.vo.ex.MemberEx;

import java.io.IOException;
import java.sql.SQLException;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 폼 값 받는다 
				String id = request.getParameter("id"); 
				String password = request.getParameter("password"); 
				
				
				MemberDAO dao = new MemberDAO();
				
				MemberEx member;
				try {
					member = dao.login(id, password);
					
					// 바인딩 - Session
					HttpSession session = request.getSession();

					session.setAttribute("member", member); // 키, 값 순서
					 
					response.sendRedirect("index.jsp");
					
				//	request.getRequestDispatcher("index.jsp").forward(request, response);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			
				
	}

}
