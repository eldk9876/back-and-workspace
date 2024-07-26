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
import java.util.List;

@WebServlet("/front")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	/*
	 * Container에서 Servlet을  하나로 만들자! Front Controller Pattern
	 * 
	 * 소프트웨어 디자인 패턴 중 하나로 웹 애플리케이션 등에서 사용되는 패턴 중 하나 
	 * 애플리케이션의 진입점을 중알집중화하여 요청을 처리하고, 전체적인 흐름을 제어하는 역할
	 * 
	 * -DispatcherServlet은 자바 기반의 웹 애플리케이션에서 FrontControolerPattern을 구현하는데 사용되는 핵심 컴포넌트
	 * 
	 * -SpringFramerwork와 관련된 개념으로 많이 사용되는데 SpringMVC의 일부로 동작하며 웹 요청을 받아서 적절한
	 *  핸들러(컴트롤러)로 라우팅하고, 해당 컨트롤러의 실행 및 응답 생성 등을 관리
	 * 
	 * 코드 유지보수성을 위해서 바꿈!! 그리고 스프링 프레임워크 구조dlrleh gka 
	 * */
	
	MemberDAO dao = new MemberDAO();

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청이 어디에서 들어온 요청인지 값을 하나 더 받는다 - command
		String command = request.getParameter("command");
		String path = "/";
		
			try {
				if(command.equals("register")) {
					path= register(request,response);
							
				request.getRequestDispatcher(path).forward(request, response);
				
			} else if(command.equals("login")) {
							
				path= login(request,response);
								
				request.getRequestDispatcher(path).forward(request, response);
				
		
			}  else if (command.equals("search")) {
				
				path= search(request,response);
				request.getRequestDispatcher(path).forward(request, response);
			} else if(command.equals("allmember")) {
				
				path= allmember(request,response);
				request.getRequestDispatcher(path).forward(request, response);
			} else if (command.equals("logout")) {
				
				
				path= logout(request,response);
				
				request.getRequestDispatcher(path).forward(request, response);
				
			}
				
				
			}catch (Exception e) {
				request.getRequestDispatcher("/").forward(request, response);
			
		}
			
	
	
	}
	

	

	protected String register(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		MemberEx member = new MemberEx(id,password,name);
		
		dao.register(id,password,name);
		
		return "index.jsp";
	}
	
	
	
	protected String login(HttpServletRequest request, HttpServletResponse response) throws Exception {
	String id = request.getParameter("id"); 
	String password = request.getParameter("password"); 
	

	MemberEx member = dao.login(id, password);
		
		// 바인딩 - Session
		HttpSession session = request.getSession();

		session.setAttribute("member", member); // 키, 값 순서
		 
		return "index.jsp";
		
	//	request.getRequestDispatcher("index.jsp").forward(request, response);

}
	
	
protected String search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		
		
		String id = request.getParameter("id"); 

	
			MemberEx member = dao.search(id);
			
			if(member != null) {
				
				request.setAttribute("member", member);
				return "/views/search_ok.jsp";

			} else {
				return "/views/search_fail.jsp";
			}
			

	}


	protected String allmember(HttpServletRequest request, HttpServletResponse response) throws Exception {


		List<MemberEx>list = dao.all();
		
		request.setAttribute("list", list);

	return "/views/allMember.jsp";
	
}
	protected String logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		MemberEx member = (MemberEx) session.getAttribute("member");
		if(member != null) {
			session.invalidate();
		}
		return "index.jsp";
		
	}



}

	
	
	
	
	
	
	
	
	
	
	
	


	
		
	
	

