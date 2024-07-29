package controller.component;

import java.util.List;

import controller.Controller;
import controller.ModelAndView;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DAO.ex.MemberDAO;
import model.vo.ex.MemberEx;

public class AllMemberController implements Controller{

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		MemberDAO dao = new MemberDAO();
		List<MemberEx>list = dao.all();
		
		request.setAttribute("list", list);

	return new ModelAndView("/views/allMember.jsp"); // request가 필요할때는 경로만 사용
		
		
	}

}
