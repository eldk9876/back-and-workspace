package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.vo.ex.MemberEx;

import java.io.IOException;

@WebServlet("/logout")
public class LogoutSrevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberEx member = (MemberEx) session.getAttribute("member");
		if(member != null) {
			session.invalidate();
		}
		response.sendRedirect("/");
		
	}

}
