package controller.component;

import controller.Controller;
import controller.ModelAndView;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DAO.ex.MemberDAO;
import model.vo.ex.MemberEx;

/*
 * 컴포넌트
 * - 인터패이스 기반으로 작성된 재사용성이 강한 자바 클래스
 * 
 * 
 * */
public class RegisterController implements Controller {



	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberDAO dao = new MemberDAO();
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		MemberEx member = new MemberEx(id,password,name);
		
		dao.register(id,password,name);
		
		return new ModelAndView("index.jsp",true);
	
	
	
}
}