package controller.component;

import controller.Controller;
import controller.ModelAndView;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.DAO.ex.MemberDAO;
import model.vo.ex.MemberEx;

public class LoginController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String id = request.getParameter("id"); 
		String password = request.getParameter("password"); 
		MemberDAO dao = new MemberDAO();

		MemberEx member = dao.login(id, password);
			
			// 바인딩 - Session
			HttpSession session = request.getSession();

			session.setAttribute("member", member); // 키, 값 순서
			 
			return new ModelAndView("index.jsp",true);
		
		
		
	}

}
