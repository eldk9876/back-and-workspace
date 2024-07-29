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

/* Factory Method Pattern
 * - 추상화된 클래스의 객체(구상객체, 실체 클래스)를 생성하고 반환하는 방법
 * 
 * 1) 구상객체를 실질적으로 생성하는 곳은 싱글톤 패턴으로 작성된 Factory(공장)에서 진행된다.
 * 	  이때 넘어오는 command 값에 따라서 서로 다른 구상객체가 만들어진다.
 * 	  정작 사용자(Client)에게는 추상화된 클래스로 날아간다.
 * 
 * --> 결국 클라이언트는 Factory로 하여금 구상객체를 만들도록 요청하는 것이고
 * 		Factory는 요청에 해당하는 제품을 만들고 인터페이스로 전달한다.
 * 
 * 
 * 2) 인터페이스의 메서드를 호출하면
 * 	  실질적으로 생성된 구상객체가 핵심적인 일(비즈니스 로직 호출) 진행
 * 	  최종적으로 뷰(화면)의 경로를 리턴받는다.
 * 
 * --> forward or sendRedirect로 응답
 * 
 * 
 * */



@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	MemberDAO dao = new MemberDAO();

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// hidden 값으로 들어온 요청을 받지 않고... 들어온 요청의 주소를 직접 인식시킨다.
		String requestURI = request.getRequestURI();
		System.out.println("RequestURI : " + requestURI);
		
		String[] requestURIList = requestURI.split("/");
		String command = requestURIList[requestURIList.length -1 ];
		System.out.println("command : " + command);
		
		Controller controller = HandlerMapping.getInstance().createController(command);
		
		try {
			ModelAndView mv = controller.handle(request, response);
			if(mv !=null) {
				if(mv.isRedirect()) response.sendRedirect(mv.getPath());
				else request.getRequestDispatcher(mv.getPath()).forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	

	/*

	protected String register(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberDAO dao = new MemberDAO();
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		MemberEx member = new MemberEx(id,password,name);
		
		dao.register(id,password,name);
		
		return "index.jsp";
	}
	
	*/
	/*
	protected String login(HttpServletRequest request, HttpServletResponse response) throws Exception {
	String id = request.getParameter("id"); 
	String password = request.getParameter("password"); 
	MemberDAO dao = new MemberDAO();

	MemberEx member = dao.login(id, password);
		
		// 바인딩 - Session
		HttpSession session = request.getSession();

		session.setAttribute("member", member); // 키, 값 순서
		 
		return "index.jsp";
		
	//	request.getRequestDispatcher("index.jsp").forward(request, response);

}
	*/
	/*
protected String search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		
	MemberDAO dao = new MemberDAO();
		String id = request.getParameter("id"); 

	
			MemberEx member = dao.search(id);
			
			if(member != null) {
				
				request.setAttribute("member", member);
				return "/views/search_ok.jsp";

			} else {
				return "/views/search_fail.jsp";
			}
			

	}
*/
/*
	protected String allmember(HttpServletRequest request, HttpServletResponse response) throws Exception {

		MemberDAO dao = new MemberDAO();
		List<MemberEx>list = dao.all();
		
		request.setAttribute("list", list);

	return "/views/allMember.jsp";
	
}*/
	/*
	protected String logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		MemberEx member = (MemberEx) session.getAttribute("member");
		if(member != null) {
			session.invalidate();
		}
		return "index.jsp";
		
	}

*/

}

	
	
	
	
	
	
	
	
	
	
	
	


	
		
	
	

