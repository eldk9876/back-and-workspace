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

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String id = request.getParameter("id"); 

		
		MemberDAO dao = new MemberDAO();
		
	
		try {
			MemberEx member = dao.search(id);
			
			if(member != null) {
				
				request.setAttribute("member", member);
				request.getRequestDispatcher("/views/search_ok.jsp").forward(request, response);

					
			} else {
				response.sendRedirect("/views/search_fail.jsp");
			}
			
			
		//	request.getRequestDispatcher("index.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
	}

}
