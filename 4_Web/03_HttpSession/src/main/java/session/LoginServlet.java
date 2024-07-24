package session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.vo.Member;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 폼 값 받는다 
		String id = request.getParameter("id"); 
		String password = request.getParameter("password"); 
		
		// DAO 생략 .. 로그인 성공했다 가정!
		
		Member member = new Member(id,password,"테스트");
		
		// HttpSession <- 클래스 명칭이
		// 1) 세션을 하나 받아온다
		HttpSession session = request.getSession();
		
		// 2) 세션에 바인딩
		session.setAttribute("info", member); // 키, 값 순서
		 
		// 네비게이션
		response.sendRedirect("product");
		
		
		/*
		// 1. 세션 받아온다.
				HttpSession session = request.getSession();
				
				// 2. 세션에 바인딩 된 값이 있다면 그 값을 찾아온다.
				Member member = (Member) session.getAttribute("info");
				
				request.setAttribute("product", "notebook");
				
				
				//System.out.println("member");
				//response.sendRedirect("cart");
				request.getRequestDispatcher("cart").forward(request, response);
		*/
		
	}

}
